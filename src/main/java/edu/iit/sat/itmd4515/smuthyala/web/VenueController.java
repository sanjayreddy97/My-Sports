/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.itmd4515.smuthyala.domain.Venue;
import edu.iit.sat.itmd4515.smuthyala.service.VenueService;
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
public class VenueController {
    
    private static final Logger LOG = Logger.getLogger(VenueController.class.getName());
   
    private boolean showSuccessMessage = false;

    private Venue venue;

    
    @Inject FacesContext facesContext;
    
    @EJB
    private VenueService venueSvc;
    
    /**
     *
     */
    public VenueController(){
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
        venue = new Venue();
    }
    
    /**
     *
     * @param v
     * @return
     */
    public String displayReadVenuePage(Venue v){
        this.venue = v;
        LOG.info("Inside readActionMethod" + this.venue.toString());
        
        return "/user/readVenue.xhtml";
    }
    
    /**
     *
     * @param v
     * @return
     */
    public String displayUpdateVenuePage(Venue v){
        this.venue = v;
        LOG.info("Inside updateActionMethod" + this.venue.toString());
        
        return "/manager/updateVenue.xhtml";
    }
    
    /**
     *
     * @param v
     * @return
     */
    public String displayDeleteVenuePage(Venue v){
        this.venue = v;
        LOG.info("Inside deleteActionMethod" + this.venue.toString());
        
        return "/admin/deleteVenue.xhtml";
    }
    
    //action method

    /**
     *
     * @return
     */
    public String executeCreateButtonClick(){
        
        LOG.info("executeCreateButtonClick method with " + this.venue.toString());
        
        venueSvc.create(venue);
        
        LOG.info("executeCreateButtonClick method after service invoked " + this.venue.toString());
        
        showSuccessMessage = true;
        
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Success!", "New Venue " + venue.getVenueName() +" has been added"));
        
        return "welcome.xhtml"; 
    }
    
    /**
     *
     * @return
     */
    public String executeUpdateButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.venue.toString());
        
        venueSvc.updateVenue(venue);
        
        return "/manager/venue.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String executeDeleteButtonClick() {
        LOG.info("executeUpdateButtonClick method with " + this.venue.toString());
        
        venueSvc.deleteVenue(venue);
        
        return "/admin/venue.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @param venue
     */
    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    /**
     *
     * @return
     */
    public Venue getVenue() {
        return venue;
    }
    
}
