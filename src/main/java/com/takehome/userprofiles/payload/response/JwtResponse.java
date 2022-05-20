package com.takehome.userprofiles.payload.response;

import java.util.List;

public class JwtResponse {
	private String token;
	private String type = "Bearer";
	private String email;
	private String firstname;
	private String lastname;
	private List<String> roles;

	public JwtResponse(String accessToken, String email, String firstname, String lastname, List<String> roles) {
		this.token = accessToken;
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.roles = roles;
	}

	public String getAccessToken() {
		return token;
	}

	public void setAccessToken(String accessToken) {
		this.token = accessToken;
	}

	public String getTokenType() {
		return type;
	}

	public void setTokenType(String tokenType) {
		this.type = tokenType;
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

	public List<String> getRoles() {
		return roles;
	}
}
