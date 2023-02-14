package com.example.demo.model.auth;
public class UserDto {
    
    private String username;
    private String password;
    private String role;
    private String phone;
    private String name;
    private String poste;


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

    public User getUserFromDto(){
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        user.setPhone(phone);
        user.setName(name);
        user.setPoste(poste);
        
        return user;
    }
    
}