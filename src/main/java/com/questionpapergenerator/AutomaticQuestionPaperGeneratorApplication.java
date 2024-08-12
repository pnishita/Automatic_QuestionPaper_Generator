package com.questionpapergenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin("*")
@SpringBootApplication
public class AutomaticQuestionPaperGeneratorApplication {
    public static void main(String[] args) {
        SpringApplication.run(AutomaticQuestionPaperGeneratorApplication.class, args);
        System.out.println("Application is running.....");
        //http://localhost:8084/swagger-ui/index.html
    }
}