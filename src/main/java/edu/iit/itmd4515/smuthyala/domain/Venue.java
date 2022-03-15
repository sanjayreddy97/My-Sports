/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author sanjayreddy
 */
@Entity
@NamedQuery(name = "Venue.findAll", query = "select v from Venue v")
public class Venue extends GenericEntity {
    
    private int capacity;
    
    private String address;
    private String venueName;
    
    //uni-directional relation between Venue and League
    @OneToMany(mappedBy = "venue")
    private List<League> leagues = new ArrayList<> ();

    public Venue(String venueName, int capacity, String address) {
        this.capacity = capacity;
        this.address = address;
        this.venueName = venueName;
    }
    
    public Venue(){
        
    }
    
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    public List<League> getLeagues() {
        return leagues;
    }

    /**
     * Get the value of capacity
     *
     * @return the value of capacity
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * Set the value of capacity
     *
     * @param capacity new value of capacity
     */
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    
    
    /**
     * Set the value of address
     *
     * @param address new value of address
     */
    public void setAddress(String address) {
        this.address = address;
    }
    public String getAddress() {
        return address;
    }


    /**
     * Get the value of venueName
     *
     * @return the value of venueName
     */
    public String getVenueName() {
        return venueName;
    }

    /**
     * Set the value of venueName
     *
     * @param venueName new value of venueName
     */
    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
    
    @Override
    public String toString() {
        return "Venue{" + "venueId=" + id + ", capacity=" + capacity + ", address=" + address + ", venueName=" + venueName + '}';
    }
    
}
