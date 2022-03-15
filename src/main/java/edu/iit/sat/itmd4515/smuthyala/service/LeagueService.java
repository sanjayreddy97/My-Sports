/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.League;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author sanjayreddy
 */
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
    
}
