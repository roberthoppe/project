package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.sda.gda15.project.model.OrderPOJO;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.OrderService;

@Controller
public class OrderController {
    final private OrderService orderService;
@Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
//    @PostMapping("/or2der")
//    public String orderPost(OrderPOJO orderPOJO){
//    orderService.save(orderPOJO);
//    return "redirect:/new_order";
//    }
    @GetMapping("/order")
    public String order(Model model){
    model.addAttribute("order",new ProductPOJO());
    return "/order";
    }
}
