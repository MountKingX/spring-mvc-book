package com.book.mvc.validator;

import java.util.HashSet;
import java.util.Set;
import javax.validation.ConstraintViolation;

import com.book.mvc.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    @Qualifier("validator")
    @Autowired
    private javax.validation.Validator beanValidator;

    private Set<Validator> springValidators;

    public ProductValidator() {
        springValidators = new HashSet<>();
    }

    public void setSpringValidators(final Set<Validator> springValidators) {
        this.springValidators = springValidators;
    }

    public boolean supports(final Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(final Object target, final Errors errors) {
        final Set<ConstraintViolation<Object>> constraintViolations = beanValidator.validate(target);

        for (final ConstraintViolation<Object> constraintViolation : constraintViolations) {
            final String propertyPath = constraintViolation.getPropertyPath().toString();
            final String message = constraintViolation.getMessage();
            errors.rejectValue(propertyPath, "", message);
        }

        for (final Validator validator : springValidators) {
            validator.validate(target, errors);
        }
    }
}