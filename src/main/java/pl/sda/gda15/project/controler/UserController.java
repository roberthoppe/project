package pl.sda.gda15.project.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.gda15.project.service.UserService;

@Controller
public class UserController {
    private final UserService userService;


    public UserController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("user")
    public String getAllInfo(Model model){
        model.addAttribute("user",userService.getUser());
        return "user_result";
    }
}
