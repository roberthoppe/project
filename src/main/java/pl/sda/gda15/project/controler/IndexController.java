package pl.sda.gda15.project.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.gda15.project.model.UserPOJO;
import pl.sda.gda15.project.service.UserService;

import javax.validation.Valid;

@Controller
public class IndexController {
    private final UserService userService;


    public IndexController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("user")
    public String userPost(@Valid @ModelAttribute("user") UserPOJO userPOJO, Model model){
        userService.save(userPOJO);
        return "user";
    }
//    @GetMapping("user")
//    public String getAllInfo(Model model){
//        model.addAttribute("user",userService.getUser());
//        return "user";
//    }
}
