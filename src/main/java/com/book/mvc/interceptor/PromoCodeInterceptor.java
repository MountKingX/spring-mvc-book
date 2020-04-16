package com.book.mvc.interceptor;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class PromoCodeInterceptor extends HandlerInterceptorAdapter {

    private String promoCode;
    private String errorRedirect;
    private String offerRedirect;

    public boolean preHandle(final HttpServletRequest request,
                             final HttpServletResponse response,
                             final Object handler) throws IOException {
        final String givenPromoCode = request.getParameter("promo");
        if (promoCode.equalsIgnoreCase(givenPromoCode)) {
            response.sendRedirect(request.getContextPath() + "/" + offerRedirect);
        } else {
            response.sendRedirect(errorRedirect);
        }
        return false;
    }

    public void setPromoCode(final String promoCode) {
        this.promoCode = promoCode;
    }

    public void setErrorRedirect(final String errorRedirect) {
        this.errorRedirect = errorRedirect;
    }

    public void setOfferRedirect(final String offerRedirect) {
        this.offerRedirect = offerRedirect;
    }
}
