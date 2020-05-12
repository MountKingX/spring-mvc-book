package com.book.mvc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/market/cart")
public class CartController {

    @RequestMapping
    public String get(final HttpServletRequest request) {
        return "redirect:/market/cart/" + request.getSession(true).getId();
    }

    @RequestMapping(value = "/{cartId}", method = RequestMethod.GET)
    public String getCart(final @PathVariable(value = "cartId") String cartId,
                          final Model model) {
        model.addAttribute("cartId", cartId);
        return "cart";
    }
}
