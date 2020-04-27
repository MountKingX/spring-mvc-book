package com.book.mvc.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import com.book.mvc.validator.ProductId;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public final class Product implements Serializable {

    private static final long serialVersionUID = 3678107792576131001L;

    @Pattern(regexp = "P[1-9]+", message = "{Pattern.Product.productId.validation}")
    @ProductId
    private String productId;

    @Size(min = 4, max = 50, message = " {Size.Product.name.validation}")
    private String name;

    @Min(value = 0, message = " {Min.Product.unitPrice.validation}")
    @Digits(integer = 8, fraction = 2, message = "{Digits.Product.unitPrice.validation}")
    @NotNull(message = "{NotNull.Product.unitPrice.validation}")
    private BigDecimal unitPrice;

    private String description;
    private String manufacturer;
    private String category;
    private long unitsInStock;
    private long unitsInOrder;
    private boolean discontinued;
    private MultipartFile productImage;
    private String condition;

    public Product() {
        super();
    }

    public Product(final String productId, final String name, final BigDecimal unitPrice) {
        this.productId = productId;
        this.name = name;
        this.unitPrice = unitPrice;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (productId == null) {
            if (other.productId != null) {
                return false;
            }
        } else if (!productId.equals(other.productId)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((productId == null) ? 0 : productId.hashCode());
        return result;
    }
}
