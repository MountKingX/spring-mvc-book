package com.book.mvc.domain.repository;

import com.book.mvc.domain.Product;

import java.util.List;

public interface ProductRepository {

    List<Product> getAllProducts();

    void updateStock(final String productId, final long noOfUnits);

    List<Product> getProductsByCategory(final String category);

    Product getProductById(final String productID);

    void addProduct(final Product product);
}
