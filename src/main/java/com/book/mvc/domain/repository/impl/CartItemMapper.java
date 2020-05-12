package com.book.mvc.domain.repository.impl;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.book.mvc.domain.CartItem;
import com.book.mvc.service.ProductService;
import org.springframework.jdbc.core.RowMapper;


public class CartItemMapper implements RowMapper<CartItem> {

    private final ProductService productService;

    public CartItemMapper(final ProductService productService) {
        this.productService = productService;
    }

    @Override
    public CartItem mapRow(final ResultSet rs, final int rowNum) throws SQLException {
        final CartItem cartItem = new CartItem(rs.getString("ID"));
        cartItem.setProduct(productService.getProductById(rs.getString("PRODUCT_ID")));
        cartItem.setQuantity(rs.getInt("QUANTITY"));

        return cartItem;
    }
}
