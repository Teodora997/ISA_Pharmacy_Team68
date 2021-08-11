package com.example.demo.model.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.Pharmacy;
import com.example.demo.model.WorkTime;

@Entity
@Table(name="Pharmacists")
public class Pharmacist  extends User{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name="Mark")
    private Double mark;

    @ManyToOne()
    @JoinColumn(name="work_time_id",referencedColumnName="id")
    private WorkTime workTime;

    @ManyToOne()
    @JoinColumn(name="pharmacy_id",referencedColumnName="id")
    private Pharmacy pharmacy;

    public Pharmacist(){

    }
    
    public Pharmacist(Double mark, WorkTime workTime, Pharmacy pharmacy) {
        this.mark = mark;
        this.workTime = workTime;
        this.pharmacy = pharmacy;
    }

    public Pharmacist(Long id, String firstName, String lastName, String password, String address, String city,
            String email, String telephone, Double mark, WorkTime workTime, Pharmacy pharmacy) {
        super(id, firstName, lastName, password, address, city, email, telephone);
        this.mark = mark;
        this.workTime = workTime;
        this.pharmacy = pharmacy;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

    
    
}
