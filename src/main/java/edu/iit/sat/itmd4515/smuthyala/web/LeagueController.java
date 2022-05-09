/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.League;
import edu.iit.itmd4515.smuthyala.domain.SportType;
import edu.iit.itmd4515.smuthyala.domain.Team;
import edu.iit.sat.itmd4515.smuthyala.service.LeagueService;
import edu.iit.sat.itmd4515.smuthyala.service.TeamService;
import java.util.ArrayList;
import java.util.List;
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
    private static final Logger LOG = Logger.getLogger(LeagueController.class.getName());
   
    private boolean showSuccessMessage = false;

    private League league;

    @Inject FacesContext facesContext;
    
    @EJB
    private LeagueService leagueSvc;
    
    @EJB
    private TeamService teamSvc;
    
    /**
     *
     */
    public LeagueController(){
    }

    /**
     *
     * @return
     */
    public boolean isShowSuccessMessage() {
        return showSuccessMessage;
    }

    /**
     *
     * @param showSuccessMessage
     */
    public void setShowSuccessMessage(boolean showSuccessMessage) {
        this.showSuccessMessage = showSuccessMessage;
    }
    
    /**
     *
     * @return
     */
    public SportType[] getAllSportTypes(){
        return SportType.values();
    } 
    
    @PostConstruct
    private void postContruct(){
        league = new League();
        LOG.info("Post construct of LeagueController..." + this.league.toString());
        
    }
    
    /**
     *
     * @param l
     * @return
     */
    public String displayReadLeaguePage(League l){
        this.league = l;
        LOG.info("Inside readActionMethod" + this.league.toString());
        
        return "/user/readLeague.xhtml";
    }
    
    /**
     *
     * @param l
     * @return
     */
    public String displayUpdateLeaguePage(League l){
        this.league = l;
        LOG.info("Inside updateActionMethod" + this.league.toString());
        
        return "/manager/updateLeague.xhtml";
    }
    
    /**
     *
     * @param l
     * @return
     */
    public String displayDeleteLeaguePage(League l){
        this.league = l;
        LOG.info("Inside deleteActionMethod" + this.league.toString());
        
        return "/admin/deleteLeague.xhtml";
    }
    
    //action method

    /**
     *
     * @return
     */
    public String executeCreateButtonClick(){
        
        LOG.info("executeCreateButtonClick method with " + this.league.toString());
        
        leagueSvc.create(league);
        
        LOG.info("executeCreateButtonClick method after service invoked " + this.league.toString());
        
        showSuccessMessage = true;
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success!", "New league " + league.getLeagueName() +" has been added"));
        
        return "/welcome.xhtml"; 
    }
    
    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.league.toString());
        
        leagueSvc.updateLeague(league);
        
        return "/manager/league.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.league.toString());
        
        leagueSvc.deleteLeague(league);
        
        return "/admin/league.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @param league
     */
    public void setLeague(League league) {
        this.league = league;
    }

    /**
     *
     * @return
     */
    public League getLeague() {
        return league;
    }
}
