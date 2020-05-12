package com.book.mvc.service;

import com.book.mvc.domain.Cart;
import com.book.mvc.dto.CartDto;

public interface CartService {

    void create(final CartDto cartDto);

    Cart read(final String cartId);

    void update(final String cartId, final CartDto cartDto);

    void delete(final String id);

    void addItem(final String cartId, final String productId);

    void removeItem(final String cartId, final String productId);
}
