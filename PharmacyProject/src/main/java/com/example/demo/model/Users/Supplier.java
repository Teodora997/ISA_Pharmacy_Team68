package com.example.demo.model.Users;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Suppliers")
public class Supplier extends User {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    
    public Supplier(){

    }
    
    public Supplier(Long id, String firstName, String lastName, String password, String address, String city,
    String email, String telephone) {
        super(id, firstName, lastName, password, address, city, email, telephone);
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

   
    
}
