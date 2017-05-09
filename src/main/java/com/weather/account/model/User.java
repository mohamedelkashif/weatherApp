package com.weather.account.model;


import javax.persistence.*;
import java.util.Set;
/**
 * 
 * @author Mohamed Elkashif
 *
 */
@Entity
@Table(name = "user")
public class User {
    private Long id;
    private String username;
    private String password;
    private String passwordConfirm;
    private String phone;
    private String email;
    private Set<Role> roles;
    
    /**
     * setters and getters for user's model
     * @return
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }
    /**
     * 
     * @param id
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * 
     * @return
     */
    public String getUsername() {
        return username;
    }
    /**
     * 
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }
    /**
     * 
     * @return
     */
    public String getPassword() {
        return password;
    }
    /**
     * 
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    /**
     * 
     * @return
     */
    @Transient
    public String getPasswordConfirm() {
        return passwordConfirm;
    }
    /**
     * 
     * @param passwordConfirm
     */
    public void setPasswordConfirm(String passwordConfirm) {
        this.passwordConfirm = passwordConfirm;
    }
    
    
    /**
     * 
     * @return
     */
    public String getPhone() {
        return phone;
    }
    /**
     * 
     * @param phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    /**
     * 
     * @return
     */
    public String getEmail() {
        return email;
    }
    /**
     * 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * 
     * @return
     */
    @ManyToMany
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    public Set<Role> getRoles() {
        return roles;
    }
    /**
     * 
     * @param roles
     */
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

  
}