/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.Player;
import edu.iit.itmd4515.smuthyala.domain.Team;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Service class for Player entity
 * @author smuthyala
 */
@Named
@Stateless
public class PlayerService extends GenericService<Player>{
    
     @PersistenceContext(name ="itmd4515PU")
    private EntityManager em;
     
    /**
     *
     */
    public PlayerService() {
        super(Player.class);
    }
    
    /**
     *
     * @return
     */
    @Override
    public List<Player> findAll() {
        return em.createNamedQuery("Player.findAll", Player.class).getResultList();
    }
    
    //CRUD operations

    /**
     *
     * @param p
     */
    public void create(Player p){
        em.persist(p);
    }
    
    /**
     *
     * @param Id
     * @return
     */
    public Player read(Long Id){
        return em.find(Player.class, Id);
    }
    
    /**
     *
     * @param p
     */
    public void update(Player p){
        em.merge(p);
    }
    
    /**
     *
     * @param p
     */
    public void delete(Player p){
        em.remove(em.merge(p));
    }
    
    /**
     *
     * @param p
     */
    public void updatePlayer(Player p){
        Player managedPlayerRef = em.getReference(Player.class, p.getId());
        
        if(! managedPlayerRef.getPlayerName().equals(p.getPlayerName())) managedPlayerRef.setPlayerName(p.getPlayerName());
        if(! managedPlayerRef.getAge().equals(p.getAge())) managedPlayerRef.setAge(p.getAge());
        if (p.getDateOfBirth() != null) managedPlayerRef.setDateOfBirth(p.getDateOfBirth());
        
        em.merge(managedPlayerRef);
    }
    
    /**
     *
     * @param p
     */
    public void deletePlayer(Player p){
        Player managedPlayerRef = em.getReference(Player.class, p.getId());
        
        em.remove(managedPlayerRef);
    }
    
}
