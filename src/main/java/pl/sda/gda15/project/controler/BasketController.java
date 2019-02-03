package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.gda15.project.model.BasketPOJO;
import pl.sda.gda15.project.service.BasketService;

@Controller
public class BasketController {
    private final BasketService basketService;
@Autowired
    public BasketController(BasketService basketService) {
        this.basketService = basketService;
    }
    @GetMapping("/orders")
    public String orderList(Model model){
    model.addAttribute("orders", basketService.orderList());
    return "order_list";
    }
    @PostMapping("/new_order")
    public String posrOrder(BasketPOJO basketPOJO){
    basketService.save(basketPOJO);
    return "redirect:/newOrder";
    }
    @GetMapping("/newOrder")
    public String newOrder(Model model){
    model.addAttribute("newOrder",new BasketPOJO());
    return "new_order";
    }

}
