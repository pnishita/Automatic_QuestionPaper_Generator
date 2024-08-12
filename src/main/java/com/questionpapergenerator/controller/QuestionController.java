package com.questionpapergenerator.controller;
import com.questionpapergenerator.model.Question;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
import com.questionpapergenerator.service.QuestionService;
import org.springframework.web.bind.annotation.*;
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
public class QuestionController {
    private QuestionService questionService;
    @Autowired
    public QuestionController(QuestionService questionService) {
       this.questionService = questionService;
   }

   @PostMapping("/addAllQuestions")
   public String addQuestions(@RequestBody List<Question> questions){questionService.addAllQuestions(questions);return "Added Successfully";
   }
    @PostMapping("/addQuestion")
    public String addQuestion(@RequestBody Question question) {
        questionService.addQuestion(question);
        return "Added Successfully";
    }
    @GetMapping("/getallquestions")
    public List<Question> getAllQuestions() {
        return questionService.getAllQuestions();
    }
    @GetMapping("/getQuestionsbySub/{id}")
    public List<Question> getQuestionsbySub(@PathVariable Long id) {
        return questionService.getQuestionsBySubject(id);
    }
    @GetMapping("/getquestion/id={id}")
    public Optional<Question> getMCQById(@PathVariable Long id) {
        return questionService.getQuestionById(id);
    }
    @DeleteMapping("/deletequestion/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
        return ResponseEntity.noContent().build();
    }
}
