/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.Venue;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author smuthyala
 */
@Named
@Stateless
public class VenueService extends GenericService<Venue>{
    
    @PersistenceContext(name ="itmd4515PU")
    private EntityManager em;

    public VenueService() {
        super(Venue.class);
    }
    
    //CRUD operations
    public void create(Venue v){
        em.persist(v);
    }
    
    public Venue read(Long Id){
        return em.find(Venue.class, Id);
    }
    
    public void update(Venue v){
        em.merge(v);
    }
    
    public void delete(Venue v){
        em.remove(em.merge(v));
    }
    
    
    @Override
    public List<Venue> findAll() {
        return em.createNamedQuery("Venue.findAll", Venue.class).getResultList();
    }
    
    public void updateVenue(Venue v){
        Venue managedVenueRef = em.getReference(Venue.class, v.getId());
        
        if(! managedVenueRef.getVenueName().equals(v.getVenueName())) managedVenueRef.setVenueName(v.getVenueName());
        if(! managedVenueRef.getCapacity().equals(v.getCapacity())) managedVenueRef.setCapacity(v.getCapacity());
        if(! managedVenueRef.getAddress().equals(v.getAddress())) managedVenueRef.setAddress(v.getAddress());
        
        em.merge(managedVenueRef);
    }
    
    public void deleteVenue(Venue v){
        Venue managedVenueRef = em.getReference(Venue.class, v.getId());
        
        List<League> lgs = em.createNamedQuery("League.findByVenue", League.class)
                .setParameter("ID", v.getId())
                .getResultList();
        
        for(League l : lgs){
            l.removeVenue();
        }
        
        em.remove(managedVenueRef);
    }
    
}
