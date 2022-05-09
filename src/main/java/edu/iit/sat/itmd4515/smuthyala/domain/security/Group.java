/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.domain.security;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author sanjayreddy
 */
@Entity
@Table(name="sec_group")
@NamedQuery(name = "Group.findAll", query = "Select g from Group g")
public class Group {
    
    @Id
    private String groupName;
    private String groupDesc;
    
    @ManyToMany(mappedBy = "groups")
    private List<User> users = new ArrayList<>();

    /**
     *
     */
    public Group() {
    }
    
    /**
     *
     * @param groupName
     * @param groupDesc
     */
    public Group(String groupName, String groupDesc) {
        this.groupDesc = groupDesc;
        this.groupName = groupName;
    }

    /**
     *
     * @return
     */
    public List<User> getUsers() {
        return users;
    }

    /**
     *
     * @param users
     */
    public void setUsers(List<User> users) {
        this.users = users;
    }
    
    
    /**
     * Set the value of groupDesc
     *
     * @param groupDesc new value of groupDesc
     */
    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    /**
     *
     * @return
     */
    public String getGroupDesc() {
        return groupDesc;
    }


    /**
     * Set the value of groupName
     *
     * @param groupName new value of groupName
     */
    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    /**
     *
     * @return
     */
    public String getGroupName() {
        return groupName;
    }
    
    @Override
    public String toString() {
        return "Group{" + "groupName=" + groupName + ", groupDesc=" + groupDesc + '}';
    }
    
}
