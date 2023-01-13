package com.sat.quiz.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Section extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private boolean status;

    @OneToMany(mappedBy = "section",cascade = CascadeType.ALL,fetch =FetchType.LAZY)
    private List<Module> modules=new ArrayList<>();

}
