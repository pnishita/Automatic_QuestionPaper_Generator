package com.questionpapergenerator.service;
import com.questionpapergenerator.model.Question;
import com.questionpapergenerator.repository.QuestionsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
@Service
public class GeneratorService {
    private QuestionsRepo questionRepository;
    Random random=new Random();
    @Autowired
    public GeneratorService(QuestionsRepo questionRepository) {
        this.questionRepository=questionRepository;
    }
    public List<Question> generateUniqueQuestions(int n, Long subjectId) {
        List<Question> allQuestions = questionRepository.findBySubjectId(subjectId);
        if (n > allQuestions.size()) {
            throw new IllegalArgumentException("Requested number of questions exceeds available questions.");
        }
        return random.ints(0, allQuestions.size())
                .distinct()
                .limit(n)
                .mapToObj(allQuestions::get)
                .collect(Collectors.toList());
    }
}
