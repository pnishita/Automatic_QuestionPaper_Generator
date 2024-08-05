package com.questionpapergenerator.model;

import jakarta.persistence.*;
import lombok.*;
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor
@Data
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String questionText;
    private String optionA;
    private String optionB;
    private String optionC;
    private String optionD;
    private String correctAnswer;
    @ManyToOne
    @JoinColumn(name = "subject_id", nullable = false)
    private Subject subject;

}
