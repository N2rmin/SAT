package com.sat.quiz.entity;

import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class TextQuestion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String textContent;
    private boolean status;

    @OneToMany(mappedBy = "textQuestion", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Question> questions=new ArrayList<>();
}
