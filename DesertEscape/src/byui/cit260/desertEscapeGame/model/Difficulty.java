/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscapeGame.model;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author mambou & Paez
 */
public class Difficulty implements Serializable{
    
    private String name;
    private String description;

    public Difficulty() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
}
