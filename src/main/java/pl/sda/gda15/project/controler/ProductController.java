package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.ProductService;

@Controller
public class ProductController {

private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
    @GetMapping
    public String product(Model model){
        model.addAttribute("product",new ProductPOJO());
        return "product";
    }
    @GetMapping("/products")
    public String products(Model model){
        model.addAttribute("roducts",productService.allProducts());
        return "products";
    }
}
