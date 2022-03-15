/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.Venue;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sanjayreddy
 */
@Stateless
public class VenueService extends GenericService<Venue>{

    public VenueService() {
        super(Venue.class);
    }
    
    
    @Override
    public List<Venue> findAll() {
        return em.createNamedQuery("Player.findAll", Venue.class).getResultList();
    }
    
}
