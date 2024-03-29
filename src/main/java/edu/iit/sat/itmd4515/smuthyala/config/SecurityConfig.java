/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.sat.itmd4515.smuthyala.config;

import javax.annotation.security.DeclareRoles;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.security.enterprise.authentication.mechanism.http.CustomFormAuthenticationMechanismDefinition;
import javax.security.enterprise.authentication.mechanism.http.LoginToContinue;
import javax.security.enterprise.identitystore.DatabaseIdentityStoreDefinition;

/**
 *
 * @author sanjayreddy
 */
@Named
@ApplicationScoped
@DeclareRoles({SecurityConfig.ADMIN_ROLE, SecurityConfig.CUSTOMER_ROLE, SecurityConfig.MANAGER_ROLE})
@DatabaseIdentityStoreDefinition(
        dataSourceLookup = "java:app/jdbc/itmd4515DS",
        callerQuery = "select PASSWORD from sec_user where USERNAME = ?",
        groupsQuery= "select GROUPNAME from sec_user_groups where USERNAME = ?"
)
@CustomFormAuthenticationMechanismDefinition(
        loginToContinue = @LoginToContinue(loginPage = "/login.xhtml", errorPage = "/error.xhtml")
)
public class SecurityConfig {

    /**
     *
     */
    public static final String ADMIN_ROLE = "ADMIN_ROLE";

    /**
     *
     */
    public static final String CUSTOMER_ROLE = "CUSTOMER_ROLE";

    /**
     *
     */
    public static final String MANAGER_ROLE = "MANAGER_ROLE";
}
