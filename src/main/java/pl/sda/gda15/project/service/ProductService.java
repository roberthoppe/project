package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Product;
import pl.sda.gda15.project.domain.repository.ProductRepository;
import pl.sda.gda15.project.model.ProductPOJO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final OrderService orderService;
    private final UserService userService;
    @Lazy
    @Autowired
    public ProductService(ProductRepository productRepository, OrderService orderService, UserService userService) {
        this.productRepository = productRepository;

        this.orderService = orderService;
        this.userService = userService;
    }

    public void save(ProductPOJO productPOJO) {
        productRepository.save(map(productPOJO));
    }

    public List<ProductPOJO> productList() {
        return productRepository.findAll().stream().map(this::map).collect(Collectors.toList());
    }

    public Product map(ProductPOJO productPOJO) {
        return new Product(productPOJO.getProductId(), productPOJO.getProductName(), productPOJO.getQuantity(),productPOJO.getPrice());
    }

    public ProductPOJO map(Product product) {
        return new ProductPOJO(product.getId(), product.getPrice(), product.getProductName(), product.getQuantity());
    }
}
