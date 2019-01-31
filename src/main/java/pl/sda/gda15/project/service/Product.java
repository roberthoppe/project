package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.repository.ProductRepository;

@Service
public class Product {
    private final ProductRepository productRepository;
@Autowired
    public Product(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
}
