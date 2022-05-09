/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

/**
 *
 * @author sanjayreddy
 */
public class LeagueJPARelationshipTest extends AbstractJPATest {
    
    /**
     *
     */
    @Test
    public void testBiDirectionalManyToManyLeagueTeamRelationship(){
        
        League l = new League(SportType.CRICKET, "Test League", LocalDate.of(2013, 5,10), LocalDate.of(2013, 8,21),120000);
        Team t = new Team("Test Team", "Team Owner", "Team Coach");
        
        l.getTeams().add(t);
        t.getLeagues().add(l);
        
        tx.begin();
        em.persist(l);
        em.persist(t);
        tx.commit();
        
        System.out.println("owning side" + l.getTeams().toString());
        System.out.println("Inverse side" + t.getLeagues().toString());
        
        //assert success
        assertTrue(l.getTeams().size() == 1);
        assertTrue(t.getLeagues().size() == 1);
        
        //clean up the data
        tx.begin();
        l.removeTeam(t);
        em.remove(t);
        em.remove(l);
        tx.commit();
    }  
    
    /**
     *
     */
    @Test
    public void testUniDirectionalOneToManyTeamPlayerRelationship(){
        Team t = new Team("TestTeam2","TeamOwner", "TeamCoach");
        Player p1 = new Player("Test Player1", "TestTeam2", 21, LocalDate.of(2000, Month.MAY, 21),t);
        Player p2 = new Player("Test Player2", "TestTeam2", 24, LocalDate.of(1996, Month.MAY, 28),t);
        
        t.getPlayers().add(p1);
        t.getPlayers().add(p2);
        
        tx.begin();
        em.persist(t);
        em.persist(p1);
        em.persist(p2);
        tx.commit();
        
        System.out.println("Number of players added: " + t.getPlayers().size());
        
        assertTrue(t.getPlayers().size() == 2);
        
        //clean up the data
        tx.begin();
        em.remove(p1);
        em.remove(p2);
        em.remove(t);
        tx.commit();
           
    }
}
