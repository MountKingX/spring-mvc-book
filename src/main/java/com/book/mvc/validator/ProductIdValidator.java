package com.book.mvc.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.book.mvc.domain.Product;
import com.book.mvc.exception.ProductNotFoundException;
import com.book.mvc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductIdValidator implements ConstraintValidator<ProductId, String> {

    @Autowired
    private ProductService productService;

    public void initialize(final ProductId constraintAnnotation) {
        //  intentionally left blank;
        //  this is the place to initialize the constraint annotation for any sensible default values.
    }

    public boolean isValid(final String value, final ConstraintValidatorContext context) {
        final Product product;
        try {
            product = productService.getProductById(value);

        } catch (final ProductNotFoundException e) {
            return true;
        }

        return product == null;
    }
}