/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.Player;
import edu.iit.itmd4515.smuthyala.domain.Team;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Service class for Team entity
 * @author smuthyala
 */
@Named
@Stateless
public class TeamService extends GenericService<Team>{

    @PersistenceContext(name ="itmd4515PU")
    private EntityManager em;
    
    /**
     *
     */
    public TeamService() {
        super(Team.class);
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Team> findAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }
    
    //CRUD operations

    /**
     *
     * @param t
     */
    public void create(Team t){
        em.persist(t);
    }
    
    /**
     *
     * @param Id
     * @return
     */
    public Team read(Long Id){
        return em.find(Team.class, Id);
    }
    
    /**
     *
     * @param t
     */
    public void update(Team t){
        em.merge(t);
    }
    
    /**
     *
     * @param t
     */
    public void delete(Team t){
        em.remove(em.merge(t));
    }
    
    /**
     *
     * @param id
     * @return
     */
    public List<Player> findAllPlayers(Long id){
        return em.createQuery("select p from Player p join p.team t where t.Id= " + id).getResultList();
    }
    
    /**
     *
     * @param t
     */
    public void updateTeam(Team t){
        Team managedTeamRef = em.getReference(Team.class, t.getId());
        
        if(! managedTeamRef.getTeamName().equals(t.getTeamName())) managedTeamRef.setTeamName(t.getTeamName());
        if(! managedTeamRef.getTeamOwner().equals(t.getTeamOwner())) managedTeamRef.setTeamOwner(t.getTeamOwner());
        if(! managedTeamRef.getTeamCoach().equals(t.getTeamCoach())) managedTeamRef.setTeamCoach(t.getTeamCoach());
        
        em.merge(managedTeamRef);
    }
    
    /**
     *
     * @param t
     */
    public void deleteTeam(Team t){
        Team managedTeamRef = em.getReference(Team.class, t.getId());
        
        List<League> lgs = em.createNamedQuery("League.findAll", League.class).getResultList();
        
        for(League l: lgs){
           if(l.getTeams().contains(t))
               l.removeTeam(t);
        }
        
        List<Player> players = em.createNamedQuery("Player.findByTeam", Player.class)
                .setParameter("ID", t.getId())
                .getResultList();
        
        for(Player p: players){
            p.removeTeam();
        }
        
        em.remove(managedTeamRef);
    }
    
}
