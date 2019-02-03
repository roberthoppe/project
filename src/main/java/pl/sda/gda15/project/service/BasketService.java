package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Basket;
import pl.sda.gda15.project.domain.repository.BasketRepository;
import pl.sda.gda15.project.model.BasketPOJO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final BasketRepository basketRepository;
@Autowired
    public BasketService(BasketRepository basketRepository) {
        this.basketRepository = basketRepository;
    }
    public Basket map(BasketPOJO basketPOJO){
    return new Basket(basketPOJO.getOrderId(), basketPOJO.getOrderName());
    }
    public BasketPOJO map(Basket basket){
    return new BasketPOJO(basket.getBasketId(), basket.getOrderName());
    }
    public void save(BasketPOJO basketPOJO){
    basketRepository.save(map(basketPOJO));
    }
    public List<BasketPOJO> orderList(){
    return basketRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }
}
