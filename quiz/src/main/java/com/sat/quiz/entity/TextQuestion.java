package com.sat.quiz.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
public class TextQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String textContent;
    private boolean status;



    @OneToMany(mappedBy = "textQuestion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    //@Fetch(value = FetchMode.SUBSELECT)
    //    @IndexColumn(name="text_question_id")
    private Set<Question> questions=new HashSet<>();
}
