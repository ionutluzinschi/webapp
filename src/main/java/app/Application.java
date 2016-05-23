package app;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.io.File;

/**
 * Created by V3790148 on 5/12/2016.
 */

@SpringBootApplication

public class Application {

    public static String ROOT = "upload-dir";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner init() {

        return (String[] args) -> {
            new File(ROOT).mkdir();
        };
    }
}