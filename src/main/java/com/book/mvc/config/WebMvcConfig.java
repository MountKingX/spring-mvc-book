package com.book.mvc.config;

import com.book.mvc.interceptor.AdminPrivilegeHandlerInterceptor;
import com.book.mvc.interceptor.LoginSessionHandlerInterceptor;
import com.book.mvc.interceptor.ProcessingTimeLogInterceptor;

import com.book.mvc.interceptor.PromoCodeInterceptor;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

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

    @Bean
    public HandlerInterceptor promoCodeInterceptor() {
        final PromoCodeInterceptor promoCodeInterceptor = new PromoCodeInterceptor();
        promoCodeInterceptor.setPromoCode("OFF3R");
        promoCodeInterceptor.setOfferRedirect(
                "market/products?message=Redirected from validated promotion code");
        promoCodeInterceptor.setErrorRedirect("invalidPromoCode");
        return promoCodeInterceptor;
    }

    @Bean
    LoginSessionHandlerInterceptor loginSessionFilter() {
        return new LoginSessionHandlerInterceptor();
    }

    @Bean
    AdminPrivilegeHandlerInterceptor adminPrivilegeFilter() {
        return new AdminPrivilegeHandlerInterceptor();
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {

        registry.addInterceptor(loginSessionFilter())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/resources/**",
                        "/webjars/**",
                        "", "/", "/index", "/welcome",
                        "/access-denied",
                        "/account/login",
                        "/account/register",
                        "/account/logout");

        registry.addInterceptor(adminPrivilegeFilter())
                .addPathPatterns("/private/**");

        //registry.addInterceptor(processingTimeLogInterceptor());

        registry.addInterceptor(localeChangeInterceptor());

        registry.addInterceptor(promoCodeInterceptor())
                .addPathPatterns("/**/market/products/specialOffer");
    }

    @Bean
    public LocaleResolver localeResolver() {
        final SessionLocaleResolver resolver = new SessionLocaleResolver();
        resolver.setDefaultLocale(new Locale("en"));
        return resolver;
    }

    @Bean
    public CommonsMultipartResolver multipartResolver() {
        final CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }

    //    @Bean
    //    public MappingJackson2JsonView jsonView() {
    //        final MappingJackson2JsonView jsonView = new MappingJackson2JsonView();
    //        jsonView.setPrettyPrint(true);
    //        return jsonView;
    //    }
    //
    //    @Bean
    //    public MarshallingView xmlView() {
    //        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    //        marshaller.setClassesToBeBound(Product.class);
    //        return new MarshallingView(marshaller);
    //    }
    //
    //    @Bean
    //    public ViewResolver contentNegotiatingViewResolver(final ContentNegotiationManager manager) {
    //        final ContentNegotiatingViewResolver resolver = new ContentNegotiatingViewResolver();
    //        resolver.setContentNegotiationManager(manager);
    //        final ArrayList<View> views = new ArrayList<>();
    //        views.add(jsonView());
    //        views.add(xmlView());
    //        resolver.setDefaultViews(views);
    //        return resolver;
    //  }
}
