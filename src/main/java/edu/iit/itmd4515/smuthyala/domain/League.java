/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

/**
 *
 * @author smuthyala
 */
@Entity
@NamedQuery(name = "League.findAll", query = "select l from League l")
@NamedQuery(name = "League.findByName", query = "select l from League l where l.leagueName = :name")
@NamedQuery(name = "League.findById", query="select l from League l where l.id = :ID")
public class League extends GenericEntity{
    
    @NotBlank
    @Size(min = 1,max = 20)
    @Column(nullable = false, unique = true, name = "leaguename", length = 20)
    private String leagueName;
    
    @Enumerated(EnumType.STRING)
    private SportType type;
    
    private String teamWon;
    
    @PastOrPresent
    private LocalDate startDate;
    private LocalDate endDate;
    
    @Min(0)
    private Integer prizeMoney;
    
    //Uni-directional relationship between League and Sport
    @ManyToOne
    @JoinColumn(name = "SPORT_ID")
    private Sport sport;
    
    //Uni-directional relationship between League and Venue
    @ManyToOne
    @JoinColumn(name = "VENUE_ID")
    private Venue venue;
    
    // Bi-directional relationship between League (owning) and Team (inverse).
    @ManyToMany
    @JoinTable(
            name = "LEAGUE_TEAMS",
            joinColumns = @JoinColumn(name = "LEAGUE_ID"),
            inverseJoinColumns = @JoinColumn(name = "TEAM_ID")
    )
    private List<Team> teams = new ArrayList<>();

    public boolean removeTeam(Team t) {
        return teams.remove(t);
    }
    
    //helper methods
    public void addTeam(Team t){
            if(!this.getTeams().contains(t)){
                this.getTeams().add(t);
            }
            if(!t.getLeagues().contains(this)){
                t.getLeagues().add(this);
            }
    }

    public League() {
    }
    

    public League(SportType type, String leagueName, LocalDate startDate,LocalDate endDate, Integer prizeMoney) {
        this.leagueName = leagueName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.prizeMoney = prizeMoney;
        this.type = type;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Sport getSport() {
        return sport;
    }
    
    public SportType getType() {
        return type;
    }

    public void setType(SportType type) {
        this.type = type;
    }
    
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
     * Get the value of teamWon
     *
     * @return the value of teamWon
     */
    public String getTeamWon() {
        return teamWon;
    }

    /**
     * Set the value of teamWon
     *
     * @param teamWon new value of teamWon
     */
    public void setTeamWon(String teamWon) {
        this.teamWon = teamWon;
    }


    /**
     * Set the value of prizeMoney
     *
     * @param prizeMoney new value of prizeMoney
     */
    public void setPrizeMoney(Integer prizeMoney) {
        this.prizeMoney = prizeMoney;
    }
    public Integer getPrizeMoney() {
        return prizeMoney;
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
        return "League{" + "leagueId=" + id + ", leagueName=" + leagueName + ", teamWon=" + teamWon + ", startDate=" + startDate + ", endDate=" + endDate + ", prizeMoney=" + prizeMoney + ", teams=" + teams + ", venue=" + venue + ", type=" + type + '}';
    }
   
}
