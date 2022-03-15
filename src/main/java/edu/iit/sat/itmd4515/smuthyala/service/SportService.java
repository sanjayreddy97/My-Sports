/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.Sport;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sanjayreddy
 */
@Stateless
public class SportService extends GenericService<Sport>{

    public SportService() {
        super(Sport.class);
    }
    
    
    @Override
    public List<Sport> findAll() {
        return em.createNamedQuery("Sport.findAll", Sport.class).getResultList();
    }
    
}
