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
@RequestMapping("/generate")
public class GeneratorController {
    private PdfService pdfService;
    private GeneratorService generatorService;
    @Autowired
    public GeneratorController(GeneratorService generatorService,PdfService pdfService){
        this.generatorService=generatorService;
        this.pdfService=pdfService;
    }
    @GetMapping("/getquestions/v1/{numberofquestion}/{subjectID}")
    public List<Question> getQuestions(@PathVariable("numberofquestion") int numberofquestion,@PathVariable("subjectID") Long subjectId) {
        return generatorService.generateQuestionsBySubject(numberofquestion, subjectId);
    }
    @GetMapping("/getquestions/v1/{numberofquestion}/{subjectID}/pdf")
    public ResponseEntity<byte[]> getQuestionsPdf(@PathVariable("numberofquestion") int numberofquestion, @PathVariable("subjectID") Long subjectId) {
        if(numberofquestion>=1) {
            List<Question> questions = generatorService.generateQuestionsBySubject(numberofquestion, subjectId);
            byte[] pdfBytes = pdfService.generatePdf(questions);
            HttpHeaders headers = new HttpHeaders();
            headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=questions.pdf");
            headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
            return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
    }

}
