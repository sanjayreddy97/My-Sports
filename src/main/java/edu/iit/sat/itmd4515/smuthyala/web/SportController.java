/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.Sport;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import edu.iit.sat.itmd4515.smuthyala.service.SportService;
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
public class SportController {

    private static final Logger LOG = Logger.getLogger(SportController.class.getName());
    
    private Sport sport;
    
    @EJB
    private SportService sptSvc;
    
    public SportController(){
    }
    
    public SportType[] getAllSportTypes(){
        return SportType.values();
    }
    
    @PostConstruct
    private void postContruct(){
        LOG.info("Post construct of SportController...");
        sport = new Sport();
    }
    
    //action method
    public String saveSport(){
        
        LOG.info("saveSport method with " + this.sport.toString());
        
        sptSvc.create(sport);
        
        LOG.info("saveSport method after service invoked " + this.sport.toString());
        
        return "confirmation.xhtml"; 
    }

    public void setSport(Sport sport) {
        this.sport = sport;
    }

    public Sport getSport() {
        return sport;
    }
    
}
