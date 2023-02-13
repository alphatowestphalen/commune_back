package com.example.demo.security.services;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Service
public class UserDetailsImpl  implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	private Long id;

	private String username;

	private String phone;
	
	@JsonIgnore
	private String password;
	
	private Collection<? extends GrantedAuthority> authorities;
	


	public UserDetailsImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDetailsImpl(Long id, String username, String phone, String password,
			Collection<? extends GrantedAuthority> authorities) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.password = password;
		this.authorities = authorities;
	}

	public static UserDetailsImpl build(User user) {
		    List<GrantedAuthority> authorities = user.getRoles().stream()
		        .map(role -> new SimpleGrantedAuthority(role.getType()))
		        .collect(Collectors.toList());

		return new UserDetailsImpl( 
				user.getUserId(),
				user.getUsername(), 
				user.getPhone(),
				user.getPassword(), 
				authorities);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return authorities;
	}

	public Long getId() {
		return id;
	}

	public String getPhone() {
		return phone;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
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
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserDetailsImpl user = (UserDetailsImpl) o;
		return Objects.equals(id, user.id);
	}
}