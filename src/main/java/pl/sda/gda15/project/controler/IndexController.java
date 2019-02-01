package pl.sda.gda15.project.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.model.UserPOJO;
import pl.sda.gda15.project.service.ProductService;
import pl.sda.gda15.project.service.UserService;


@Controller
public class IndexController {
    private final UserService userService;
    private final ProductService productService;


    public IndexController(UserService userService, ProductService productService) {
        this.userService = userService;
        this.productService = productService;
    }

    @PostMapping("/user")
    public String userPost(UserPOJO userPOJO) {
        userService.save(userPOJO);
        return "redirect:/users";
    }

    @GetMapping
    public String user(Model model) {
        model.addAttribute("user", new UserPOJO());
        return "user";
    }

    @GetMapping("/users")
    public String usersInfo(Model model) {
        model.addAttribute("users", userService.getUser());
        return "user_result";
    }

    //    @GetMapping("/user")
//    public  String userInfo(Model model, @RequestParam("id") UUID userId){
//        UserPOJO user = userService.getUser(userId);
//        model.addAttribute("user",user);
//        return "user";
//    }
//    @GetMapping
//    public String product(Model model) {
//        model.addAttribute("product", new ProductPOJO());
//        return "product";
//    }
//
//    @GetMapping("/products")
//    public String products(Model model) {
//        model.addAttribute("products", productService.allProducts());
//        return "product_result";
//    }

}
