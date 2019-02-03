package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.gda15.project.model.UserPOJO;
import pl.sda.gda15.project.service.OrderService;
import pl.sda.gda15.project.service.ProductService;
import pl.sda.gda15.project.service.UserService;

import java.util.UUID;


@Controller
public class UserController {
    private final UserService userService;
    private final OrderService orderService;
    private  final ProductService productService;


@Autowired
    public UserController(UserService userService, OrderService orderService, ProductService productService) {
        this.userService = userService;
    this.orderService = orderService;
    this.productService = productService;
}

    @PostMapping("/create")
    public String userPost(UserPOJO userPOJO) {
        userService.save(userPOJO);
        return "redirect:/users";
    }

    @GetMapping("/users")
    public String usersList(Model model) {
        model.addAttribute("users", userService.userList());
        return "users";
    }

    @GetMapping("/user_create")
    public String user(Model model) {
        model.addAttribute("user_creat",new UserPOJO());
        return "user_create";
    }
    @GetMapping("/user")
    public String userInfo(Model model,@RequestParam("id") UUID userId){
        UserPOJO userPOJO = userService.userList(userId);
        model.addAttribute("user", userPOJO);
        model.addAttribute("order",userPOJO.getOrderList());
        return "user";
    }




}
