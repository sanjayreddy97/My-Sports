/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.sat.itmd4515.smuthyala.domain.security.User;
import edu.iit.sat.itmd4515.smuthyala.service.security.UserService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 *
 * @author sanjayreddy
 */
@Named
@RequestScoped
public class SignUpController {

    private static final Logger LOG = Logger.getLogger(SignUpController.class.getName());
    
    private User user;
    
    @EJB
    private UserService userSvc;

    /**
     *
     */
    public SignUpController() {
    }

    /**
     *
     */
    @PostConstruct
    public void postConstruct(){
        user = new User();
    }
    
    /**
     *
     * @return
     */
    public String signUpNewUser(){
        userSvc.signUpNewUser(user);
        return "login.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @param user
     */
    public void setUser(User user) {
        this.user = user;
    }

    /**
     *
     * @return
     */
    public User getUser() {
        return user;
    }
  
}
