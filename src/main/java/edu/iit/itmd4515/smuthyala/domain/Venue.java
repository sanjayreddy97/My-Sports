/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author sanjayreddy
 */
@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long venueId;
    
    private Long capacity;
    
    private String address;
    private String venueName;
    
    //uni-directional relation between Venue and League
    @OneToMany(mappedBy = "venue")
    private List<League> leagues = new ArrayList<> ();

    public Venue(Long capacity, String address, String venueName) {
        this.capacity = capacity;
        this.address = address;
        this.venueName = venueName;
    }
    
    public Venue(){
        
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Venue other = (Venue) obj;
        //can not compare if either database generated ID is null, return false.
        if( (this.venueId == null) || (other.venueId == null)){
            return false;
        }
        return Objects.equals(this.venueId, other.venueId);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.venueId);
        return hash;
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
    public Long getCapacity() {
        return capacity;
    }

    /**
     * Set the value of capacity
     *
     * @param capacity new value of capacity
     */
    public void setCapacity(Long capacity) {
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



    /**
     * Set the value of teamId
     *
     * @param venueId new value of teamId
     */
    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
    public Long getVenueId() {
        return venueId;
    }
    
    @Override
    public String toString() {
        return "Venue{" + "venueId=" + venueId + ", capacity=" + capacity + ", address=" + address + ", venueName=" + venueName + '}';
    }
    
}
