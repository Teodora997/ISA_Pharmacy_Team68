package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="WorkTime")
public class WorkTime {
    @Id
    @Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="FromDate")
    private String fromDate;
    @Column(name="ToDate")
    private String toDate;
    @Column(name="Shift")
    private Integer shift;


    public WorkTime(){

    }
    
    public WorkTime(Long id, String fromDate, String toDate, Integer shift) {
        this.id = id;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.shift = shift;
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String fromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public Integer getShift(){
        return shift;
    }

    public void setShift(Integer shift){
        this.shift=shift;
    }

    

}
