package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kurs.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
