package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import pl.sda.gda15.project.service.ProductService;

@Controller
public class ProductController {

private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }
}
