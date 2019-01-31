package pl.sda.gda15.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda.gda15.project.domain.entity.Product;
import pl.sda.gda15.project.domain.repository.ProductRepository;
import pl.sda.gda15.project.model.ProductPOJO;

@Service
public class ProductService {
    private final ProductRepository productRepository;
@Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product map(ProductPOJO productPOJO){
    return new Product(productPOJO.getProductId(),productPOJO.getProductName(),productPOJO.getQuantity());
    }
    public ProductPOJO map(Product product){
    return new ProductPOJO(product.getProductId(), product.getProductName(), product.getQuantity());
    }
}
