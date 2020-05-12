package com.book.mvc.controller;

import javax.servlet.http.HttpSession;

import com.book.mvc.domain.Cart;
import com.book.mvc.dto.CartDto;
import com.book.mvc.service.CartService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "rest/cart")
public class CartRestController {

    private final CartService cartService;

    public CartRestController(final CartService cartService) {
        this.cartService = cartService;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void create(final @RequestBody CartDto cartDto) {
        cartService.create(cartDto);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public Cart read(final @PathVariable(value = "cartId") String cartId) {
        return cartService.read(cartId);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void update(final @PathVariable(value = "cartId") String cartId,
                       final @RequestBody CartDto cartDto) {
        cartDto.setId(cartId);
        cartService.update(cartId, cartDto);
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void delete(final @PathVariable(value = "cartId") String cartId) {
        cartService.delete(cartId);
    }

    @RequestMapping(value = "/add/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void addItem(final @PathVariable String productId,
                        final HttpSession session) {
        cartService.addItem(session.getId(), productId);
    }

    @RequestMapping(value = "/remove/{productId}", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.OK)
    public void removeItem(final @PathVariable String productId,
                           final HttpSession session) {
        cartService.removeItem(session.getId(), productId);
    }
}
