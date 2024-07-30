package com.questionpapergenerator.repository;
import org.springframework.data.repository.query.Param;
import com.questionpapergenerator.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface QuestionsRepo extends JpaRepository<Question,Long> {
    @Query("SELECT q FROM Question q WHERE q.subject.id = :subjectId")
    List<Question> findBySubjectId(@Param("subjectId") Long subjectId);
}
