/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.web;

import edu.iit.sat.itmd4515.smuthyala.config.SecurityConfig;
import edu.iit.sat.itmd4515.smuthyala.domain.security.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.security.enterprise.AuthenticationStatus;
import javax.security.enterprise.SecurityContext;
import javax.security.enterprise.authentication.mechanism.http.AuthenticationParameters;
import javax.security.enterprise.credential.Credential;
import javax.security.enterprise.credential.Password;
import javax.security.enterprise.credential.UsernamePasswordCredential;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author sanjayreddy
 */
@Named
@RequestScoped
public class LoginController {

    private static final Logger LOG = Logger.getLogger(LoginController.class.getName());
    
    private User user;
    
    @Inject FacesContext facesContext;
    @Inject SecurityContext securityContext;
        
    /**
     *
     */
    public LoginController() {
    }
    
    @PostConstruct
    private void postConstruct(){
        user = new User();
    }
    
    /**
     *
     * @return
     */
    public String getAuthenticatedUser(){
        return facesContext.getExternalContext().getRemoteUser();
    }
    
    /**
     *
     * @return
     */
    public boolean isAdmin(){
        return securityContext.isCallerInRole(SecurityConfig.ADMIN_ROLE);
    }
    
    /**
     *
     * @return
     */
    public boolean isManager(){
        return securityContext.isCallerInRole(SecurityConfig.MANAGER_ROLE);
    }
    
    /**
     *
     * @return
     */
    public boolean isCustomer(){
        return securityContext.isCallerInRole(SecurityConfig.CUSTOMER_ROLE);
    }
    
    /**
     *
     * @return
     */
    public String doLogin(){
        LOG.info("Inside doLogin");
        
        Credential cred = new UsernamePasswordCredential(
                this.user.getUserName(),
                new Password(this.user.getPassword())
        );
        
        AuthenticationStatus status = securityContext.authenticate(
                (HttpServletRequest) facesContext.getExternalContext().getRequest(), 
                (HttpServletResponse) facesContext.getExternalContext().getResponse(), 
                AuthenticationParameters.withParams().credential(cred)
        );
        
        LOG.info("AuthenticationStatus is " + status.toString());
        
        switch(status){
            case SEND_CONTINUE:
                LOG.info(status.toString());
                break;
            case SEND_FAILURE:
                LOG.info(status.toString());
                return "/error.xhtml";
            case SUCCESS:
                LOG.info(status.toString());
                break;
            case NOT_DONE:
                LOG.info(status.toString());
                return "/login.xhtml";
        }
        
        return "/welcome.xhtml?faces-redirect=true";
    }
    
    /**
     *
     * @return
     */
    public String doLogout(){
        
        try {
            HttpServletRequest request =
                    (HttpServletRequest) facesContext.getExternalContext().getRequest();
            
            request.logout();
            
            
        } catch (ServletException ex) {
            LOG.log(Level.SEVERE, null, ex);
        }
        return "/login.xhtml?faces-redirect=true";
    }

    /**
     * Get the value of user
     *
     * @return the value of user
     */
    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }
    
}
