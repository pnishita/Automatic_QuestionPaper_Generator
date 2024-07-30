package com.questionpapergenerator.service;
import com.questionpapergenerator.model.Subject;
import com.questionpapergenerator.repository.SubjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class SubjectService {
    private SubjectRepo subjectRepo;
    @Autowired
    public SubjectService(SubjectRepo subjectRepo){this.subjectRepo=subjectRepo;}
    public List<Subject> getSubjects() {
        return subjectRepo.findAll();
    }
    public void saveSubject(Subject subject) {
        subjectRepo.save(subject);
    }
    public Subject findByName(String name) {return subjectRepo.findByName(name);}
    public Optional<Subject> getSubjectById(Long id) {
        return subjectRepo.findById(id);
    }
}