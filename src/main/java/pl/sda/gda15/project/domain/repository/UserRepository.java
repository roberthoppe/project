package pl.sda.gda15.project.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.sda.gda15.project.domain.entity.User;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
