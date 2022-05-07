/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import edu.iit.sat.itmd4515.smuthyala.domain.security.User;
import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

// Id,playerName, age, dateOfBirth, gender,teamName.
/**
 *
 * @author smuthyala
 */
@Entity
@NamedQuery(name = "Player.findAll", query = "select p from Player p")
@NamedQuery(name = "Player.findByTeam", query="select p from Player p where p.team.Id = :ID")
public class Player extends GenericEntity{
    
    private String playerName;
    private String teamName;
    
    private Integer age;
    
    private LocalDate dateOfBirth;
    
    //uni-directional relationship between Player and Team
    @ManyToOne
    @JoinColumn(name = "TEAM_ID")
    private Team team;

    public Player(String playerName, String teamName, Integer age, LocalDate dateOfBirth, Team team) {
        this.playerName = playerName;
        this.teamName = teamName;
        this.age = age;
        this.dateOfBirth = dateOfBirth;
        this.team = team;
    }
    
    public Player(){
        
    }
    
    public void removeTeam(){
        if(this.team.getPlayers().contains(this))
            this.team.getPlayers().remove(this);
        
        this.team = null;
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
    public void setAge(Integer age) {
        this.age = age;
    }
    public Integer getAge() {
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
    
     @Override
    public String toString() {
        return "Player{" + "playerId=" + Id + ", playerName=" + playerName + ", teamName=" + teamName + ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", team=" + team + '}';
    }
}
