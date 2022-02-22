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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author sanjayreddy
 */
@Entity
public class Team {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long teamId;

    private String teamName;
    private String teamOwner;
    private String teamCoach;
    
    //Bi-directional relationship between League (owning) and Team (inverse).
    @ManyToMany(mappedBy = "teams")
    private List<League> leagues = new ArrayList<> ();
    
    //Uni-directional relationship between Team and Player
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    public Team(String teamName, String teamOwner, String teamCoach) {
        this.teamName = teamName;
        this.teamOwner = teamOwner;
        this.teamCoach = teamCoach;
    }
    
    public Team(){
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
        final Team other = (Team) obj;
        //can not compare if either database generated ID is null, return false.
        if( (this.teamId == null) || (other.teamId == null)){
            return false;
        }
        return Objects.equals(this.teamId, other.teamId);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.teamId);
        return hash;
    }
    
    

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    public List<League> getLeagues() {
        return leagues;
    }


    /**
     * Set the value of teamCoach
     *
     * @param teamCoach new value of teamCoach
     */
    public void setTeamCoach(String teamCoach) {
        this.teamCoach = teamCoach;
    }
    public String getTeamCoach() {
        return teamCoach;
    }


    /**
     * Set the value of teamOwner
     *
     * @param teamOwner new value of teamOwner
     */
    public void setTeamOwner(String teamOwner) {
        this.teamOwner = teamOwner;
    }
    public String getTeamOwner() {
        return teamOwner;
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
     * Set the value of teamId
     *
     * @param teamId new value of teamId
     */
    public void setTeamId(Long teamId) {
        this.teamId = teamId;
    }
    public Long getTeamId() {
        return teamId;
    }
    
    @Override
    public String toString() {
        return "Team{" + "teamId=" + teamId + ", teamName=" + teamName + ", teamOwner=" + teamOwner + ", teamCoach=" + teamCoach + ", leagues=" + leagues + '}';
    }
    
}
