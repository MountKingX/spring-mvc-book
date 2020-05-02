package com.book.mvc.config;

import com.book.mvc.interceptor.ProcessingTimeLogInterceptor;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;


@Import({
        InterceptorConfig.class,
        MessageResourceConfig.class,
        ValidatorConfig.class,
        ViewResolverConfig.class,
})
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    final ProcessingTimeLogInterceptor processingTimeLogInterceptor;
    final LocaleChangeInterceptor localeChangeInterceptor;
    final HandlerInterceptor promoCodeInterceptor;
    final LocalValidatorFactoryBean localValidator;

    public WebMvcConfig(final ProcessingTimeLogInterceptor processingTimeLogInterceptor,
                        final LocaleChangeInterceptor localeChangeInterceptor,
                        @Qualifier("promoCodeInterceptor") final HandlerInterceptor promoCodeInterceptor,
                        @Qualifier("validator") final LocalValidatorFactoryBean localValidator) {
        this.processingTimeLogInterceptor = processingTimeLogInterceptor;
        this.localeChangeInterceptor = localeChangeInterceptor;
        this.promoCodeInterceptor = promoCodeInterceptor;
        this.localValidator = localValidator;
    }

    @Override
    public void addInterceptors(final InterceptorRegistry registry) {

        registry.addInterceptor(processingTimeLogInterceptor);

        registry.addInterceptor(localeChangeInterceptor);

        registry.addInterceptor(promoCodeInterceptor)
                .addPathPatterns("/**/market/products/specialOffer");
    }

    @Override
    public Validator getValidator() {
        return localValidator;
    }
}
