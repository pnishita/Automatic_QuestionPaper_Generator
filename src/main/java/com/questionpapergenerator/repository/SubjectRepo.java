package com.questionpapergenerator.repository;

import com.questionpapergenerator.model.Subject;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubjectRepo extends JpaRepository<Subject,Long> {
    Subject findByName(String name);
}
