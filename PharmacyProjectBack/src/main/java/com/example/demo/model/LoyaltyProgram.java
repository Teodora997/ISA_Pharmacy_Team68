package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Loyalty")
public class LoyaltyProgram {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Long id;

    @Column(name = "examination_points")
    private Integer examinationPoints;

    @Column(name = "consulting_points")
    private Integer consultingPoints;

    @Column(name = "regular_points")
    private Integer regularPoints;;

    @Column(name = "silver_points")
    private Integer silverPoints;

    @Column(name = "gold_points")
    private Integer goldPoints;

    public LoyaltyProgram() {
    }

    public LoyaltyProgram(Long id, Integer examinationPoints, Integer consultingPoints, Integer regularPoints,
            Integer silverPoints, Integer goldPoints) {
        this.id = id;
        this.examinationPoints = examinationPoints;
        this.consultingPoints = consultingPoints;
        this.regularPoints = regularPoints;
        this.silverPoints = silverPoints;
        this.goldPoints = goldPoints;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getExaminationPoints() {
        return examinationPoints;
    }

    public void setExaminationPoints(Integer examinationPoints) {
        this.examinationPoints = examinationPoints;
    }

    public Integer getConsultingPoints() {
        return consultingPoints;
    }

    public void setConsultingPoints(Integer consultingPoints) {
        this.consultingPoints = consultingPoints;
    }

    public Integer getRegularPoints() {
        return regularPoints;
    }

    public void setRegularPoints(Integer regularPoints) {
        this.regularPoints = regularPoints;
    }

    public Integer getSilverPoints() {
        return silverPoints;
    }

    public void setSilverPoints(Integer silverPoints) {
        this.silverPoints = silverPoints;
    }

    public Integer getGoldPoints() {
        return goldPoints;
    }

    public void setGoldPoints(Integer goldPoints) {
        this.goldPoints = goldPoints;
    }

    
}
