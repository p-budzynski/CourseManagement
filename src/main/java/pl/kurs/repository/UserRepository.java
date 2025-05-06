package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
