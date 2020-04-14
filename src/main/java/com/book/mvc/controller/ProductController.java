package com.book.mvc.controller;

import com.book.mvc.domain.Product;
import com.book.mvc.service.ProductService;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/market")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/products/update/stock")
    public String updateStock() {
        productService.updateAllStock();
        return "redirect:/products";
    }

    @RequestMapping("/products")
    public String list(final Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(final Model model,
                                        final @PathVariable("category") String productCategory
    ) {
        model.addAttribute("products",
                productService.getProductsByCategory(productCategory));
        return "products";
    }

    @RequestMapping("/product")
    public String getProductById(final @RequestParam("id") String productId,
                                 final Model model) {
        model.addAttribute("product", productService.getProductById(productId));
        return "product";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.GET)
    public String getAddNewProductForm(final Model model) {
        final Product newProduct = new Product();
        model.addAttribute("newProduct", newProduct);
        return "addProduct";
    }

    @RequestMapping(value = "/products/add", method = RequestMethod.POST)
    public String processAddNewProductForm(final @ModelAttribute("newProduct") Product newProduct,
                                           final BindingResult result,
                                           final HttpServletRequest request) {
        final String[] suppressedFields = result.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: "
                    + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }
        final MultipartFile productImage = newProduct.getProductImage();
        final String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        System.out.println("@@@ rootDirectory is: " + rootDirectory);
        if (productImage != null && !productImage.isEmpty()) {
            System.out.println("We are good here");
            final int length = rootDirectory.length();
            System.out.println("@@@ rootDirectory - 7  is: " + rootDirectory.substring(0, length - 8));
            try {
                productImage.transferTo(new
                        File(rootDirectory.substring(0, length - 7) + "resources/static/img/"
                        + newProduct.getProductId() + ".png"));
                System.out.println("\n ==>" + rootDirectory.substring(0, length - 7) + "resources/static/img/");
            } catch (final Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        productService.addProduct(newProduct);
        return "redirect:/market/products";
    }

    @InitBinder
    public void initialiseBinder(final WebDataBinder binder) {
        binder.setAllowedFields("productId",
                "name",
                "unitPrice",
                "description",
                "manufacturer",
                "category",
                "unitsInStock",
                "productImage",
                "condition");
    }
}
