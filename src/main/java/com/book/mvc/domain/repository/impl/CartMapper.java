package com.book.mvc.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.book.mvc.domain.Cart;
import com.book.mvc.domain.CartItem;
import com.book.mvc.service.ProductService;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;


public class CartMapper implements RowMapper<Cart> {

    private final CartItemMapper cartItemMapper;
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CartMapper(final NamedParameterJdbcTemplate jdbcTemplate,
                      final ProductService productService) {
        this.jdbcTemplate = jdbcTemplate;
        cartItemMapper = new CartItemMapper(productService);
    }

    public Cart mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final String id = rs.getString("ID");
        final Cart cart = new Cart(id);

        final String sql = String.format("SELECT * FROM CART_ITEM WHERE CART_ID = '%s'", id);
        final List<CartItem> cartItems = jdbcTemplate.query(sql, cartItemMapper);
        cart.setCartItems(cartItems);
        return cart;
    }
}
