package pl.sda.gda15.project.controler;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.ProductService;

import java.util.UUID;

@Controller
public class ProductController {
    final private ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new_product")
    public String newProduct(ProductPOJO productPOJO) {
        productService.save(productPOJO);
        return "redirect:/products";
    }
    


    @GetMapping("/new_product")
    public String product(Model model) {
        model.addAttribute("new_product", new ProductPOJO());
        return "new_product";
    }

    @GetMapping("/products")
    public String products(Model model) {
        model.addAttribute("products", productService.allProducts());
        return "products";
    }

}
