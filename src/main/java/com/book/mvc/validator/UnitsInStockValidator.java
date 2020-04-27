package com.book.mvc.validator;

import java.math.BigDecimal;

import com.book.mvc.domain.Product;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class UnitsInStockValidator implements Validator {

    public boolean supports(final Class<?> clazz) {
        return Product.class.isAssignableFrom(clazz);
    }

    public void validate(final Object target, final Errors errors) {
        final Product product = (Product) target;

        if (product.getUnitPrice() != null
                && new BigDecimal(1000).compareTo(product.getUnitPrice()) <= 0
                && product.getUnitsInStock() > 99) {
            errors.rejectValue("unitsInStock", "com.book.mvc.validator.UnitsInStockValidator.message");
        }
    }

}