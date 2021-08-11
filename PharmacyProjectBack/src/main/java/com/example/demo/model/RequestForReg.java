package com.example.demo.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.example.demo.model.Users.User;

@Entity
public class RequestForReg {
    
	@Id
	@Column(name="Id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne( fetch = FetchType.LAZY)
	@JoinColumn(name = "userDataId", referencedColumnName = "id")
	private User userData;

	@Column(name="isAccepted")
	private boolean isAccepted;


	public RequestForReg() {
		super();
	}

	public RequestForReg(User user) {
		this.userData = user;
		this.isAccepted=false;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUserData() {
		return userData;
	}

	public void setUserData(User userData) {
		this.userData = userData;
	}

	public boolean isAccepted() {
		return isAccepted;
	}

	public void setAccepted(boolean accepted) {
		isAccepted = accepted;
	}
}
