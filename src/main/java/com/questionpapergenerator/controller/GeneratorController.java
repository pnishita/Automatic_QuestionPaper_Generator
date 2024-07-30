package com.questionpapergenerator.controller;
import com.questionpapergenerator.model.Question;
import com.questionpapergenerator.service.GeneratorService;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/generate")
public class GeneratorController {
    private GeneratorService generatorService;
    public GeneratorController(GeneratorService generatorService){
        this.generatorService=generatorService;
    }
    @GetMapping("/questions/{n}/{subjectID}")
    public List<Question> getUniqueQuestions(@PathVariable("n") int n,@PathVariable("subjectID") Long subjectId) {
        return generatorService.generateUniqueQuestions(n, subjectId);
    }
}
