package com.example.demo.model.Users;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.example.demo.model.Medicine;

@Entity
@Table(name="Patients")
public class Patient extends User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Medicine> allergies = new HashSet<Medicine>();

    @Column(name="Points")
    private Integer points;

    @Column(name="Category")
    private String category;

    @Column(name="Penals")
    private Integer penals;


    
    public Patient(){

    }
    
   

    public Patient(Long id, String firstName, String lastName, String password, String address, String city,
            String email, String telephone, Set<Medicine> allergies, Integer points, String category, Integer penals) {
        super(id, firstName, lastName, password, address, city, email, telephone);
        this.allergies = allergies;
        this.points = points;
        this.category = category;
        this.penals = penals;
    }



    public Patient(Long id2, String firstName2, String lastName2, String email2, String address2, String city2,
            String telephone2, String password2, String role2, Boolean isActivated, Set<Medicine> allergies,
            Integer points, String category, Integer penals) {
        super(id2, firstName2, lastName2, email2, address2, city2, telephone2, password2, role2, isActivated, isActivated);
        this.allergies = allergies;
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

    

    public Set<Medicine> getAllergies() {
        return allergies;
    }



    public void setAllergies(Set<Medicine> allergies) {
        this.allergies = allergies;
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
