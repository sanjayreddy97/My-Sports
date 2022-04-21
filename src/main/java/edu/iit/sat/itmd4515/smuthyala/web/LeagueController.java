/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import edu.iit.sat.itmd4515.smuthyala.service.LeagueService;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author sanjayreddy
 */
@Named
@RequestScoped
public class LeagueController {
    private static final Logger LOG = Logger.getLogger(SportController.class.getName());
   
    private boolean showSuccessMessage = false;

    private League league;

    
    @Inject FacesContext facesContext;
    
    @EJB
    private LeagueService leagueSvc;
    
    public LeagueController(){
    }
    public boolean isShowSuccessMessage() {
        return showSuccessMessage;
    }
    public void setShowSuccessMessage(boolean showSuccessMessage) {
        this.showSuccessMessage = showSuccessMessage;
    }
    
    public SportType[] getAllSportTypes(){
        return SportType.values();
    } 
    
    @PostConstruct
    private void postContruct(){
        LOG.info("Post construct of LeagueController...");
        league = new League();
    }
    
    public String displayReadLeaguePage(League l){
        this.league = l;
        LOG.info("Inside readActionMethod" + this.league.toString());
        
        return "/admin/readLeague.xhtml";
    }
    
    public String displayUpdateLeaguePage(League l){
        this.league = l;
        LOG.info("Inside updateActionMethod" + this.league.toString());
        
        return "/admin/updateLeague.xhtml";
    }
    
    public String displayDeleteLeaguePage(League l){
        this.league = l;
        LOG.info("Inside deleteActionMethod" + this.league.toString());
        
        return "/admin/deleteLeague.xhtml";
    }
    
    //action method
    public String executeCreateButtonClick(){
        
        LOG.info("executeCreateButtonClick method with " + this.league.toString());
        
        leagueSvc.create(league);
        
        LOG.info("executeCreateButtonClick method after service invoked " + this.league.toString());
        
        showSuccessMessage = true;
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success!", "New league " + league.getLeagueName() +" has been added"));
        
        return "welcome.xhtml"; 
    }
    
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.league.toString());
        
        leagueSvc.updateLeague(league);
        
        return "/admin/welcome.xhtml?faces-redirect=true";
    }
    
    public String executeDeleteButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.league.toString());
        
        leagueSvc.deleteLeague(league);
        
        return "/admin/welcome.xhtml?faces-redirect=true";
    }
    
    public void setLeague(League league) {
        this.league = league;
    }

    public League getLeague() {
        return league;
    }
}
