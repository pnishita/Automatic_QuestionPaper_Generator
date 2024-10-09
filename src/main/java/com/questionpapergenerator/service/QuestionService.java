package com.questionpapergenerator.service;
import com.questionpapergenerator.model.Question;
import com.questionpapergenerator.repository.QuestionsRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;
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
    public List<Question> getAllQuestions(){
        log.info("GEt Question service called");
        return questionRepo.findAll();
    }
    public List<Question> getQuestionsBySubject(Long id){
         return questionRepo.findBySubjectId(id);
    }
    @Transactional
    public boolean deleteQuestionById(Long id) {
        log.info("Attempting to delete question with id: {}", id);
        if (questionRepo.existsById(id)) {
            questionRepo.deleteById(id);
            log.info("Deleted question with id: {}", id);
            return true;
        } else {
            log.warn("Question with id: {} does not exist", id);
            return false;
        }

    }
    public Optional<Question> getQuestionById(Long id) {
       return questionRepo.findById(id);
    }
    public void addAllQuestions(List<Question> questions) {questionRepo.saveAll(questions);}
    public void addQuestion(Question questions) {questionRepo.save(questions);}
}
