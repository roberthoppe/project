package pl.sda.gda15.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.gda15.project.domain.entity.Order;
import pl.sda.gda15.project.domain.entity.User;

import java.util.List;
import java.util.UUID;
public interface UserRepository extends JpaRepository<User, UUID> {
}
