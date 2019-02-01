package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Order;
import pl.sda.gda15.project.domain.entity.User;
import pl.sda.gda15.project.domain.repository.OrderRepository;
import pl.sda.gda15.project.model.OrderPOJO;

import java.util.UUID;
import java.util.stream.Collector;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }
    public OrderPOJO getOrder(UUID uuid){
        return map(orderRepository.getOne(uuid));
    }


    public Order map(OrderPOJO orderPOJO) {
        Order order =new Order(orderPOJO.getOrderId(), orderPOJO.getOrderData(),
                userService.map(userService.getUser(orderPOJO.getOrderId())), null);
order.setProductList(order.getProductList());
        return order;
    }

    public OrderPOJO map(Order order) {
        OrderPOJO orderPOJO = new OrderPOJO(order.getOrderId(), order.getOrderData(), null);
        orderPOJO.setProductList(orderPOJO.getProductList());
        return orderPOJO;
    }
}
