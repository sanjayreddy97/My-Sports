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
 * Data loader class for application
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
    
    /**
     *
     */
    public StartupDataLoader(){
        
    }
    
    @PostConstruct
    private void postConstruct(){
        
        Group customerGroup = new Group("CUSTOMER_GROUP", "This group represents end users in the security realm");
        grpSvc.create(customerGroup);
        
        Group managerGroup = new Group("MANAGER_GROUP", "This group represents managers in the security realm");
        grpSvc.create(managerGroup);
        
        Group adminGroup = new Group("ADMIN_GROUP", "This group represents admins in the security realm");
        grpSvc.create(adminGroup);
        
        User admin = new User("Adminstrator","admin", "admin", true);
        admin.addGroup(adminGroup);
        
        usrSvc.create(admin);
        
        User user1 = new User("Test User","user1", "user1", true);
        user1.addGroup(customerGroup);
        User user2 = new User("Test User2","user2", "user2", true);
        user2.addGroup(customerGroup);
        
        usrSvc.create(user1);
        usrSvc.create(user2);
        
        User manager1 = new User("Test Manager","manager1", "manager1", true);
        manager1.addGroup(managerGroup);
        
        usrSvc.create(manager1);
        
        League l1 = new League(SportType.BASEBALL,"American League", LocalDate.of(2013, 5,10),LocalDate.of(2013, 7,10),10000);
        League l2 = new League(SportType.BASEBALL,"International League", LocalDate.of(2014, 6,10),LocalDate.of(2014, 7,10),10000);
        League l3 = new League(SportType.BASEBALL,"Minor League", LocalDate.of(2016, 9,10),LocalDate.of(2016, 11,10),5000);
        League l4 = new League(SportType.CRICKET, "Indian League", LocalDate.of(2015, 6,20),LocalDate.of(2015, 8,15),20000);
        League l5 = new League(SportType.CRICKET, "World Cup", LocalDate.of(2019, 3,20),LocalDate.of(2019, 6,15),2000000);
        League l6 = new League(SportType.CRICKET, "Ashes Serie", LocalDate.of(2017, 7,20),LocalDate.of(2017, 8,15),200000);
        League l7 = new League(SportType.SOCCER,"FIFA", LocalDate.of(2016, 3,19),LocalDate.of(2016, 6,10),50000);
        League l8 = new League(SportType.SOCCER,"Premier League", LocalDate.of(2019, 3,19),LocalDate.of(2019, 6,10),500000);
        League l9 = new League(SportType.SOCCER,"USL Championship", LocalDate.of(2018, 3,19),LocalDate.of(2018, 6,10),5000);
        League l10 = new League(SportType.BASKETBALL,"NBA", LocalDate.of(2019, 3,24),LocalDate.of(2019, 6,24),750000);
        League l11 = new League(SportType.BASKETBALL,"EURO League", LocalDate.of(2015, 2,24),LocalDate.of(2015, 3,24),75000);
        League l12 = new League(SportType.BASKETBALL,"WNBA", LocalDate.of(2017, 2,24),LocalDate.of(2017, 7,24),75000);
        legSvc.create(l1);
        legSvc.create(l2);
        legSvc.create(l3);
        legSvc.create(l4);
        legSvc.create(l5);
        legSvc.create(l6);
        legSvc.create(l7);
        legSvc.create(l8);
        legSvc.create(l9);
        legSvc.create(l10);
        legSvc.create(l11);
        legSvc.create(l12);
        
        Team t1= new Team("Chennai Super Kings", "India Cements", "Stephen Fleming");
        Team t2= new Team("Mumbai Indians", "Relaince Industries", "Jayawardane");
        Team t3= new Team("Royal Challengers Bangalore", "United Spirites", "Sanjay Bangar");
        Team t4= new Team("India", "Sahara", "Anil Kumble");
        Team t5= new Team("Australia", "Qantas", "Ricky ponting");
        Team t6= new Team("England", "New Balance", "Gary Kirsten");
        Team t7= new Team("Arizona Diamondbacks", "Ken Kendrick", "Torey Lovullo");
        Team t8= new Team("Chicago Cubs", "Thomas Stuart Ricketts", "David Ross");
        Team t9= new Team("Cleveland Guardians", "Larry Dolan Paul Dolan", "Terry Franconar");
        Team t10= new Team("Real Madrid", "Florentino Pérez Rodríguez", "Carlo Ancelotti");
        Team t11= new Team("Barcelona", "Josep Maria Bartomeu Floreta", "Xavi");
        Team t12= new Team("Manchester United", "Manchester United Plc", "Ralf Rangnick");
        teamSvc.create(t1);
        teamSvc.create(t2);
        teamSvc.create(t3);
        teamSvc.create(t4);
        teamSvc.create(t5);
        teamSvc.create(t6);
        teamSvc.create(t7);
        teamSvc.create(t8);
        teamSvc.create(t9);
        teamSvc.create(t10);
        teamSvc.create(t11);
        teamSvc.create(t12);
        l1.addTeam(t7);
        l1.addTeam(t8);
        l1.addTeam(t9);
        l4.addTeam(t1);
        l4.addTeam(t2);
        l4.addTeam(t3);
        l5.addTeam(t4);
        l5.addTeam(t5);
        l5.addTeam(t6);
        l6.addTeam(t5);
        l6.addTeam(t6);
        l7.addTeam(t10);
        l7.addTeam(t11);
        l7.addTeam(t12);
        
        Player p1 = new Player("Sachin Tendulkar", "India", 38, LocalDate.of(1982, 01,01), t4);
        Player p2 = new Player("Sehwag", "India", 38, LocalDate.of(1983, 03,21), t4);
        Player p3 = new Player("Virat Kohli", "India", 30, LocalDate.of(1991, 01,01), t4);
        Player p4 = new Player("Ronaldo", "Real Madrid", 25, LocalDate.of(1996, 01,01), t10);
        Player p5 = new Player("Messi", "Barcelone", 34, LocalDate.of(1987, 02,01), t11);
        Player p6 = new Player("Shohei Ohtani", "Chicago Cubs", 32, LocalDate.of(1982, 01,01), t8);
        Player p7 = new Player("Sam Dickens", "Chicago Cubs", 29, LocalDate.of(1992, 03,21), t8);
        Player p8 = new Player("Mike Trout", "Arizona Diamondbacks", 30, LocalDate.of(1991, 01,01), t7);
        Player p9 = new Player("Fernando Tatis Jr", "Arizona Diamondbacks", 25, LocalDate.of(1996, 01,01), t7);
        Player p10 = new Player("Babe Ruth", "Cleveland Guardians", 34, LocalDate.of(1987, 02,01), t9);
        Player p11 = new Player("Rahul Dravid", "India", 38, LocalDate.of(1982, 01,01), t4);
        Player p12 = new Player("Rishab Pant", "India", 24, LocalDate.of(1997, 03,21), t4);
        Player p13 = new Player("Sunil Gavaskar", "India", 30, LocalDate.of(1991, 01,01), t4);
        Player p14 = new Player("Ricky Ponting", "Australia", 38, LocalDate.of(1982, 01,01), t5);
        Player p15 = new Player("Mathew hayden", "Australia", 39, LocalDate.of(1982, 03,21), t5);
        Player p16 = new Player("Adam Gilchrist", "Australia", 40, LocalDate.of(1981, 01,01), t5);
        Player p17 = new Player("Alastair cook", "England", 35, LocalDate.of(1987, 05,01), t6);
        Player p18 = new Player("Tim David", "England", 24, LocalDate.of(1997, 03,21), t6);
        Player p19 = new Player("Joe Root", "England", 33, LocalDate.of(1989, 01,01), t6);
        plySvc.create(p1);
        plySvc.create(p2);
        plySvc.create(p3);
        plySvc.create(p4);
        plySvc.create(p5);
        plySvc.create(p6);
        plySvc.create(p7);
        plySvc.create(p8);
        plySvc.create(p9);
        plySvc.create(p10);
        plySvc.create(p11);
        plySvc.create(p12);
        plySvc.create(p13);
        plySvc.create(p14);
        plySvc.create(p15);
        plySvc.create(p16);
        plySvc.create(p17);
        plySvc.create(p18);
        plySvc.create(p19);
        t4.addPlayer(p1);
        t4.addPlayer(p2);
        t4.addPlayer(p3);
        t4.addPlayer(p11);
        t4.addPlayer(p12);
        t4.addPlayer(p13);
        t5.addPlayer(p14);
        t5.addPlayer(p15);
        t5.addPlayer(p16);
        t6.addPlayer(p17);
        t6.addPlayer(p18);
        t6.addPlayer(p19);
        t7.addPlayer(p8);
        t7.addPlayer(p9);
        t8.addPlayer(p6);
        t8.addPlayer(p7);
        t9.addPlayer(p10);
        t10.addPlayer(p4);
        t11.addPlayer(p5);
        
        Venue v1 = new Venue("KK Baseball Grounds", 30000 , "South Jefferson st");
        Venue v2 = new Venue("Lords Stadium", 25000 , "England");
        Venue v3 = new Venue("Wankhede stadium", 35000 , "Mumbai India");
        Venue v4 = new Venue("Wembley stadium", 15000 , "London");
        Venue v5 = new Venue("AT&T", 10000 , "Ann Arbor Michigan");
        Venue v6 = new Venue("Melbourne Cricket Ground", 45000 , "Australia");
        Venue v7 = new Venue("Sullivan Athletic Center", 1000 , "N Sheffield Ave, chicago");
        Venue v8 = new Venue("United Center", 1000 , "Chicago");
        vnuSvc.create(v1);
        vnuSvc.create(v2);
        vnuSvc.create(v3);
        vnuSvc.create(v4);
        vnuSvc.create(v5);
        vnuSvc.create(v6);
        vnuSvc.create(v7);
        vnuSvc.create(v8);
        l4.setVenue(v3);
        l5.setVenue(v3);
        l1.setVenue(v1);
        l2.setVenue(v1);
        l3.setVenue(v1);
        l6.setVenue(v6);
        l10.setVenue(v7);
        l12.setVenue(v8);
        l11.setVenue(v7);
        l7.setVenue(v4);
        l8.setVenue(v4);
        l9.setVenue(v5);
        
    }
}
