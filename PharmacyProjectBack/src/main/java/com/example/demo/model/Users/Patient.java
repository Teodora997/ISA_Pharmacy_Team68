package com.example.demo.model.Users;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Patients")
public class Patient extends User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Column(name="Allergy")
    private String allergy;

    @Column(name="Points")
    private Integer points;

    @Column(name="Category")
    private String category;

    @Column(name="Penals")
    private Integer penals;


    
    public Patient(){

    }
    
    public Patient(Long id, String firstName, String lastName, String password, String address, String city,
    String email, String telephone, String allergy, Integer points, String category, Integer penals) {
        super(id, firstName, lastName, password, address, city, email, telephone);
        this.allergy = allergy;
        this.points = points;
        this.category = category;
        this.penals = penals;
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

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getPenals() {
        return penals;
    }

    public void setPenals(Integer penals) {
        this.penals = penals;
    }

   
    
}
