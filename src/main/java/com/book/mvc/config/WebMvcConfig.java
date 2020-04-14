package com.book.mvc.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.CacheControl;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean
    public MessageSource messageSource() {
        final ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

//    public final void addResourceHandlers(final ResourceHandlerRegistry registry) {
//
//        // Register resource handler for CSS and JS
//        registry.addResourceHandler("/resources/**")
//                .addResourceLocations("classpath:/static/")
//                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES)
//                        .cachePublic());
//
//        // == In DEV/DEBUG condition, remember to setCache less time (1 minutes) ==
//        // Register resource handler for images
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("classpath:/static/img/")
//                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES)
//                        .cachePublic());
//
//        registry.addResourceHandler("/img/**")
//                .addResourceLocations("/static/img/")
//                .setCacheControl(CacheControl.maxAge(1, TimeUnit.MINUTES)
//                        .cachePublic());
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("/webjars/")
//                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS)
//                        .cachePublic());
//    }


    @Bean
    public CommonsMultipartResolver multipartResolver() {
        final CommonsMultipartResolver resolver = new CommonsMultipartResolver();
        resolver.setDefaultEncoding("utf-8");
        return resolver;
    }
}
