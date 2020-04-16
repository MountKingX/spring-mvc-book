package com.book.mvc.controller;

import com.book.mvc.domain.Account;
import com.book.mvc.domain.AccountDto;
import com.book.mvc.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequestMapping("/account")
@Controller
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(final AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }

    @PostMapping("/login")
    public String processLoginPage(final HttpServletRequest request,
                                   final @RequestParam("username") String inputUsername,
                                   final @RequestParam("password") String inputPassword,
                                   final RedirectAttributes redirectAttributes,
                                   final Model model) {
        // == not logged-in user could not perform logout
        if (isUserLoggedIn(request)) {
            redirectAttributes.addFlashAttribute("page_message", "You already logged in");
            return "redirect:/market/products";
        }

        final Account account = accountService.getAccount(inputUsername);
        if (account == null) {
            model.addAttribute("page_error", "Your input username does not exist");
            return "login";
        }

        final String dbPassword = account.getPassword();
        if (inputPassword == null || !inputPassword.equals(dbPassword)) {
            model.addAttribute("page_error", "Your input password is not right");
            return "login";
        }

        final HttpSession session = request.getSession();
        session.setAttribute("account", account);
        if (account.getRole().equals("ADMIN")) {
            session.setAttribute("admin", account);
        }

        return "redirect:/market/products";
    }

    @GetMapping("/register")
    public String showRegisterPage(final HttpServletRequest request,
                                   final Model model) {
        final Account currentAccount = getLoggedInUser(request);
        if (currentAccount != null && !currentAccount.getRole().equals("ADMIN")) {
            // == logged-In non-Admin user can not register ==
            return "redirect:/market/products";
        }
        model.addAttribute("user", new AccountDto());
        return "register";
    }

    @PostMapping("/register")
    public String processRegisterPage(
            final HttpServletRequest request,
            @Valid final @ModelAttribute("user") AccountDto dto,
            final BindingResult theBindingResult,
            final Model model,
            final RedirectAttributes redirectAttributes
    ) {
        final Account currentAccount = getLoggedInUser(request);
        if (currentAccount != null && !currentAccount.getRole().equals("ADMIN")) {
            // == logged-In non-Admin user can not register ==
            return "redirect:/market/products";
        }

        // == will process Register Form ==
        if (theBindingResult.hasErrors()) {
            model.addAttribute("page_error", "Submission error - please check each form field");
            return "register";
        }

        // make sure username does not exist yet
        if (accountService.getAccount(dto.getUsername()) != null) {
            model.addAttribute("page_error", "Sorry, this username is already exist, please try another one");
            return "register";
        }

        // make sure password == password2
        if (!dto.getPassword().equals(dto.getPassword2())) {
            model.addAttribute("page_error", "Sorry, password confirm is not identical to password, please check it");
            return "register";
        }

        final Account newAccount = mapAccountDtoToAccount(dto);
        accountService.createAccount(newAccount);
        redirectAttributes.addAttribute("page_message",
                "You have successfully created an account, please login here");
        return "redirect:/account/login";
    }

    @RequestMapping("/logout")
    public String logoutPage(final HttpServletRequest request,
                             final RedirectAttributes redirectAttributes) {
        // == not logged-in user could not perform logout
        if (!isUserLoggedIn(request)) {
            redirectAttributes.addFlashAttribute("page_error", "You are not logged in yet");
            return "redirect:/account/login";
        }

        final HttpSession session = request.getSession();
        session.setAttribute("account", null);
        session.setAttribute("admin", null);

        redirectAttributes.addFlashAttribute("page_message", "You have been successfully logged out");
        return "redirect:/account/login";
    }

    static boolean isUserLoggedIn(final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        final Account checkIfLoggedIn = (Account) session.getAttribute("account");
        return checkIfLoggedIn != null;
    }

    public static Account getLoggedInUser(final HttpServletRequest request) {
        final HttpSession session = request.getSession();
        return (Account) session.getAttribute("account");
    }

    public static Account mapAccountDtoToAccount(final AccountDto t) {
        final Account u = new Account();
        u.setUsername(t.getUsername());
        u.setName(t.getName());
        u.setPassword(t.getPassword());
        u.setRole("NORMAL");
        return u;
    }
}
