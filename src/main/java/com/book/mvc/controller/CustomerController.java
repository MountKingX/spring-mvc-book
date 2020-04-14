package com.book.mvc.controller;

import com.book.mvc.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public final class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping({ "/customers" })
    public String getHome(final Model model) {
        model.addAttribute("customers",  customerService.getAllCustomers());
        return "customers";
    }
}
