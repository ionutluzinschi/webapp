package app;

import liquibase.integration.spring.SpringLiquibase;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


/**
 * Created by V3790148 on 5/12/2016.
 */

@SpringBootApplication

public class Application {


    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }



}