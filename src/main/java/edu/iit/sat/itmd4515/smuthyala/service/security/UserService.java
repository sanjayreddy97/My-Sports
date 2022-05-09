/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.service.security;

import edu.iit.sat.itmd4515.smuthyala.domain.security.Group;
import edu.iit.sat.itmd4515.smuthyala.domain.security.User;
import edu.iit.sat.itmd4515.smuthyala.service.GenericService;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.Query;

/**
 *
 * @author sanjayreddy
 */
@Stateless
public class UserService extends GenericService<User>{
    
    /**
     *
     */
    public UserService(){
        super(User.class);
    }

    /**
     *
     * @return
     */
    @Override
    public List<User> findAll() {
       return em.createNamedQuery("User.findAll", User.class).getResultList();
    }
    
    /**
     *
     * @param u
     */
    public void signUpNewUser(User u){
        Group usrGroup = em.createQuery("select g from Group g Where g.groupName = 'CUSTOMER_GROUP'", Group.class).getSingleResult();
        u.addGroup(usrGroup);
        u.setEnabled(true);
        em.persist(u);
        
    }
    
}

