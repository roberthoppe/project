package pl.sda.gda15.project.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.sda.gda15.project.model.ProductPOJO;
import pl.sda.gda15.project.service.OrderService;
import pl.sda.gda15.project.service.ProductService;

@Controller
public class OrderController {
    final private OrderService orderService;
    final private ProductService productService;
@Autowired
    public OrderController(OrderService orderService, ProductService productService) {
        this.orderService = orderService;
    this.productService = productService;
}
//    @PostMapping("/or2der")
//    public String orderPost(OrderPOJO orderPOJO){
//    orderService.save(orderPOJO);
//    return "redirect:/new_order";
//    }
    @GetMapping("/order")
    public String order(Model model){
    model.addAttribute("order",new ProductPOJO());
    model.addAttribute("productList",productService.productList());
    return "order";
    }
}
