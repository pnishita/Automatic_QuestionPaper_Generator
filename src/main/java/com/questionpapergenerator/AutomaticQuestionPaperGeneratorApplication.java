package com.questionpapergenerator;

import com.questionpapergenerator.model.Question;
import com.questionpapergenerator.model.Subject;
import com.questionpapergenerator.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootApplication
public class AutomaticQuestionPaperGeneratorApplication {
    @Autowired
    private QuestionsRepo questionsRepo;
    public static void main(String[] args) {
        SpringApplication.run(AutomaticQuestionPaperGeneratorApplication.class, args);
        System.out.println(".....");

    }


}
