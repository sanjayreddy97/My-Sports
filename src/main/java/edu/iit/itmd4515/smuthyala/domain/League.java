/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;

/**
 *
 * @author sanjayreddy
 */
@Entity
public class League {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long leagueId;
    
    @NotBlank
    @Size(min = 1,max = 20)
    @Column(nullable = false, unique = true, name = "leaguename", length = 20)
    private String leagueName;
    
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
    public void addTeams(Team t){
    
    }

    public League() {
    }
    

    public League(String leagueName, String teamWon, LocalDate startDate,LocalDate endDate, Integer prizeMoney) {
        this.leagueName = leagueName;
        this.teamWon = teamWon;
        this.startDate = startDate;
        this.endDate = endDate;
        this.prizeMoney = prizeMoney;
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
        final League other = (League) that;
        
        //can not compare if either database generated ID is null, return false.
        if( (this.leagueId == null) || (other.leagueId == null)){
            return false;
        }
        
        return Objects.equals(this.leagueId, other.leagueId);
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 23 * hash + Objects.hashCode(this.leagueId);
        return hash;
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

    /**
     * Get the value of sportId
     *
     * @return the value of sportId
     */
    public Long getLeagueId() {
        return leagueId;
    }

    /**
     * Set the value of sportId
     *
     * @param id new value of sportId
     */
    public void setLeagueId(Long leagueId) {
        this.leagueId = leagueId;
    }
    
    @Override
    public String toString() {
        return "League{" + "leagueId=" + leagueId + ", leagueName=" + leagueName + ", teamWon=" + teamWon + ", startDate=" + startDate + ", endDate=" + endDate + ", prizeMoney=" + prizeMoney + ", teams=" + teams + '}';
    }
   
}
