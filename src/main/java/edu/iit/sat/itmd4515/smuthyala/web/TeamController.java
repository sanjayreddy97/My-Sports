/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.Team;
import edu.iit.sat.itmd4515.smuthyala.service.TeamService;
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
public class TeamController {
    
    private static final Logger LOG = Logger.getLogger(TeamController.class.getName());
   
    private boolean showSuccessMessage = false;

    private Team team;

    
    @Inject FacesContext facesContext;
    
    @EJB
    private TeamService teamSvc;
    
    /**
     *
     */
    public TeamController(){
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
    
    @PostConstruct
    private void postContruct(){
        LOG.info("Post construct of TeamController...");
        team = new Team();
    }
    
    /**
     *
     * @param t
     * @return
     */
    public String displayReadTeamPage(Team t){
        this.team = t;
        LOG.info("Inside readActionMethod" + this.team.toString());
        
        return "/user/readTeam.xhtml";
    }
    
    /**
     *
     * @param t
     * @return
     */
    public String displayUpdateTeamPage(Team t){
        this.team = t;
        LOG.info("Inside updateActionMethod" + this.team.toString());
        
        return "/manager/updateTeam.xhtml";
    }
   
    /**
     *
     * @param t
     * @return
     */
    public String displayDeleteTeamPage(Team t){
        this.team = t;
        LOG.info("Inside deleteActionMethod" + this.team.toString());
        
        return "/admin/deleteTeam.xhtml";
    }
    
    //action method

    /**
     *
     * @return
     */
    public String executeCreateButtonClick(){
        
        LOG.info("executeCreateButtonClick method with " + this.team.toString());
        
        teamSvc.create(team);
        
        LOG.info("executeCreateButtonClick method after service invoked " + this.team.toString());
        
        showSuccessMessage = true;
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success!", "New Team " + team.getTeamName() +" has been added"));
        
        return "welcome.xhtml"; 
    }
    
    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.team.toString());
        
        teamSvc.updateTeam(team);
        
        return "/manager/team.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.team.toString());
        
        teamSvc.deleteTeam(team);
        
        return "/admin/team.xhtmlfaces-redirect=true";
    }
    
    /**
     *
     * @param team
     */
    public void setTeam(Team team) {
        this.team = team;
    }

    /**
     *
     * @return
     */
    public Team getTeam() {
        return team;
    }
    
}
