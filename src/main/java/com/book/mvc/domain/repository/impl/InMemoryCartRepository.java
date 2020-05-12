package com.book.mvc.domain.repository.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.book.mvc.domain.Cart;
import com.book.mvc.domain.CartItem;
import com.book.mvc.domain.Product;
import com.book.mvc.domain.repository.CartRepository;
import com.book.mvc.dto.CartDto;
import com.book.mvc.dto.CartItemDto;
import com.book.mvc.service.ProductService;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository
public class InMemoryCartRepository implements CartRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final ProductService productService;

    public InMemoryCartRepository(final NamedParameterJdbcTemplate jdbcTemplate,
                                  final ProductService productService) {
        this.jdbcTemplate = jdbcTemplate;
        this.productService = productService;
    }

    public void create(final CartDto cartDto) {

        final String insertCartSql = "INSERT INTO CART(ID) VALUES (:id)";

        final Map<String, Object> cartParams = new HashMap<String, Object>();
        cartParams.put("id", cartDto.getId());

        jdbcTemplate.update(insertCartSql, cartParams);

        cartDto.getCartItems().stream().forEach(cartItemDto -> {

            final Product productById = productService.getProductById(cartItemDto.getProductId());

            final String insertCartItemSql = "INSERT INTO CART_ITEM(ID,PRODUCT_ID,CART_ID,QUANTITY) "
                    + "VALUES (:id, :product_id, :cart_id, :quantity)";

            final Map<String, Object> cartItemsParams = new HashMap<String, Object>();
            cartItemsParams.put("id", cartItemDto.getId());
            cartItemsParams.put("product_id", productById.getProductId());
            cartItemsParams.put("cart_id", cartDto.getId());
            cartItemsParams.put("quantity", cartItemDto.getQuantity());

            jdbcTemplate.update(insertCartItemSql, cartItemsParams);
        });
    }

    public Cart read(final String id) {
        final String sql = "SELECT * FROM CART WHERE ID = :id";
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);
        final CartMapper cartMapper = new CartMapper(jdbcTemplate, productService);

        try {
            return jdbcTemplate.queryForObject(sql, params, cartMapper);
        } catch (final EmptyResultDataAccessException e) {
            return null;
        }
    }


    @Override
    public void update(final String id, final CartDto cartDto) {

        final List<CartItemDto> cartItems = cartDto.getCartItems();
        for (final CartItemDto cartItem : cartItems) {

            final String sql
                    = "UPDATE CART_ITEM SET QUANTITY = :quantity,  PRODUCT_ID = :productId "
                    + "WHERE ID = :id AND CART_ID = :cartId";
            final Map<String, Object> params = new HashMap<String, Object>();
            params.put("id", cartItem.getId());
            params.put("quantity", cartItem.getQuantity());
            params.put("productId", cartItem.getProductId());
            params.put("cartId", id);

            jdbcTemplate.update(sql, params);
        }
    }

    @Override
    public void delete(final String id) {
        final String sqlDeleteCartItem = "DELETE FROM CART_ITEM WHERE CART_ID = :id";
        final String sqlDeleteCart = "DELETE FROM CART WHERE ID = :id";

        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", id);

        jdbcTemplate.update(sqlDeleteCartItem, params);
        jdbcTemplate.update(sqlDeleteCart, params);
    }

    @Override
    public void addItem(final String cartId, final String productId) {

        String sql = null;
        Cart cart = null;

        cart = read(cartId);
        if (cart == null) {
            final CartItemDto newCartItemDto = new CartItemDto();
            newCartItemDto.setId(cartId + productId);
            newCartItemDto.setProductId(productId);
            newCartItemDto.setQuantity(1);

            final CartDto newCartDto = new CartDto(cartId);
            newCartDto.addCartItem(newCartItemDto);
            create(newCartDto);
            return;
        }

        final Map<String, Object> cartItemsParams = new HashMap<String, Object>();

        if (cart.getItemByProductId(productId) == null) {
            sql = "INSERT INTO CART_ITEM (ID, PRODUCT_ID, CART_ID, QUANTITY) "
                    + "VALUES (:id, :productId, :cartId, :quantity)";
            cartItemsParams.put("id", cartId + productId);
            cartItemsParams.put("quantity", 1);
        } else {
            sql = "UPDATE CART_ITEM SET QUANTITY = :quantity WHERE CART_ID = :cartId AND PRODUCT_ID = :productId";
            final CartItem existingItem = cart.getItemByProductId(productId);
            cartItemsParams.put("id", existingItem.getId());
            cartItemsParams.put("quantity", existingItem.getQuantity() + 1);
        }

        cartItemsParams.put("productId", productId);
        cartItemsParams.put("cartId", cartId);

        jdbcTemplate.update(sql, cartItemsParams);
    }

    @Override
    public void removeItem(final String cartId, final String productId) {
        final String sql = "DELETE FROM CART_ITEM WHERE PRODUCT_ID = :productId AND CART_ID = :id";

        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", cartId);
        params.put("productId", productId);

        jdbcTemplate.update(sql, params);
    }
}
