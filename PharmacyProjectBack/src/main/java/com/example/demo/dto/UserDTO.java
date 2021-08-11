package com.example.demo.dto;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.model.Users.Authority;
import com.example.demo.model.Users.User;
import com.example.demo.model.Users.UserTokenState;

public class UserDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String password1;
    private String telephone;
    private String address;
    private String city;
    private String role;
    private boolean isActivated;
    private UserTokenState token;
    private List<String> authorities;


    public UserDTO(){

    }
    
    public UserDTO(Long id, String firstName, String lastName, String email, String password,
            String telephone, String address, String city,String role, boolean isActivated, UserTokenState token) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.telephone = telephone;
        this.address = address;
        this.city = city;
        this.role=role;
        this.isActivated = isActivated;
        this.token = token;
        
    }

    public UserDTO(User user){
        id=user.getId();
        firstName=user.getFirstName();
        lastName=user.getLastName();
        email=user.getEmail();
        password=user.getPassword();
        telephone=user.getTelephone();
        address=user.getAddress();
        role=user.getRole();
        isActivated=user.getIsActivated();
        token=null;
        this.authorities=user.getAuthorities().stream().map(authority-> ((Authority)authority).getName()).collect(Collectors.toList());

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword1() {
        return password1;
    }

    public void setPassword1(String password1) {
        this.password1 = password1;
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public boolean isActivated() {
        return isActivated;
    }

    public void setActivated(boolean isActivated) {
        this.isActivated = isActivated;
    }

    public UserTokenState getToken() {
        return token;
    }

    public void setToken(UserTokenState token) {
        this.token = token;
    }

    public List<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<String> authorities) {
        this.authorities = authorities;
    }

    
}
