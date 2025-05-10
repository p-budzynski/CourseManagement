package pl.kurs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.kurs.entity.Course;
import pl.kurs.entity.CourseModule;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c left join fetch c.users where c.id = :id")
    Optional<Course> findCourseByIdWithUsers(Long id);

    @Query("select c from Course c left join fetch c.opinions where c.id = :id")
    Optional<Course> findCourseByIdWithOpinions(Long id);

    @Query("select avg(o.rating) from Opinion o where o.course.id = :id")
    Double findAverageRatingByCourseId(Long id);

    @Query("select c from Course c left join fetch c.courseModules where c.id = :id")
    Optional<Course> findCourseByIdWithCourseModules(Long id);

    @Query("select m from CourseModule m left join fetch m.lessons where m.id = :id")
    Optional<CourseModule> findCourseModuleByIdWithLessons(Long id);
}
