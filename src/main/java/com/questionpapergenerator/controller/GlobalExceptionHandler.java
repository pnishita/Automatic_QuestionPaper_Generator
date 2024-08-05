package com.questionpapergenerator.controller;

import com.questionpapergenerator.exception.ErrorResponse;
import com.questionpapergenerator.exception.NoRecordsFoundExpcetion;
import com.questionpapergenerator.exception.PdfGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.toString(),
                "Requested number of questions exceeds available questions"
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(PdfGenerationException.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse> handlePdfGenerationException(PdfGenerationException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                "PDF Generation Error",
                "An error occurred while generating the PDF: " + ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }


    @ExceptionHandler(NoRecordsFoundExpcetion.class)
    @ResponseBody
    public ResponseEntity<ErrorResponse>  handleNoRecordsFoundExpcetion(IllegalArgumentException ex) {
        ErrorResponse errorResponse = new ErrorResponse(
                ex.toString(),
                "No Records available"
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

}
