package com.questionpapergenerator.service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.questionpapergenerator.exception.PdfGenerationException;
import com.questionpapergenerator.model.Question;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.util.List;

@Service
public class PdfService {
    public byte[] generatePdf(List<Question> questions) {
        Document document = new Document();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        int que = 1;
        try {
            PdfWriter.getInstance(document, baos);
            document.open();
            if (questions == null || questions.isEmpty()) {
                throw new PdfGenerationException("No questions provided");
            }
            for (Question question : questions) {
                document.add(new Paragraph("Question: " + que++));
                document.add(new Paragraph("Question: " + question.getQuestionText()));
                document.add(new Paragraph("Option A: " + question.getOptionA()));
                document.add(new Paragraph("Option B: " + question.getOptionB()));
                document.add(new Paragraph("Option C: " + question.getOptionC()));
                document.add(new Paragraph("Option D: " + question.getOptionD()));
                document.add(new Paragraph(" "));
            }
            document.close();
            return baos.toByteArray();
        } catch (DocumentException e) {
            throw new PdfGenerationException("Error occurred while generating PDF", e);
        }
    }
}
