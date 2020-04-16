package com.book.mvc.controller;

import com.book.mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import static com.book.mvc.controller.AccountController.getLoggedInUser;

@RequestMapping("/private/admin")
@Controller
public class AdminController {

    private final AccountService accountService;

    @Autowired
    public AdminController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("")
    public String showLoginPage(final HttpServletRequest request,
                                final Model model) {
        model.addAttribute("users", accountService.getAllAccounts());
        model.addAttribute("account", getLoggedInUser(request));
        return "admin";
    }
}
