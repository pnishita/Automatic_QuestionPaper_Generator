package com.questionpapergenerator.controller;
import com.questionpapergenerator.model.Subject;
import com.questionpapergenerator.service.SubjectService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
@CrossOrigin(origins = "http://localhost:4200")
@Slf4j
@RestController
@RequestMapping("/subjects")
public class SubjectController {
    private SubjectService subjectService;
    @Autowired
    public SubjectController(SubjectService subjectService){
        this.subjectService=subjectService;
    }
    @GetMapping("/all")
    public List<Subject> getSubjects() {return subjectService.getSubjects(); }
    @GetMapping("/subjectid={id}")
    public Optional<Subject> getSubjectById(@PathVariable Long id) {
            return subjectService.getSubjectById(id);
        }
    @PostMapping("/save")
    public String createSubject(@RequestBody Subject subject) {
        subjectService.saveSubject(subject);
        return "succes";
        }
    }
//    public void deleteSubject(Long subjectId) {
//        Subject subject = subjectRepository.findById(subjectId)
//                .orElseThrow(() -> new RuntimeException("Subject not found"));
//        questionRepository.deleteAll(subject.getQuestions());
//        subjectRepository.delete(subject);
//    }