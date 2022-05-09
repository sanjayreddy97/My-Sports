/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.Player;
import edu.iit.sat.itmd4515.smuthyala.service.PlayerService;
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
public class PlayerController {
    
    private static final Logger LOG = Logger.getLogger(PlayerController.class.getName());
   
    private boolean showSuccessMessage = false;

    private Player player;

    
    @Inject FacesContext facesContext;
    
    @EJB
    private PlayerService playerSvc;
    
    /**
     *
     */
    public PlayerController(){
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
        LOG.info("Post construct of VenueController...");
        player = new Player();
    }
    
    /**
     *
     * @param p
     * @return
     */
    public String displayReadPlayerPage(Player p){
        this.player = p;
        LOG.info("Inside readActionMethod" + this.player.toString());
        
        return "/user/readPlayer.xhtml";
    }
    
    /**
     *
     * @param p
     * @return
     */
    public String displayUpdatePlayerPage(Player p){
        this.player = p;
        LOG.info("Inside updateActionMethod" + this.player.toString());
        
        return "/manager/updatePlayer.xhtml";
    }
    
    /**
     *
     * @param p
     * @return
     */
    public String displayDeletePlayerPage(Player p){
        this.player = p;
        LOG.info("Inside deleteActionMethod" + this.player.toString());
        
        return "/admin/deletePlayer.xhtml";
    }
    
    //action method

    /**
     *
     * @return
     */
    public String executeCreateButtonClick(){
        
        LOG.info("executeCreateButtonClick method with " + this.player.toString());
        
        playerSvc.create(player);
        
        LOG.info("executeCreateButtonClick method after service invoked " + this.player.toString());
        
        showSuccessMessage = true;
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success!", "New Player " + player.getPlayerName() +" has been added"));
        
        return "welcome.xhtml"; 
    }
    
    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.player.toString());
        
        playerSvc.updatePlayer(player);
        
        return "/manager/player.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.player.toString());
        
        playerSvc.deletePlayer(player);
        
        return "/admin/player.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @param player
     */
    public void setVenue(Player player) {
        this.player = player;
    }

    /**
     *
     * @return
     */
    public Player getPlayer() {
        return player;
    }
    
}
