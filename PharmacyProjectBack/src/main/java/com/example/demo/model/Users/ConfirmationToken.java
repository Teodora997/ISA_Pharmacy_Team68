package com.example.demo.model.Users;

import java.util.Date;
import java.util.Objects;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="confirmationTokens")
public class ConfirmationToken {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="token",unique = true,nullable = false)
    private String token;

    @Column(name="createdDateTime",nullable = false)
    private Date createdDateTime;

    @OneToOne
    private User user;

    public ConfirmationToken(){
        
    }

    public ConfirmationToken(User user) {
        this.user = user;
        this.token=UUID.randomUUID().toString();
        this.createdDateTime=new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDate(Date createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override 
    public boolean equals(Object o){
        if (this==o) return true;
        if(o==null || getClass()!=o.getClass()) return false;
        ConfirmationToken that=(ConfirmationToken) o;

        return Objects.equals(id,that.id);
    }

    @Override
    public int hashCode(){
        return Objects.hash(id);
    }

}
