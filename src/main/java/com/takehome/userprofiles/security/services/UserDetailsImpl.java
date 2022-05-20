package com.takehome.userprofiles.security.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.takehome.userprofiles.model.ERole;
import com.takehome.userprofiles.model.User;

public class UserDetailsImpl implements UserDetails {

	private static final long serialVersionUID = 1L;
	private String email;
	private String firstname;
	private String lastname;
	private Boolean isadmin;
	
	@JsonIgnore
	private String password;
	private Collection<? extends GrantedAuthority> authorities;
	public UserDetailsImpl(String email, String password, String firstname, String lastname, Boolean isadmin,
			Collection<? extends GrantedAuthority> authorities) {
		this.email = email;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.isadmin = isadmin;
		this.authorities = authorities;
	}
	public static UserDetailsImpl build(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(ERole.ROLE_USER.name()));
		if(user.getIsadmin().equals(Boolean.TRUE)) {
			authorities.add(new SimpleGrantedAuthority(ERole.ROLE_USER.name()));
		}
		return new UserDetailsImpl(
				user.getEmail(),
				user.getPassword(),
				user.getFirstname(),
				user.getLastname(),
				user.getIsadmin(),
				authorities);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}
	public String getEmail() {
		return email;
	}
	
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public Boolean getIsadmin() {
		return isadmin;
	}
	@Override
	public String getPassword() {
		return password;
	}
	@Override
	public String getUsername() {
		return email;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	@Override
	public int hashCode() {
		return Objects.hash(authorities, email, firstname, isadmin, lastname, password);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserDetailsImpl other = (UserDetailsImpl) obj;
		return Objects.equals(authorities, other.authorities) && Objects.equals(email, other.email)
				&& Objects.equals(firstname, other.firstname) && Objects.equals(isadmin, other.isadmin)
				&& Objects.equals(lastname, other.lastname) && Objects.equals(password, other.password);
	}
	

}
