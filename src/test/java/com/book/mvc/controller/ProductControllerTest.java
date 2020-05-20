
package com.book.mvc.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.math.BigDecimal;

import com.book.mvc.MvcApplication;
import com.book.mvc.domain.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = MvcApplication.class)
@WebAppConfiguration
public class ProductControllerTest {

    @Autowired
    private ProductController pc;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/jsp/view/");
        viewResolver.setSuffix(".jsp");

        this.mockMvc = MockMvcBuilders.standaloneSetup(pc)
                .setViewResolvers(viewResolver)
                .build();
    }

    @Test
    public void testGetProducts() throws Exception {
        this.mockMvc.perform(get("/market/products"))
                .andExpect(model().attributeExists("products"));
    }

    @Test
    public void testGetProductById() throws Exception {
        //Arrange
        Product product = new Product("P1234", "iPhone 5s", new BigDecimal(500));

        //Act & Assert
        this.mockMvc.perform(get("/market/product")
                .param("id", "P1234"))
                .andExpect(model().attributeExists("product"))
                .andExpect(model().attribute("product", product));
    }

}
