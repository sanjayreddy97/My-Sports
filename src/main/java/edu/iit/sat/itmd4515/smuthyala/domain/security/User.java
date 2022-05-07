/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.domain.security;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

/**
 *
 * @author sanjayreddy
 */
@Entity
@Table(name="sec_user")
@NamedQuery(name = "User.findAll", query = "Select u from User u")
@EntityListeners(UserListener.class)
public class User{
    
    @Id
    @NotBlank(message = "Username is required")
    private String userName;
    
    @NotBlank(message = "Name is required")
    private String profileName;
    
    @NotBlank(message = "Password is required")
    private String password;
    private boolean enabled;
    
    @ManyToMany
    @JoinTable(name = "sec_user_groups",
            joinColumns = @JoinColumn(name = "USERNAME"),
            inverseJoinColumns = @JoinColumn(name = "GROUPNAME"))
    private List<Group> groups = new ArrayList<>();

    public User(String profileName,String userName, String password, boolean enabled) {
        this.profileName = profileName;
        this.enabled = enabled;
        this.password = password;
        this.userName = userName;
    }

    public void setProfileName(String profileName) {
        this.profileName = profileName;
    }

    public String getprofileName() {
        return profileName;
    }
    
    public void addGroup(Group g){
        if(!this.groups.contains(g))
            this.groups.add(g);
        if(!g.getUsers().contains(this))
            g.getUsers().add(this);
    }
    
    public void removeGroup(Group g){
        if(this.groups.contains(g))
            this.groups.remove(g);
        if(g.getUsers().contains(this))
            g.getUsers().remove(this);
    }
    
    public User() {
    }
    public List<Group> getGroups() {
        return groups;
    }
    public void setGroups(List<Group> groups) {
        this.groups = groups;
    }

    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * Set the value of password
     *
     * @param password new value of password
     */
    public void setPassword(String password) {
        this.password = password;
    }
    public String getPassword() {
        return password;
    }


    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }
    
    @Override
    public String toString() {
        return "User{" + "enabled=" + enabled + ", password=" + password + ", userName=" + userName + '}';
    }

}
