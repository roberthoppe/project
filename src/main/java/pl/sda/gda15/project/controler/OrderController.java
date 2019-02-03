package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.sda.gda15.project.domain.entity.User;
import pl.sda.gda15.project.model.OrderPOJO;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.OrderService;
import pl.sda.gda15.project.service.ProductService;
import pl.sda.gda15.project.service.UserService;

import java.util.UUID;

@Controller
public class OrderController {
    final private OrderService orderService;
    final private ProductService productService;

@Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
    this.productService = productService;
}
    @PostMapping("/add")
    public String orderPost(OrderPOJO orderPOJO){
    orderService.save(orderPOJO);
    return "redirect:/new_order";
    }
    @GetMapping("/new_order")
    public String order(Model model){
    model.addAttribute("addOrder",new OrderPOJO());
    return "product";
    }
    @GetMapping("/order_list")
    public String orderList(Model model) {
        model.addAttribute("order_list", orderService.orderList());
        return "order_list";

    }
}
