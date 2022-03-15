/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.Team;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sanjayreddy
 */
@Stateless
public class TeamService extends GenericService<Team>{

    public TeamService() {
        super(Team.class);
    }
    
    
    @Override
    public List<Team> findAll() {
        return em.createNamedQuery("Team.findAll", Team.class).getResultList();
    }
    
}
