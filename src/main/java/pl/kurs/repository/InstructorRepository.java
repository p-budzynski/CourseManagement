package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long> {
}
