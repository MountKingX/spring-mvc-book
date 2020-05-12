package com.book.mvc.domain.repository.impl;

import com.book.mvc.domain.Product;
import com.book.mvc.domain.repository.ProductRepository;
import com.book.mvc.exception.ProductNotFoundException;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public InMemoryProductRepository(final NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Product> getAllProducts() {
        final Map<String, Object> params = new HashMap<>();
        final List<Product> result
                = jdbcTemplate.query("SELECT * FROM products", params, new ProductMapper());
        return result;
    }

    @Override
    public void updateStock(final String productId, final long noOfUnits) {
        final String sql = "UPDATE PRODUCTS SET UNITS_IN_STOCK = :unitsInStock WHERE ID = :id";
        final Map<String, Object> params = new HashMap<>();
        params.put("unitsInStock", noOfUnits);
        params.put("id", productId);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public List<Product> getProductsByCategory(final String category) {
        final String sql = "SELECT * FROM PRODUCTS WHERE CATEGORY = :category";
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("category", category);
        return jdbcTemplate.query(sql, params, new ProductMapper());
    }

    @Override
    public Product getProductById(final String productId) {
        final String sql = "SELECT * FROM PRODUCTS WHERE ID = :id";
        final Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", productId);
        try {
            return jdbcTemplate.queryForObject(sql, params, new ProductMapper());
        } catch (final DataAccessException e) {
            throw new ProductNotFoundException(productId);
        }
    }

    @Override
    public void addProduct(final Product product) {
        final String sql = "INSERT INTO PRODUCTS (ID, "
                + "NAME,"
                + "DESCRIPTION,"
                + "UNIT_PRICE,"
                + "MANUFACTURER,"
                + "CATEGORY,"
                + "CONDITION,"
                + "UNITS_IN_STOCK,"
                + "UNITS_IN_ORDER,"
                + "DISCONTINUED) "
                + "VALUES (:id, :name, :desc, :price, :manufacturer, "
                + ":category, :condition, :inStock, :inOrder, :discontinued)";
        final Map<String, Object> params = new HashMap<>();
        params.put("id", product.getProductId());
        params.put("name", product.getName());
        params.put("desc", product.getDescription());
        params.put("price", product.getUnitPrice());
        params.put("manufacturer", product.getManufacturer());
        params.put("category", product.getCategory());
        params.put("condition", product.getCondition());
        params.put("inStock", product.getUnitsInStock());
        params.put("inOrder", product.getUnitsInOrder());
        params.put("discontinued", product.isDiscontinued());
        jdbcTemplate.update(sql, params);
    }

    private static final class ProductMapper implements RowMapper<Product> {
        public Product mapRow(final ResultSet rs, final int rowNum) throws SQLException {
            final Product product = new Product();
            product.setProductId(rs.getString("ID"));
            product.setName(rs.getString("NAME"));
            product.setDescription(rs.getString("DESCRIPTION"));
            product.setUnitPrice(rs.getBigDecimal("UNIT_PRICE"));
            product.setManufacturer(rs.getString("MANUFACTURER"));
            product.setCategory(rs.getString("CATEGORY"));
            product.setCondition(rs.getString("CONDITION"));
            product.setUnitsInStock(rs.getLong("UNITS_IN_STOCK"));
            product.setUnitsInOrder(rs.getLong("UNITS_IN_ORDER"));
            product.setDiscontinued(rs.getBoolean("DISCONTINUED"));
            return product;
        }
    }
}
