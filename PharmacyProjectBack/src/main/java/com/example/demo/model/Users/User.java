package com.example.demo.model.Users;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import com.example.demo.model.RequestForReg;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;


@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User implements UserDetails{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="Id")
    @SequenceGenerator(name="gen1",sequenceName = "gen11",initialValue = 1,allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
    private Long id;

    @Column(name="First_Name")
    private String FirstName;

    @Column(name="Last_Name")
    private String LastName;

    @Column(name="Email")
    private String email;

    @Column(name="Password")
    private String password;

    @Column(name="Telephone")
    private String telephone;

    @Column(name="Address")
    private String address;
    
    @Column(name="City")
    private String city;

    @Column(name="Role")
    private String role;

    @Column(name="isActivated")
    private boolean isActivated;

    @Column(name = "firstTimeLogin")
    private boolean firstTimeLogin;
    
    @ManyToMany()
    @JoinTable(name = "user_authority",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "authority_id", referencedColumnName = "id"))        
    private Set<Authority> authorities;

   

    public User(){

    }



    public User(Long id,String firstName,String lastName,String password,String address,String city,String email,String telephone){
        this.id=id;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.password=password;
        this.address=address;
        this.city=city;
        this.email=email;
        this.telephone=telephone;
    }

    public User(Long id,String firstName,String lastName,String password,String address,String city,String email,String telephone,boolean firstTimeLogin){
        this.id=id;
        this.FirstName=firstName;
        this.LastName=lastName;
        this.password=password;
        this.address=address;
        this.city=city;
        this.email=email;
        this.telephone=telephone;
        this.firstTimeLogin=firstTimeLogin;
    }
    public User(Long id2, String firstName2, String lastName2, String email2, String address2, String city2,
            String telephone2, String password2, String role2,Boolean isActivated,boolean firstTimeLogin) {
        this.id=id2;
        this.FirstName=firstName2;
        this.LastName=lastName2;
        this.password=password2;
        this.address=address2;
        this.city=city2;
        this.email=email2;
        this.telephone=telephone2;
        this.role=role2;
        this.isActivated=isActivated;
        this.firstTimeLogin=firstTimeLogin;
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
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id=id;
    }
   
    public boolean isFirstTimeLogin() {
        return firstTimeLogin;
    }


    public void setFirstTimeLogin(boolean firstTimeLogin) {
        this.firstTimeLogin = firstTimeLogin;
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
    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Set<Authority> getAuthorities() {
        return this.authorities;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setIsActivated(boolean isActivated){
        this.isActivated=isActivated;
    }

    public boolean getIsActivated(){
        return isActivated;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }

}