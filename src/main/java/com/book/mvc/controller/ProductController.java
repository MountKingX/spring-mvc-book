package com.book.mvc.controller;

import com.book.mvc.domain.Product;
import com.book.mvc.exception.NoProductsFoundUnderCategoryException;
import com.book.mvc.exception.ProductNotFoundException;
import com.book.mvc.service.ProductService;

import com.book.mvc.validator.ProductValidator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@Controller
@RequestMapping("/market")
public class ProductController {

    private final ProductService productService;
    private final ProductValidator productValidator;

    ProductController(final ProductService productService,
                      final ProductValidator productValidator) {
        this.productService = productService;
        this.productValidator = productValidator;
    }

    @RequestMapping("/products")
    public String list(final Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "products";
    }

    @PostMapping("/products/update/stock")
    public String updateStock(final RedirectAttributes redirectAttributes) {
        productService.updateAllStock();
        redirectAttributes.addFlashAttribute("page_message",
                "You have successfully updated the stock for # < 500 items!");
        return "redirect:/market/products";
    }

    @RequestMapping("/products/{category}")
    public String getProductsByCategory(final @PathVariable("category") String productCategory,
                                        final Model model) {
        final List<Product> products = productService.getProductsByCategory(productCategory);
        if (products == null || products.isEmpty()) {
            throw new NoProductsFoundUnderCategoryException();
        }
        model.addAttribute("products", products);
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
    public String processAddNewProductForm(final @ModelAttribute("newProduct") @Valid Product newProduct,
                                           final BindingResult result,
                                           final RedirectAttributes redirectAttributes,
                                           final HttpServletRequest request) {
        final String[] suppressedFields = result.getSuppressedFields();

        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempting to bind disallowed fields: "
                    + StringUtils.arrayToCommaDelimitedString(suppressedFields));
        }

        // == form validation ==
        if (result.hasErrors()) {
            return "addProduct";
        }

        final MultipartFile productImage = newProduct.getProductImage();
        final String rootDirectory = request.getSession().getServletContext().getRealPath("/WEB-INF");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(rootDirectory + "/static/img/"
                        + newProduct.getProductId() + ".png"));
            } catch (final Exception e) {
                throw new RuntimeException("Product Image saving failed", e);
            }
        }
        productService.addProduct(newProduct);
        redirectAttributes.addFlashAttribute("page_message",
                "You have successfully added a new product item - " + newProduct.getName() + " !");
        return "redirect:/market/products";
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public String handleError(final HttpServletRequest req,
                              final Model model,
                              final ProductNotFoundException exception) {
        model.addAttribute("invalidProductId", exception.getProductId());
        model.addAttribute("exception", exception);
        model.addAttribute("url", req.getRequestURL() + "?" + req.getQueryString());
        return "productNotFound";
    }

    @RequestMapping("/products/invalidPromoCode")
    public String invalidPromoCode() {
        return "invalidPromoCode";
    }

    // == Form Validation Section ==
    @InitBinder
    public void initialiseBinder(final WebDataBinder binder) {
        binder.setValidator(productValidator);
        binder.setAllowedFields("productId",
                "name",
                "unitPrice",
                "description",
                "manufacturer",
                "category",
                "unitsInStock",
                "productImage",
                "condition"
        );
    }
}
