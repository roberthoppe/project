package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Order;
import pl.sda.gda15.project.domain.entity.User;
import pl.sda.gda15.project.domain.repository.OrderRepository;
import pl.sda.gda15.project.model.OrderPOJO;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;
    private final ProductService productService;
    @Lazy
    @Autowired
    public OrderService(OrderRepository orderRepository, UserService userService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
        this.productService = productService;
    }

    public List<OrderPOJO> getOrder() {
        return orderRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }
    public void save(OrderPOJO orderPOJO){
        orderRepository.save(map(orderPOJO));
    }


    public Order map(OrderPOJO orderPOJO) {
        Order order = new Order(orderPOJO.getOrderId(), orderPOJO.getOrderData());
        return order;
    }

    public OrderPOJO map(Order order) {
        OrderPOJO orderPOJO = new OrderPOJO(order.getOrderId(), order.getOrderData());
        return orderPOJO;
    }

}
