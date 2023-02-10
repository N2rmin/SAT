package com.sat.quiz.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.*;

@Entity
@Data
@NoArgsConstructor
@Table(uniqueConstraints ={ @UniqueConstraint(columnNames = { "module_id", "quiz_id","orderNumber" }) })
public class Question extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Lob
    private String questionText;
    private boolean status;


    private int orderNumber;
    private Boolean isOpen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "module_id")
    private Module module;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "question",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Set<Answer> answers=new HashSet<>();


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "text_question_id", referencedColumnName = "id" )
    private TextQuestion textQuestion;

   // private Long textQuestionId;
}
