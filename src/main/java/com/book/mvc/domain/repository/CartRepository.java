package com.book.mvc.domain.repository;

import com.book.mvc.domain.Cart;
import com.book.mvc.dto.CartDto;

public interface CartRepository {

    void create(final CartDto cartDto);

    Cart read(final String id);

    void update(final String id, final CartDto cartDto);

    void delete(final String id);

    void addItem(final String cartId, final String productId);

    void removeItem(final String cartId, final String productId);
}
