package com.book.mvc.service.impl;

import com.book.mvc.domain.Product;
import com.book.mvc.domain.repository.ProductRepository;
import com.book.mvc.service.ProductService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public void updateAllStock() {
        final List<Product> allProducts = productRepository.getAllProducts();
        for (final Product product : allProducts) {
            if (product.getUnitsInStock() < 500) {
                productRepository.updateStock(product.getProductId(), product.getUnitsInStock() + 1000);
            }
        }
    }

    public List<Product> getProductsByCategory(final String category) {
        return productRepository.getProductsByCategory(category);
    }

    @Override
    public Product getProductById(final String productID) {
        return productRepository.getProductById(productID);
    }

    @Override
    public void addProduct(final Product product) {
        productRepository.addProduct(product);
    }
}
