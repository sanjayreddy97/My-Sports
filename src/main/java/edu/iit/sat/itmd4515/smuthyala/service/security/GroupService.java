/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service.security;

import edu.iit.sat.itmd4515.smuthyala.domain.security.Group;
import edu.iit.sat.itmd4515.smuthyala.service.GenericService;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author sanjayreddy
 */
@Stateless
public class GroupService extends GenericService<Group> {

    public GroupService(){
        super(Group.class);
    }
    
    @Override
    public List<Group> findAll() {
        return em.createNamedQuery("Group.findAll", Group.class).getResultList();
    }
    
}
