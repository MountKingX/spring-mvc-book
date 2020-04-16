package com.book.mvc.interceptor;

import com.book.mvc.domain.Account;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AdminPrivilegeHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) throws IOException {
        final HttpSession session = request.getSession();
        final Account account = (Account) session.getAttribute("admin");
        if (account != null) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/access-denied");
            return false;
        }
    }

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) {
        // can do logging & utf-8 here
    }

    @Override
    public void afterCompletion(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final Object handler,
                                final Exception ex) {
        // can also do logging & utf-8 here
    }
}