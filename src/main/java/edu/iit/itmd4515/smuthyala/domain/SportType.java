/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package edu.iit.itmd4515.smuthyala.domain;

/**
 *
 * @author sanjayreddy
 */
public enum SportType {
    BASEBALL("Baseball"),
    SOCCER("Soccer"),
    HANDBALL("Handball"),
    BASKETBALL("Basketball"),
    CRICKET("Cricket"),
    RUGBY("Rugby");
    
    private String label;

    private SportType(String label){
        this.label = label;
    }

    public String getLabel() {
        return label;
    }
    
}
