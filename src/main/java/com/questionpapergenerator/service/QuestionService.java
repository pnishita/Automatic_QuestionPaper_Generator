package com.questionpapergenerator.service;
import com.questionpapergenerator.model.Question;
import com.questionpapergenerator.repository.QuestionsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class QuestionService {
    private QuestionsRepo questionRepo;
    @Autowired
    public QuestionService(QuestionsRepo questionRepo){
        this.questionRepo=questionRepo;
    }
    public void saveQuestion(Question question) {
        questionRepo.save(question);
    }
    public List<Question> getQuestions(){
        log.info("GEt Question service called");
        return questionRepo.findAll();
    }
    public List<Question> getQuestionsBySubject(Long id){
        List<Question> q= questionRepo.findAll();
        List<Question> questionList= q.stream().filter(q1 -> q1.getId().equals(id)).collect(Collectors.toList());
        questionList.forEach(mcq -> log.info(mcq.getQuestionText()));
        return questionList;
    }

    public void deleteMCQ(Long id) {
        questionRepo.deleteById(id);
    }

    public Optional<Question> getQuestionById(Long id) {
       return questionRepo.findById(id);
    }
}
