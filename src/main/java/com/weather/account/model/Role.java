package com.weather.account.model;

import javax.persistence.*;
import java.util.Set;

/**
 * 
 * @author Mohamed Elkashif
 *
 */
@Entity
@Table(name = "role")
public class Role {
    private Long id;
    private String name;
    private Set<User> users;

    /**
     * get id
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
    public String getName() {
        return name;
    }
    /**
     * 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return
     */
    @ManyToMany(mappedBy = "roles")
    public Set<User> getUsers() {
        return users;
    }
    /**
     * 
     * @param users
     */
    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
