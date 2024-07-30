package com.questionpapergenerator.repository;

import com.questionpapergenerator.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface QuestionsRepo extends JpaRepository<Question,Long> {
}
