package com.book.mvc.config;

import com.book.mvc.validator.ProductValidator;
import com.book.mvc.validator.UnitsInStockValidator;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import java.util.HashSet;
import java.util.Set;

@Import({
        MessageResourceConfig.class,
})
@Configuration
public class ValidatorConfig {

    private final MessageSource messageSource;

    public ValidatorConfig(final MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @Bean(name = "validator")
    public LocalValidatorFactoryBean validator() {
        final LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @Bean
    public ProductValidator productValidator() {
        final Set<Validator> springValidators = new HashSet<>();
        springValidators.add(new UnitsInStockValidator());
        final ProductValidator productValidator = new ProductValidator();
        productValidator.setSpringValidators(springValidators);
        return productValidator;
    }
}
