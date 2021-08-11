package com.example.demo.dto;

import com.example.demo.model.RequestForReg;

public class RequestForRegDTO {
    
    private UserDTO userData;
    private Long id;
    private boolean isAccepted;

   
    public RequestForRegDTO(UserDTO userData,Long id,boolean isAccepted){
        this.setUserData(userData);
        this.setId(id);
        this.setAccepted(isAccepted);
    }

    public RequestForRegDTO(RequestForReg requestreg){
        this.setId(requestreg.getId());
        this.setUserData(new UserDTO(requestreg.getUserData()));
        this.setAccepted(requestreg.isAccepted());
    }

    public RequestForRegDTO(){
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public void setAccepted(boolean isAccepted) {
        this.isAccepted = isAccepted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserDTO getUserData() {
        return userData;
    }

    public void setUserData(UserDTO userData) {
        this.userData = userData;
    }

}
