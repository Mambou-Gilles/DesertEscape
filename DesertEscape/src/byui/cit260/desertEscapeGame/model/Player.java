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
public class Player implements Serializable {
    
    private String playerName;
    private Integer playerTime;
    private Location location;
    
    
    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Integer getPlayerTime() {
        return playerTime;
    }

    public void setPlayerTime(Integer playerTime) {
        this.playerTime = playerTime;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Player() {
    }    

    public void setLocation(int i, int i0, boolean b, double d) {
        return;
    }
}
