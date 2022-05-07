/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.Team;
import edu.iit.itmd4515.smuthyala.domain.Venue;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author smuthyala
 */
@Named
@Stateless
public class LeagueService {
    
    @PersistenceContext(name ="itmd4515PU")
    private EntityManager em;
    
    public LeagueService(){
        
    }
    
    //CRUD operations
    public void create(League l){
        em.persist(l);
    }
    
    public League read(Long id){
        return em.find(League.class, id);
    }
    
    public void update(League l){
        em.merge(l);
    }
    
    public void delete(League l){
        em.remove(em.merge(l));
    }
    
    public List<League> findAll(){
        return em.createNamedQuery("League.findAll", League.class).getResultList();
    }
    
    public List<Team> findAllTeams(Long id){
        return em.createQuery("select t from Team t join t.leagues l where l.Id= " + id).getResultList();
    }
    
    public void updateLeague(League l){
        League managedLeagueRef = em.getReference(League.class, l.getId());
        
        if(! managedLeagueRef.getLeagueName().equals(l.getLeagueName())) managedLeagueRef.setLeagueName(l.getLeagueName());
        if (l.getStartDate() != null) managedLeagueRef.setStartDate(l.getStartDate());
        if (l.getEndDate() != null) managedLeagueRef.setEndDate(l.getEndDate());
        if(! managedLeagueRef.getType().equals(l.getType())) managedLeagueRef.setType(l.getType());
        if(! managedLeagueRef.getPrizeMoney().equals(l.getPrizeMoney())) managedLeagueRef.setPrizeMoney(l.getPrizeMoney());
        
        em.merge(managedLeagueRef);
    }
    
    public void deleteLeague(League l){
        League managedLeagueRef = em.getReference(League.class, l.getId());
        
        List<Team> teams = em.createNamedQuery("Team.findAll", Team.class).getResultList();
        
        for(Team t: teams){
           if(t.getLeagues().contains(l))
               t.removeLeague(l);
        }
        
        Venue v = managedLeagueRef.getVenue();
        if(v.getLeagues().contains(l))
            v.removeLeague(l);
        
        em.remove(managedLeagueRef);
    }
    
}
