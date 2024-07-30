package com.questionpapergenerator.controller;

import com.questionpapergenerator.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import com.questionpapergenerator.service.QuestionService;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
public class QuestionController {
   private QuestionService questionService;
   public QuestionController(QuestionService questionService) {
       this.questionService = questionService;
   }

   @PostMapping("/addAll")
   public String addQuestions(@RequestBody List<Question> questions){questionService.addQuestions(questions);return "Added Successfully";
   }
    @GetMapping("/all")
    public List<Question> getAllQuestions() {
        return questionService.getQuestions();
    }
    @GetMapping("/bySub")
    public List<Question> getQuestionsbySub(Long id) {
        return questionService.getQuestionsBySubject(id);
    }
    @GetMapping("/get={id}")
    public Optional<Question> getMCQById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    @DeleteMapping("/delete={id}")
    public void deleteMCQ(@PathVariable Long id) {
        questionService.deleteMCQ(id);
    }

}