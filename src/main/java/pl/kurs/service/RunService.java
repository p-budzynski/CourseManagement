package pl.kurs.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.kurs.entity.*;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class RunService {
    private final CourseService courseService;
    private final InstructorService instructorService;
    private final UserService userService;
    private final OpinionService opinionService;

    public void run() {

        Lesson lesson1 = new Lesson("Wprowadzenie do Javy");
        Lesson lesson2 = new Lesson("Zmienne i typy danych");
        Lesson lesson3 = new Lesson("Instrukcje warunkowe");
        Lesson lesson4 = new Lesson("Pętle w Javie");
        Lesson lesson5 = new Lesson("Wprowadzenie do Spring Boot");
        Lesson lesson6 = new Lesson("Kontrolery i REST API");
        Lesson lesson7 = new Lesson("Bean'y i Dependency Injection");
        Lesson lesson8 = new Lesson("Bezpieczeństwo w Spring Security");
        Lesson lesson9 = new Lesson("Podstawy SQL");
        Lesson lesson10 = new Lesson("Relacje w bazach danych");
        Lesson lesson11 = new Lesson("Optymalizacja zapytań");

        CourseModule module1 = new CourseModule("Podstawy Javy");
        CourseModule module2 = new CourseModule("Zaawansowana Java");
        CourseModule module3 = new CourseModule("Spring Boot");
        CourseModule module4 = new CourseModule("Podstawy SQL");
        CourseModule module5 = new CourseModule("Zaawansowany SQL i optymalizacja");

        Course course1 = new Course("Java Developer od podstaw","Kompletny kurs Javy od podstaw do poziomu zaawansowanego.");
        Course course2 = new Course("Spring Boot w praktyce","Buduj nowoczesne aplikacje w Spring Boot z REST API i bezpieczeństwem.");
        Course course3 = new Course("SQL dla programistów","Podstawy i zaawansowane techniki pracy z relacyjnymi bazami danych.");

        Instructor instructor1 = new Instructor("Jan", "Kowalski", "jan.kowalski@example.com");
        Instructor instructor2 = new Instructor("Jan", "Nowak", "jan.nowak@gmail.com");

        User user1 = new User("Adam", "Przekładam", "a.przedlakam@op.pl");
        User user2 = new User("Łukasz", "Czegoszukasz", "l.szuka@op.pl");

        Opinion opinion1 = new Opinion(user1, "Do bani!", 0);
        Opinion opinion2 = new Opinion(user2, "Super!", 5);
        Opinion opinion3 = new Opinion(user1, "Może być!", 2);
        Opinion opinion4 = new Opinion(user2, "Jest OK!", 4);
        Opinion opinion5 = new Opinion(user1, "Elegancko!", 4);



        userService.saveUser(user1);
        userService.saveUser(user2);
        instructorService.saveInstructor(instructor1);
        instructorService.saveInstructor(instructor2);
        courseService.saveCourse(course1);
        courseService.saveCourse(course2);
        courseService.saveCourse(course3);

        course1.getCourseModules().addAll(List.of(module1, module2));
        module1.setCourse(course1);
        module2.setCourse(course1);
        course1.setInstructor(instructor1);
        course1.getUsers().add(user1);
        course1.getOpinions().addAll(List.of(opinion1, opinion2));
        opinion1.setCourse(course1);
        opinion2.setCourse(course1);

        course2.getCourseModules().addAll(List.of(module3, module4));
        module3.setCourse(course2);
        module4.setCourse(course2);
        course2.setInstructor(instructor1);
        course2.getUsers().addAll(List.of(user1, user2));
        course2.getOpinions().addAll(List.of(opinion3, opinion4));
        opinion3.setCourse(course2);
        opinion4.setCourse(course2);

        course3.getCourseModules().add(module5);
        module5.setCourse(course3);
        course3.setInstructor(instructor2);
        course3.getOpinions().add(opinion5);
        opinion5.setCourse(course3);

        opinionService.saveOpinion(opinion1);
        opinionService.saveOpinion(opinion2);
        opinionService.saveOpinion(opinion3);
        opinionService.saveOpinion(opinion4);
        opinionService.saveOpinion(opinion5);
        courseService.saveCourse(course1);


    }


}
