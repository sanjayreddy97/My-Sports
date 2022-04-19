/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import edu.iit.sat.itmd4515.smuthyala.service.LeagueService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sanjayreddy
 */
@Named
@RequestScoped
public class LeagueController {
    private static final Logger LOG = Logger.getLogger(SportController.class.getName());
    
    private League league;
    
    @EJB
    private LeagueService leagueSvc;
    
    public LeagueController(){
    }
    
    public SportType[] getAllSportTypes(){
        return SportType.values();
    } 
    
    @PostConstruct
    private void postContruct(){
        LOG.info("Post construct of LeagueController...");
        league = new League();
    }
    
    //action method
    public String saveLeague(){
        
        LOG.info("saveLeague method with " + this.league.toString());
        
        leagueSvc.create(league);
        
        LOG.info("saveLeague method after service invoked " + this.league.toString());
        
        return "welcome.xhtml"; 
    }

    public void setLeague(League league) {
        this.league = league;
    }

    public League getLeague() {
        return league;
    }
}
