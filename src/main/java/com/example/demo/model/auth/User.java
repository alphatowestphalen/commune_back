package com.example.demo.model.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String username;

    @Column
  //  @JsonIgnore
    private String password;

    @Column
    private String role;

    @Column
    private String phone;

    @Column
    private String name;

    @Column
    private String poste;

    // @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    // @JoinTable(name = "USER_ROLES",
    //         joinColumns = {
    //         @JoinColumn(name = "USER_ID")
    //         },
    //         inverseJoinColumns = {
    //         @JoinColumn(name = "ROLE_ID") })


//    private Set<Role> roles;

    @OneToOne
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

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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

    
}