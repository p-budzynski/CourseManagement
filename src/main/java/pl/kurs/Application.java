package pl.kurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.service.CourseService;
import pl.kurs.service.RunService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        RunService runService = ctx.getBean(RunService.class);

        runService.run();

        CourseService courseService = ctx.getBean(CourseService.class);

        System.out.println("-------------------------- S T A R T ---------------------------");

        courseService.findCourseByIdWithUsers(1L);
        System.out.println("-------------------------------------------------------------");

        courseService.findCourseByIdWithUsers(2L);
        System.out.println("--------------------------------------------------------------");

        courseService.findCourseByIdWithOpinions(1L);
        System.out.println("---------------------------------------------------------------");

        courseService.printAverageRating(1L);
        System.out.println("---------------------------------------------------------------");

        courseService.findCourseByIdWithCourseModules(1L);
        System.out.println("---------------------------------------------------------------");

        courseService.findCourseModuleByIdWithLessons(1L);

        System.out.println("-------------------------- E N D -------------------------------");
    }
}