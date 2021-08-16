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

    public Dermatologist(User user){
        super(user.getId(),user.getFirstName(),user.getLastName(),user.getEmail(),user.getAddress(),user.getCity(),user.getTelephone(),user.getPassword(),user.getRole(),user.getIsActivated());
        this.mark=5.0;
        this.workTime=null;

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
