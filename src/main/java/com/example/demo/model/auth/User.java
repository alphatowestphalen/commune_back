package com.example.demo.model.auth;

import com.example.demo.utils.AuditTrailListener;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table(name="user")
public class User  implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
  
    private String password;

    @Column
    private String phone;

    @Column
    private String name;

    @Column
    private String poste;

    @ManyToOne()
    @JoinColumn(name = "idRoles")
    public Role roles;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

    public Role getRoles() {
        return roles;
    }

    public void setRoles(Role roles) {
        this.roles = roles;
    }

	public User(String username,String name, String phone, String poste, Role roles) {
		this.username = username;
		this.name = name;
		this.phone = phone;
        this.poste = poste;
        this.roles = roles;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}


    
}