package com.book.mvc.service;

import com.book.mvc.domain.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void updateAllStock();

    List<Product> getProductsByCategory(final String category);

    Product getProductById(final String productID);

    void addProduct(final Product product);
}
