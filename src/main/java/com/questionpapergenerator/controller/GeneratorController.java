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
@CrossOrigin(origins = "http://localhost:4200")

@RestController
@RequestMapping("/generate")
public class GeneratorController {
    private PdfService pdfService;
    private GeneratorService generatorService;

    @Autowired
    public GeneratorController(GeneratorService generatorService, PdfService pdfService) {
        this.generatorService = generatorService;
        this.pdfService = pdfService;
    }

    @GetMapping("/getquestions/v1/{numberofquestion}/{subjectID}")
    public ResponseEntity<List<Question>> getQuestions(@PathVariable("numberofquestion") int numberofquestion, @PathVariable("subjectID") Long subjectId) {
        List<Question> questions = generatorService.generateQuestionsBySubject(numberofquestion, subjectId);
        return new ResponseEntity<>(questions, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getquestions/v1/{numberofquestion}/{subjectID}/pdf")
    public ResponseEntity<byte[]> getQuestionsPdf(@PathVariable("numberofquestion") int numberofquestion, @PathVariable("subjectID") Long subjectId) {
        if (numberofquestion >= 1) {
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

//}
//package com.questionpapergenerator.controller;
//
//import com.questionpapergenerator.model.Question;
//import com.questionpapergenerator.service.GeneratorService;
//import com.questionpapergenerator.service.PdfService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/generate")
//public class GeneratorController {
//
//    private final PdfService pdfService;
//    private final GeneratorService generatorService;
//
//    @Autowired
//    public GeneratorController(GeneratorService generatorService, PdfService pdfService) {
//        this.generatorService = generatorService;
//        this.pdfService = pdfService;
//    }
//
//    /**
//     * Generates a list of questions based on the subject and number of questions requested.
//     * @param numberOfQuestions Number of questions to generate.
//     * @param subjectId ID of the subject for which questions are to be generated.
//     * @return ResponseEntity with list of questions and HTTP status.
//     */
//    @GetMapping("/getquestions/v1/{numberOfQuestions}/{subjectId}")
//    public ResponseEntity<List<Question>> getQuestions(
//            @PathVariable("numberOfQuestions") int numberOfQuestions,
//            @PathVariable("subjectId") Long subjectId) {
//
//        List<Question> questions = generatorService.generateQuestionsBySubject(numberOfQuestions, subjectId);
//        if (questions.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//        return new ResponseEntity<>(questions, HttpStatus.OK);
//    }
//
//    /**
//     * Generates a PDF containing a list of questions based on the subject and number of questions requested.
//     * @param numberOfQuestions Number of questions to generate.
//     * @param subjectId ID of the subject for which questions are to be generated.
//     * @return ResponseEntity with PDF byte array and HTTP headers.
//     */
//    @GetMapping("/getquestions/v1/{numberOfQuestions}/{subjectId}/pdf")
//    public ResponseEntity<byte[]> getQuestionsPdf(
//            @PathVariable("numberOfQuestions") int numberOfQuestions,
//            @PathVariable("subjectId") Long subjectId) {
//
//        if (numberOfQuestions < 1) {
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//
//        List<Question> questions = generatorService.generateQuestionsBySubject(numberOfQuestions, subjectId);
//        if (questions.isEmpty()) {
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        }
//
//        byte[] pdfBytes = pdfService.generatePdf(questions);
//        HttpHeaders headers = new HttpHeaders();
//        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=questions.pdf");
//        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_PDF_VALUE);
//
//        return new ResponseEntity<>(pdfBytes, headers, HttpStatus.OK);
//    }
//}
