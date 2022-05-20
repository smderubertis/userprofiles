package com.takehome.userprofiles.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	private String email;
	
	@NotBlank
	@Size(max = 45)
	private String firstname;
	
	@NotBlank
	@Size(max = 45)
	private String lastname;
	
	@NotBlank
	@Size(max = 45)
	private String password;
	
	private Boolean isadmin;
	
	public User() {
	}
	public User(String email, String firstname, String lastname, String password) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Boolean getIsadmin() {
		return isadmin;
	}
	public void setIsadmin(Boolean isadmin) {
		this.isadmin = isadmin;
	}
}
