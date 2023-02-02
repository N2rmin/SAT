package com.sat.quiz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Answer  implements Comparable<Answer>{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private String answerText;
    private Boolean status;

    private Boolean isTrue;




    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", referencedColumnName = "id" )
    private Question question;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "variant_id", referencedColumnName = "id" )
    private Variant variant;


    @Override
    public int compareTo(Answer answer) {
        return Long.compare(getVariant().getId(),answer.variant.getId());
    }
}
