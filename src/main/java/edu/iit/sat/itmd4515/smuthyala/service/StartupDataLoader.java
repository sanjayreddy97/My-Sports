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
import edu.iit.sat.itmd4515.smuthyala.domain.security.Group;
import edu.iit.sat.itmd4515.smuthyala.domain.security.User;
import edu.iit.sat.itmd4515.smuthyala.service.security.GroupService;
import edu.iit.sat.itmd4515.smuthyala.service.security.UserService;
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
    
    @EJB
    private UserService usrSvc;
    
    @EJB
    private GroupService grpSvc;
    
    public StartupDataLoader(){
        
    }
    
    @PostConstruct
    private void postConstruct(){
        
        Group userGroup = new Group("USER_GROUP", "This group represents users in the security realm");
        Group managerGroup = new Group("MANAGER_GROUP", "This group represents managers in the security realm");
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents admins in the security realm");
        grpSvc.create(userGroup);
        grpSvc.create(managerGroup);
        grpSvc.create(adminGroup);
        
        User admin = new User("admin", "admin", true);
        admin.addGroup(adminGroup);
        usrSvc.create(admin);
        
        User player1 = new User("player1", "player1", true);
        player1.addGroup(userGroup);
        User player2 = new User("player2", "player2", true);
        player2.addGroup(userGroup);
        
        usrSvc.create(player1);
        usrSvc.create(player2);
        
        User manager1 = new User("manager1", "manager1", true);
        manager1.addGroup(managerGroup);
        
        usrSvc.create(manager1);
        
        League l1 = new League("League One", LocalDate.of(2013, 5,10),LocalDate.of(2013, 7,10),100000);
        League l2 = new League("League Two", LocalDate.of(2015, 6,20),LocalDate.of(2015, 8,15),200000);
        League l3 = new League("League Three", LocalDate.of(2020, 3,19),LocalDate.of(2020, 6,10),50000);
        League l4 = new League("League Four", LocalDate.of(2018, 2,24),LocalDate.of(2018, 3,24),75000);
        legSvc.create(l1);
        legSvc.create(l2);
        legSvc.create(l3);
        legSvc.create(l4);
        
        Team t1= new Team("Team One", "Team Owner One", "Team Coach One");
        Team t2= new Team("Team Two", "Team Owner Two", "Team Coach Two");
        teamSvc.create(t1);
        teamSvc.create(t2);
        l1.addTeam(t1);
        l2.addTeam(t2);
        
        Player p1 = new Player("player One", "Team One", 23, LocalDate.of(1998, 01,01), t1);
        p1.setUser(player1);
        Player p2 = new Player("player Two", "Team Two", 26, LocalDate.of(1995, 03,21), t2);
        p2.setUser(player2);
        plySvc.create(p1);
        plySvc.create(p2);
        t1.addPlayer(p1);
        t2.addPlayer(p2);
        
        Venue v1 = new Venue("venue One", 10000 , "South Jefferson st");
        Venue v2 = new Venue("venue Two", 15000 , "South Loop");
        vnuSvc.create(v1);
        vnuSvc.create(v2);
        l1.setVenue(v1);
        l2.setVenue(v2);
        
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
