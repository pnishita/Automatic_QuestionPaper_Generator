package com.questionpapergenerator.controller;

import com.questionpapergenerator.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import com.questionpapergenerator.service.QuestionService;
import org.springframework.web.bind.annotation.*;
@RestController
@Slf4j
public class QuestionController {
    private QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
       this.questionService = questionService;
   }

   @PostMapping("/addAllQuestions")
   public String addQuestions(@RequestBody List<Question> questions){questionService.addQuestions(questions);return "Added Successfully";
   }
    @GetMapping("/getallquestions")
    public List<Question> getAllQuestions() {
        return questionService.getQuestions();
    }
    @GetMapping("/getQuestionsbySub")
    public List<Question> getQuestionsbySub(Long id) {
        return questionService.getQuestionsBySubject(id);
    }
    @GetMapping("/getquestion/id={id}")
    public Optional<Question> getMCQById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    @DeleteMapping("/deletequestion/id={id}")
    public void deleteMCQ(@PathVariable Long id) {
        questionService.deleteMCQ(id);
    }

}