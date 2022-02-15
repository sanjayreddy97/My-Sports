/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

/**
 *
 * @author sanjayreddy
 */
@Entity
public class Sport {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long sportId;
    
    @NotBlank
    @Size(min = 1,max = 20)
    @Column(nullable = false, unique = true, name = "leaguename", length = 20)
    private String leagueName;
    
    @PastOrPresent
    private LocalDate startDate;
    private LocalDate endDate;
    
    @Enumerated(EnumType.STRING)
    private SportType type;

    public Sport(String leagueName, LocalDate startDate,LocalDate endDate, SportType type) {
        this.leagueName = leagueName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.type = type;
    }
    
    
    public Sport(){
        
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        final Sport other = (Sport) that;
        
        //can not compare if either database generated ID is null, return false.
        if( (this.sportId == null) || (other.sportId == null)){
            return false;
        }
        
        return Objects.equals(this.sportId, other.sportId);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.sportId);
        return hash;
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
     * Get the value of startDate
     *
     * @return the value of startDate
     */
    public LocalDate getStartDate() {
        return startDate;
    }

    /**
     * Set the value of startDate
     *
     * @param startDate new value of birthDate
     */
    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }
    
    public LocalDate getEndDate() {
        return endDate;
    }
    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
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


    /**
     * Get the value of sportId
     *
     * @return the value of sportId
     */
    public Long getSportId() {
        return sportId;
    }

    /**
     * Set the value of sportId
     *
     * @param id new value of sportId
     */
    public void setSportId(Long sportId) {
        this.sportId = sportId;
    }

    @Override
    public String toString() {
        return "Sport{" + "sportId=" + sportId + ", leagueName=" + leagueName + ", startDate=" + startDate + ",endDate=" + endDate +", type=" + type + '}';
    } 
}
