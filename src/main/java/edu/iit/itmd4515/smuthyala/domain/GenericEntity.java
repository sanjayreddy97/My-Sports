/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDateTime;
import java.util.Objects;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

/**
 * General Entity class 
 * @author sanjayreddy
 */
@MappedSuperclass
public class GenericEntity {

    /**
     *
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long Id;
        
    private LocalDateTime updatedTimestamp;
    private LocalDateTime createdTimestamp;
    
    private String lastUpdatedBy;
    
    @PrePersist
    private void generateCreatedTimestamp(){
        createdTimestamp = LocalDateTime.now();
    }
    
    @PreUpdate
    private void generateUpdatedTimestamp(){
        updatedTimestamp = LocalDateTime.now();
    }

    /**
     * Set the value of lastUpdatedBy
     *
     * @param lastUpdatedBy new value of lastUpdatedBy
     */
    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * returns user details who edited last  
     * @return
     */
    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }


    /**
     * Get the value of updatedTimestamp
     *
     * @return the value of updatedTimestamp
     */
    public LocalDateTime getUpdatedTimestamp() {
        return updatedTimestamp;
    }

    /**
     * Set the value of updatedTimestamp
     *
     * @param updatedTimestamp new value of updatedTimestamp
     */
    public void setUpdatedTimestamp(LocalDateTime updatedTimestamp) {
        this.updatedTimestamp = updatedTimestamp;
    }



    /**
     * Set the value of createdTimestamp
     *
     * @param createdTimestamp new value of createdTimestamp
     */
    public void setCreatedTimestamp(LocalDateTime createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    /**
     *
     * @return
     */
    public LocalDateTime getCreatedTimestamp() {
        return createdTimestamp;
    }

    /**
     *
     * @param Id
     */
    public void setId(Long Id) {
        this.Id = Id;
    }

    /**
     *
     * @return
     */
    public Long getId() {
        return Id;
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
        final GenericEntity other = (GenericEntity) obj;
        //can not compare if either database generated ID is null, return false.
        if( (this.Id == null) || (other.Id == null)){
            return false;
        }
        return Objects.equals(this.Id, other.Id);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 79 * hash + Objects.hashCode(this.Id);
        return hash;
    }
}
