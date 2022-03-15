/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.NamedQuery;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 *
 * @author sanjayreddy
 */
@Entity
@NamedQuery(name = "Sport.findAll", query = "select s from Sport s")
public class Sport extends GenericEntity{
    
    @NotBlank
    @Size(min = 1,max = 20)
    @Column(nullable = false, unique = true, name = "leaguename", length = 20)
    private String leagueName;
    
    @Enumerated(EnumType.STRING)
    private SportType type;

    public Sport(String leagueName, SportType type) {
        this.leagueName = leagueName;
        this.type = type;
    }
    
    public Sport(){
        
    }

    /**
     * Get the value of type
     *
     * @return the value of type
     */
    public SportType getType() {
        return type;
    }

    /**
     * Set the value of type
     *
     * @param type new value of type
     */
    public void setType(SportType type) {
        this.type = type;
    }


    /**
     * Get the value of leagueName
     *
     * @return the value of leagueName
     */
    public String getLeagueName() {
        return leagueName;
    }

    /**
     * Set the value of leagueName
     *
     * @param leagueName new value of leagueName
     */
    public void setLeagueName(String leagueName) {
        this.leagueName = leagueName;
    }

    @Override
    public String toString() {
        return "Sport{" + "sportId=" + id + ", leagueName=" + leagueName + ", type=" + type + '}';
    } 
}
