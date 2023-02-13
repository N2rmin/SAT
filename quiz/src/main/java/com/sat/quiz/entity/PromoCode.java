package com.sat.quiz.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class PromoCode {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Column(unique=true)
    private String promoCode;

    @Temporal(TemporalType.TIMESTAMP)
    private Date startDate;


    @Temporal(TemporalType.TIMESTAMP)
    private Date endDate;

    private Boolean status;





}
