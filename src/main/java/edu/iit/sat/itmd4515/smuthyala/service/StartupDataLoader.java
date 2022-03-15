/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.Player;
import edu.iit.itmd4515.smuthyala.domain.Sport;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import edu.iit.itmd4515.smuthyala.domain.Team;
import edu.iit.itmd4515.smuthyala.domain.Venue;
import java.time.LocalDate;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

/**
 *
 * @author smuthyala
 */
@Startup
@Singleton
public class StartupDataLoader {

    private static final Logger LOG = Logger.getLogger(StartupDataLoader.class.getName());
    
    @EJB
    private LeagueService legSvc;
    
    @EJB
    private TeamService teamSvc;
    
    @EJB
    private PlayerService plySvc;
    
    @EJB
    private VenueService vnuSvc;
    
    @EJB
    private SportService sptSvc;
    
    public StartupDataLoader(){
        
    }
    
    @PostConstruct
    private void postConstruct(){
        
        League l1 = new League("League One", LocalDate.of(2013, 5,10),LocalDate.of(2013, 7,10),100000);
        League l2 = new League("League Two", LocalDate.of(2015, 6,20),LocalDate.of(2015, 8,15),200000);
        legSvc.create(l1);
        legSvc.create(l2);
        
        Team t1= new Team("Team One", "Team Owner One", "Team Coach One");
        Team t2= new Team("Team Two", "Team Owner Two", "Team Coach Two");
        teamSvc.create(t1);
        teamSvc.create(t2);
        l1.addTeam(t1);
        l2.addTeam(t2);
        
        Player p1 = new Player("player One", "Team One", 23, LocalDate.of(1998, 01,01), t1);
        Player p2 = new Player("player Two", "Team Two", 26, LocalDate.of(1995, 03,21), t2);
        plySvc.create(p1);
        plySvc.create(p2);
        t1.addPlayer(p1);
        t2.addPlayer(p2);
        
        Venue v1 = new Venue("venue One", 10000 , "South Jefferson st");
        Venue v2 = new Venue("venue Two", 15000 , "South Loop");
        vnuSvc.create(v1);
        vnuSvc.create(v2);
        
        Sport s1 = new Sport("League One", SportType.BASEBALL);
        Sport s2 = new Sport("League Two", SportType.CRICKET);
        sptSvc.create(s1);
        sptSvc.create(s2);
        
        LOG.info("Satisfying the OUTPUT Requirement");
        for(League league: legSvc.findAll()){
            LOG.info("League ======> " + league.toString());
            
            for(Team team: teamSvc.findAll()){
                LOG.info("Team ======> " + team.toString());
                
                for(Player player: plySvc.findAll()){
                    LOG.info("Player ======> " + player.toString());
                }
            }
        }
    }
}
