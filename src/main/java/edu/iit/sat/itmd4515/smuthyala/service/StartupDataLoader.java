/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.Player;
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
    private UserService usrSvc;
    
    @EJB
    private GroupService grpSvc;
    
    public StartupDataLoader(){
        
    }
    
    @PostConstruct
    private void postConstruct(){
        
        Group userGroup = new Group("USER_GROUP", "This group represents users in the security realm");
        grpSvc.create(userGroup);
        
        Group managerGroup = new Group("MANAGER_GROUP", "This group represents managers in the security realm");
        grpSvc.create(managerGroup);
        
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents admins in the security realm");
        grpSvc.create(adminGroup);
        
        User admin = new User("Adminstrator","admin", "admin", true);
        admin.addGroup(adminGroup);
        
        usrSvc.create(admin);
        
        User player1 = new User("User1","player1", "player1", true);
        player1.addGroup(userGroup);
        User player2 = new User("User2","player2", "player2", true);
        player2.addGroup(userGroup);
        
        usrSvc.create(player1);
        usrSvc.create(player2);
        
        User manager1 = new User("Manager1","manager1", "manager1", true);
        manager1.addGroup(managerGroup);
        
        usrSvc.create(manager1);
        
        League l1 = new League(SportType.BASEBALL,"League One", LocalDate.of(2013, 5,10),LocalDate.of(2013, 7,10),100000);
        League l2 = new League(SportType.CRICKET, "League Two", LocalDate.of(2015, 6,20),LocalDate.of(2015, 8,15),200000);
        League l3 = new League(SportType.SOCCER,"League Three", LocalDate.of(2020, 3,19),LocalDate.of(2020, 6,10),50000);
        League l4 = new League(SportType.BASKETBALL,"League Four", LocalDate.of(2018, 2,24),LocalDate.of(2018, 3,24),75000);
        legSvc.create(l1);
        legSvc.create(l2);
        legSvc.create(l3);
        legSvc.create(l4);
        
        Team t1= new Team("Team One", "Team Owner One", "Team Coach One");
        Team t2= new Team("Team Two", "Team Owner Two", "Team Coach Two");
        Team t3= new Team("Team Three", "Team Owner Three", "Team Coach Three");
        teamSvc.create(t1);
        teamSvc.create(t2);
        teamSvc.create(t3);
        l1.addTeam(t1);
        l1.addTeam(t2);
        l1.addTeam(t3);
        l2.addTeam(t2);
        
        Player p1 = new Player("player One", "Team One", 23, LocalDate.of(1998, 01,01), t1);
        Player p2 = new Player("player Two", "Team Two", 26, LocalDate.of(1995, 03,21), t2);
        Player p3 = new Player("player Three", "Team One", 24, LocalDate.of(1997, 01,01), t1);
        Player p4 = new Player("player Four", "Team Three", 25, LocalDate.of(1996, 01,01), t1);
        Player p5 = new Player("player Five", "Team One", 22, LocalDate.of(1999, 01,01), t1);
        plySvc.create(p1);
        plySvc.create(p2);
        plySvc.create(p3);
        plySvc.create(p4);
        plySvc.create(p5);
        t1.addPlayer(p1);
        t2.addPlayer(p2);
        t1.addPlayer(p3);
        t1.addPlayer(p4);
        t1.addPlayer(p5);
        
        Venue v1 = new Venue("venue One", 10000 , "South Jefferson st");
        Venue v2 = new Venue("venue Two", 15000 , "South Loop");
        vnuSvc.create(v1);
        vnuSvc.create(v2);
        l1.setVenue(v1);
        l2.setVenue(v2);
        
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
