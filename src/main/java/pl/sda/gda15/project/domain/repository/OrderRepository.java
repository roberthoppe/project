package pl.sda.gda15.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.gda15.project.domain.entity.Order;

import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
}
