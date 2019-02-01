package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Order;
import pl.sda.gda15.project.domain.repository.OrderRepository;
import pl.sda.gda15.project.model.OrderPOJO;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final UserService userService;

    @Autowired
    public OrderService(OrderRepository orderRepository, UserService userService) {
        this.orderRepository = orderRepository;
        this.userService = userService;
    }

    public Order map(OrderPOJO orderPOJO) {
        return  new Order(orderPOJO.getOrderId(), orderPOJO.getOrderData(),
                userService.map(userService.getUser(orderPOJO.getOrderId())));
    }

    public OrderPOJO map(Order order) {
        return new  OrderPOJO(order.getOrderId(), order.getOrderData());
    }
}
