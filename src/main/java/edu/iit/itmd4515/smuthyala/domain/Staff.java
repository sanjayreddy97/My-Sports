/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

import java.time.LocalDate;
import javax.validation.constraints.*;

/**
 *
 * @author sanjayreddy
 */
public class Staff {
    
    @Email
    private String email;
    
    @NotNull
    private Integer addressId,staffId,storeId;
    
    
    private Boolean active;
    
    @NotBlank
    private String firstName,lastName;
    
    @Pattern(regexp="[a-zA-Z]*")
    //@NotBlank
    private String userName;
    
    @PastOrPresent
    private LocalDate lastUpdate;
    

    public Staff(Integer staffId, Integer storeId, String firstName, String lastName, String userName, String email,Integer addressId,Boolean active, LocalDate lastUpdate) {
        this.email = email;
        this.addressId = addressId;
        this.staffId = staffId;
        this.storeId = storeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.lastUpdate = lastUpdate;
        this.active = active;
    }

    public Staff() {
    }
    
    /**
     * Set the value of lastUpdate
     *
     * @param lastUpdate new value of lastUpdate
     */
    public void setLastUpdate(LocalDate lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    public LocalDate getLastUpdate() {
        return lastUpdate;
    }


    /**
     * Set the value of userName
     *
     * @param userName new value of userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getUserName() {
        return userName;
    }

    /**
     * Get the value of active
     *
     * @return the value of active
     */
    public Boolean getActive() {
        return active;
    }
    
    public Boolean isActive() {
        return active;
    }

    /**
     * Set the value of active
     *
     * @param active new value of active
     */
    public void setActive(Boolean active) {
        this.active = active;
    }

    
    

    /**
     * Set the value of storeId
     *
     * @param storeId new value of storeId
     */
    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }
    public Integer getStoreId() {
        return storeId;
    }


    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }
    public String getEmail() {
        return email;
    }

    

    /**
     * Set the value of addressId
     *
     * @param addressId new value of addressId
     */
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    public Integer getAddressId() {
        return addressId;
    }

    
    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }
    public Integer getStaffId() {
        return staffId;
    }

    /**
     * Set the value of firstName
     *
     * @param firstName new value of firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getFirstName() {
        return firstName;
    }



    /**
     * Set the value of lastName
     *
     * @param lastName new value of lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "Staff{" + "active=" + active + ", addressId=" + addressId + ", email=" + email + ", lastName=" + lastName + ", firstName=" + firstName + ", storeId=" + storeId + ", staffid=" + staffId + '}';
    }
}
