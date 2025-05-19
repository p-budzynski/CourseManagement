package pl.kurs.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.entity.Course;
import pl.kurs.repository.CourseRepository;

@Service
@RequiredArgsConstructor
@Transactional
public class CourseService {

    private final CourseRepository courseRepository;

    public void saveCourse(Course course) {
        courseRepository.save(course);
    }

    public void deleteCourse(Long id) {
        courseRepository.deleteById(id);
    }

    public void findCourseByIdWithUsers(Long id) {
        courseRepository.findCourseByIdWithUsers(id)
                .ifPresent(course -> course.getUsers()
                        .forEach(System.out::println));
    }

    public void findCourseByIdWithOpinions(Long id) {
        courseRepository.findCourseByIdWithOpinions(id)
                .ifPresent(course -> course.getOpinions()
                        .forEach(System.out::println));
    }

    public void printAverageRating(Long id) {
        Double average = courseRepository.findAverageRatingByCourseId(id);
        System.out.println("Average rating: " + (average != null ? average : "No reviews for this course."));
    }

    public void findCourseByIdWithCourseModules(Long id) {
        courseRepository.findCourseByIdWithCourseModules(id)
                .ifPresent(course -> course.getCourseModules()
                        .forEach(System.out::println));
    }

    public void findCourseModuleByIdWithLessons(Long id) {
        courseRepository.findCourseModuleByIdWithLessons(id)
                .ifPresent(courseModule -> courseModule.getLessons()
                        .forEach(System.out::println));
    }


}
