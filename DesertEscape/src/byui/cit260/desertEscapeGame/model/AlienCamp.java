/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscapeGame.model;

import java.io.Serializable;
import java.util.Objects;
import java.util.logging.Logger;

/**
 *
 * @author mambou & Paez
 */
public class AlienCamp implements Serializable{
    
    private String description;
    private double amountAvailable;
    private String resources;

    public AlienCamp() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmountAvailable() {
        return amountAvailable;
    }

    public void setAmountAvailable(double amountAvailable) {
        this.amountAvailable = amountAvailable;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }
       
}
