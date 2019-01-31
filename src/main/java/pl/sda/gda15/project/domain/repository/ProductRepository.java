package pl.sda.gda15.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.gda15.project.domain.entity.Product;

import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, UUID> {
}
