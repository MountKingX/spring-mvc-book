package com.book.mvc.interceptor;

import com.book.mvc.domain.Account;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSessionHandlerInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) throws IOException {
        final HttpSession session = request.getSession();
        final Account account = (Account) session.getAttribute("account");
        if (account != null) {
            return true;
        } else {
            response.sendRedirect(request.getContextPath() + "/account/login");
            return false;
        }
    }

    @Override
    public void postHandle(final HttpServletRequest request,
                           final HttpServletResponse response,
                           final Object handler,
                           final ModelAndView modelAndView) {
        // System.out.println("postHandle");
        // log
    }

    @Override
    public void afterCompletion(final HttpServletRequest request,
                                final HttpServletResponse response,
                                final Object handler,
                                final Exception ex) {
        // System.out.println("afterCompletion");
        // utf-8
    }
}
