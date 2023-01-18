package com.sat.quiz.entity;

import com.sat.quiz.validation.UniquePromoCode;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Examiner extends BaseEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @UniquePromoCode
    private String promoCode;
    private String name;

    private String lastName;






}
