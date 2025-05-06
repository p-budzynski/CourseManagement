package pl.kurs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import pl.kurs.service.RunService;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Application.class, args);

        RunService runService = ctx.getBean(RunService.class);

        runService.run();
    }
}