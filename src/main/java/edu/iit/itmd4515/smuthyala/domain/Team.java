/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author smuthyala
 */
@Entity
@NamedQuery(name = "Team.findAll", query = "select t from Team t")
public class Team extends GenericEntity {

    private String teamName;
    private String teamOwner;
    private String teamCoach;
    
    //Bi-directional relationship between League (owning) and Team (inverse).
    @ManyToMany
    @JoinTable(
            name = "TEAM_LEAGUES",
            joinColumns = @JoinColumn(name = "TEAM_ID"),
            inverseJoinColumns = @JoinColumn(name = "LEAGUE_ID")
    )
    private List<League> leagues = new ArrayList<> ();
    
    //Uni-directional relationship between Team and Player
    @OneToMany(mappedBy = "team")
    private List<Player> players = new ArrayList<>();

    /**
     *
     * @param teamName
     * @param teamCoach
     * @param teamOwner
     */
    public Team(String teamName, String teamOwner, String teamCoach) {
        this.teamName = teamName;
        this.teamOwner = teamOwner;
        this.teamCoach = teamCoach;
    }
    
    /**
     *
     * @param l
     * @return
     */
    public boolean removeLeague(League l) {
        return leagues.remove(l);
    }
    
    /**
     *
     * @param p
     */
    public void addPlayer(Player p){
        if(!this.getPlayers().contains(p)){
            this.getPlayers().add(p);
        }
    }
    
    /**
     *
     */
    public Team(){
    }
    
    /**
     *
     * @param players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    /**
     *
     * @return
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param leagues
     */
    public void setLeagues(List<League> leagues) {
        this.leagues = leagues;
    }

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
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

    /**
     *
     * @return
     */
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
    
    @Override
    public String toString() {
        return "Team{" + "teamId=" + Id + ", teamName=" + teamName + ", teamOwner=" + teamOwner + ", teamCoach=" + teamCoach + '}';
    }
    
}
