package com.example.demo.model.Users;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;


import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class User implements UserDetails{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Id",nullable = false)
    @SequenceGenerator(name="mySg",sequenceName = "myS",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "mySg")
    private Integer id;

    @Column(name="First_Name",unique = false,nullable = false)
    private String FirstName;

    @Column(name="Email",unique = false)
    private String email;

    @Column(name="Password",unique = false)
    private String password;

    @Column(name="Telephone",unique = false)
    private String telephone;

    @Column(name="Adress",unique = false)
    private String adress;
    
    @Column(name="City",unique = false)
    private String city;

    @Column(name="Last_Name",unique = false,nullable = false)
    private String LastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))        
    private List<Authority> authorities;

    public User(){

    }
    public String getFirstName(){
        return FirstName;
    }
    public void setFirstName(String name){
        this.FirstName=name;
    }
    public String getLastName(){
        return LastName;
    }
    public void setLastName(String name){
        this.LastName=name;
    }
    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
   
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}