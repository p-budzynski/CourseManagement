package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.entity.Opinion;

public interface OpinionRepository extends JpaRepository<Opinion, Long> {
}
