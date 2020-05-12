package com.book.mvc.dto;

import java.io.Serializable;

public class CartItemDto implements Serializable {

    private static final long serialVersionUID = -3551573319376880896L;

    private String id;
    private String productId;
    private int quantity;

    public String getId() {
        return id;
    }

    public void setId(final String id) {
        this.id = id;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(final String productId) {
        this.productId = productId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(final int quantity) {
        this.quantity = quantity;
    }
}
