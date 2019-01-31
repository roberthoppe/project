package pl.sda.gda15.project.controler;

import jdk.nashorn.internal.objects.annotations.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.gda15.project.model.UserPOJO;
import pl.sda.gda15.project.service.UserService;



@Controller
public class IndexController {
    private final UserService userService;


    public IndexController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping("/user")
    public String userPost(UserPOJO userPOJO){
        userService.save(userPOJO);
        return "redirect:/users";
    }
    @GetMapping
    public String user(Model model) {
        model.addAttribute("user", new UserPOJO());
        return "user";
    }
    @GetMapping("/users")
    public String usersInfo(Model model){
        model.addAttribute("users",userService.getUser());
        return "user_result";
    }
//    @GetMapping("/user")
//    public  String userInfo(Model model, @RequestParam("id") UUID userId){
//        UserPOJO user = userService.getUser(userId);
//        model.addAttribute("user",user);
//        return "user";
//    }

}
