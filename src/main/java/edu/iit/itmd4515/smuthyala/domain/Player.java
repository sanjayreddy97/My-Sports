/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

// Id,playerName, age, dateOfBirth, gender,teamName.
/**
 *
 * @author sanjayreddy
 */
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long playerId;
    
    private String playerName;
    private String teamName;
    
    private int age;
    
    private LocalDate dateOfBirth;
    
    //uni-directional relationship between Player and Team
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Player(Long playerId, String playerName, String teamName, int age, LocalDate dateOfBirth) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.teamName = teamName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
    }
    
    public Player(){
        
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
        final Player other = (Player) obj;
        //can not compare if either database generated ID is null, return false.
        if( (this.playerId == null) || (other.playerId == null)){
            return false;
        }
        return Objects.equals(this.playerId, other.playerId);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.playerId);
        return hash;
    }
    
    
    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    /**
     * Get the value of teamName
     *
     * @return the value of teamName
     */
    public String getTeamName() {
        return teamName;
    }

    /**
     * Set the value of teamName
     *
     * @param teamName new value of teamName
     */
    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    /**
     * Get the value of dateOfBirth
     *
     * @return the value of dateOfBirth
     */
    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    /**
     * Set the value of dateOfBirth
     *
     * @param dateOfBirth new value of dateOfBirth
     */
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }


    /**
     * Set the value of age
     *
     * @param age new value of age
     */
    public void setAge(int age) {
        this.age = age;
    }
    public int getAge() {
        return age;
    }


    /**
     * Get the value of playerName
     *
     * @return the value of playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     * Set the value of playerName
     *
     * @param playerName new value of playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }


    /**
     * Set the value of teamId
     *
     * @param venueId new value of teamId
     */
    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }
    public Long getPlayerId() {
        return playerId;
    }
    
     @Override
    public String toString() {
        return "Player{" + "playerId=" + playerId + ", playerName=" + playerName + ", teamName=" + teamName + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", team=" + team + '}';
    }
}
