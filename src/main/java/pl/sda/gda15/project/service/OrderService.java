package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {
    private final OrderService orderService;
@Autowired
    public OrderService(OrderService orderService) {
        this.orderService = orderService;
    }
}
