package com.questionpapergenerator.controller;
import com.questionpapergenerator.model.Question;
import com.questionpapergenerator.service.GeneratorService;
import com.questionpapergenerator.service.PdfService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController
@RequestMapping("/api/generate")
public class GeneratorController {
    private PdfService pdfService;
    private GeneratorService generatorService;
    @Autowired
    public GeneratorController(GeneratorService generatorService,PdfService pdfService){
        this.generatorService=generatorService;
        this.pdfService=pdfService;
    }
    @GetMapping("/questions/{n}/{subjectID}")
    public List<Question> getUniqueQuestions(@PathVariable("n") int n,@PathVariable("subjectID") Long subjectId) {
        return generatorService.generateUniqueQuestions(n, subjectId);
    }
    @GetMapping("/questions/{n}/{subjectID}/pdf")
    public ResponseEntity<byte[]> getQuestionsPdf(@PathVariable("n") int n, @PathVariable("subjectID") Long subjectId) {
        List<Question> questions = generatorService.generateUniqueQuestions(n, subjectId);
        byte[] pdfBytes = pdfService.generatePdf(questions);
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=questions.pdf");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
    }

}
