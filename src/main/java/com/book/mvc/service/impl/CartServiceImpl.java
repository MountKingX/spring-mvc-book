package com.book.mvc.service.impl;

import com.book.mvc.domain.Cart;
import com.book.mvc.domain.repository.CartRepository;
import com.book.mvc.dto.CartDto;
import com.book.mvc.service.CartService;
import org.springframework.stereotype.Service;

@Service
public class CartServiceImpl implements CartService {

    private final CartRepository cartRepository;

    public CartServiceImpl(final CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    public void create(final CartDto cartDto) {
        cartRepository.create(cartDto);
    }

    @Override
    public Cart read(final String id) {
        return cartRepository.read(id);
    }

    @Override
    public void update(final String id, final CartDto cartDto) {
        cartRepository.update(id, cartDto);
    }

    @Override
    public void delete(final String id) {
        cartRepository.delete(id);
    }

    @Override
    public void addItem(final String cartId, final String productId) {
        cartRepository.addItem(cartId, productId);
    }

    @Override
    public void removeItem(final String cartId, final String productId) {
        cartRepository.removeItem(cartId, productId);
    }
}
