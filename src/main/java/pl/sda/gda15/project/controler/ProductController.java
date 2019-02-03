package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.ProductService;

@Controller
public class ProductController {
    final private ProductService productService;
@Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public String post(ProductPOJO productPOJO){
    productService.save(productPOJO);
    return "redirect:/newProuct";
    }
    @GetMapping("/newProduct")
    public String news(Model model){
    model.addAttribute("new",new ProductPOJO());
    return "newProduct";
    }

}
