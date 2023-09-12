package com.back.commune.utils;

import java.util.List;

public class UserInfoResponse {

	private Long id;
	private String username;
	private String phone;
	private List<String> roles;
	private String accessToken;


	public UserInfoResponse(Long id, String username, String phone, List<String> roles, String accessToken) {
		super();
		this.id = id;
		this.username = username;
		this.phone = phone;
		this.roles = roles;
		this.accessToken = accessToken;
	}


	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public List<String> getRoles() {
		return roles;
	}
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}




}
