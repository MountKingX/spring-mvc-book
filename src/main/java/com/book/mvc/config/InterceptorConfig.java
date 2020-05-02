package com.book.mvc.config;

import com.book.mvc.interceptor.ProcessingTimeLogInterceptor;
import com.book.mvc.interceptor.PromoCodeInterceptor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

@Configuration
public class InterceptorConfig {

    @Bean
    public ProcessingTimeLogInterceptor processingTimeLogInterceptor() {
        return new ProcessingTimeLogInterceptor();
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        final LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }

    @Qualifier("promoCodeInterceptor")
    @Bean
    public HandlerInterceptor promoCodeInterceptor() {
        final PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
        promoCodeInterceptor.setPromoCode("OFF3R");
        promoCodeInterceptor.setOfferRedirect(
                "market/products?message=Redirected from validated promotion code");
        promoCodeInterceptor.setErrorRedirect("invalidPromoCode");
        return promoCodeInterceptor;
    }
}
