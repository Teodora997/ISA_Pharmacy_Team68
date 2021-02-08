package com.example.demo.model.Users;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.model.Pharmacy;

@Entity
@Table(name="PharmacyAdmins")
public class PharmacyAdmin extends User{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @ManyToOne()
    @JoinColumn(name = "pharmacy_id",referencedColumnName = "id")
    private Pharmacy pharmacy;

    public PharmacyAdmin() {
    }

    public PharmacyAdmin(Long id, String firstName, String lastName, String password, String address, String city,
            String email, String telephone, Pharmacy pharmacy) {
        super(id, firstName, lastName, password, address, city, email, telephone);
        this.pharmacy = pharmacy;
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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    
    
}
