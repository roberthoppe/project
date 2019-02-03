package pl.sda.gda15.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.gda15.project.domain.entity.Basket;

import java.util.UUID;

public interface BasketRepository extends JpaRepository<Basket, UUID> {
}
