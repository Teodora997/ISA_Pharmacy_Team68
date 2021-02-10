package com.example.demo.model.Users;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.ManyToOne;


import com.example.demo.model.*;


@Entity
@Table(name="Dermatologists")
public class Dermatologist extends User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name="Mark")
    private Double mark;

    @ManyToOne()
    @JoinColumn(name="work_time_id",referencedColumnName="id")
    private WorkTime workTime;

    @ManyToMany()
    @JoinTable(name = "derm_pharmacy",
            joinColumns = @JoinColumn(name = "derm_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacy_id", referencedColumnName = "id"))
    private List<Pharmacy> pharmacies;


    public Dermatologist(){

    }


    @Override
    public String getUsername() {
       
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
      
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }
    
}
