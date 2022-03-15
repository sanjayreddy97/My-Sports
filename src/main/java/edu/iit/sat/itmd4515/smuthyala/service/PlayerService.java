/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service;

import edu.iit.itmd4515.smuthyala.domain.Player;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sanjayreddy
 */
@Stateless
public class PlayerService extends GenericService<Player>{

    public PlayerService() {
        super(Player.class);
    }
    
    
    @Override
    public List<Player> findAll() {
        return em.createNamedQuery("Player.findAll", Player.class).getResultList();
    }
    
}
