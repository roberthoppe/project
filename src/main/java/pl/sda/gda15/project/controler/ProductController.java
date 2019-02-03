package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.ProductService;

import java.util.UUID;

@Controller
public class ProductController {
    final private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/new")
    public String post(ProductPOJO productPOJO) {
        productService.save(productPOJO);
        return "redirect:/newProduct";
    }
    @GetMapping("/newProduct")
    public String newProduct(Model model){
    model.addAttribute("newProduct",new ProductPOJO());
    return "newProduct";
    }
    @GetMapping("/product_list")
    public String productList(Model model){
        model.addAttribute("productList",productService.productList());
        return "product_list";
    }
    @GetMapping("/product")
    public String productInfo(Model model,@RequestParam("id") UUID productId){
        ProductPOJO productPOJO = productService.productList(productId);
        model.addAttribute("productInfo",productPOJO);
        return "product";
    }

}

