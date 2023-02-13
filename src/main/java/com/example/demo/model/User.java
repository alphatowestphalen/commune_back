package com.example.demo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users",
				uniqueConstraints= {
						@UniqueConstraint(columnNames = "username"),
						@UniqueConstraint(columnNames = "phone")
				})
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private long userId;
	
	
	@NotBlank
	@Size(max = 20)
	@Column(name="username")
	private String username;
	
	@NotBlank
	@Size(max = 10)
	private String phone;
	
	@NotBlank
	@Size(max= 120)
	@Column(name="password")
	private String password;
	
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "users_roles", 
					joinColumns = @JoinColumn(name = "userId"), inverseJoinColumns = @JoinColumn(name = "roleId"))
	private Set<Role> roles = new HashSet<>();


	public User(@NotBlank @Size(max = 20) String username, @NotBlank @Size(max = 10) String phone,
			@NotBlank @Size(max = 120) String password) {
		super();
		
		this.username = username;
		this.phone = phone;
		this.password = password;
		
	}


	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


	public long getUserId() {
		return userId;
	}


	public void setUserId(long userId) {
		this.userId = userId;
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


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Set<Role> getRoles() {
		return roles;
	}


	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	
	
	
}
