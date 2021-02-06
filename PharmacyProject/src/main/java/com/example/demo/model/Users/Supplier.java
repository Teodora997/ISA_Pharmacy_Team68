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

    

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return false;
    }
    
}
