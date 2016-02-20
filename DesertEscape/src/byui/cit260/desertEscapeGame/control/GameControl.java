/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscapeGame.control;

import byui.cit260.desertEscapeGame.model.Player;
import desertescape.DesertEscape;

/**
 *
 * @author mambou
 */
public class GameControl {

    public static Player createPlayer(String name) {
        
        if (name == null){
            return null;
        }
        
        Player player = new Player();
        player.setPlayerName(name);
        
        DesertEscape.setPlayer(player); // save the player
        
        return player;
    }

    public static void createNewGame(Player player) {
        System.out.println("*** createNewGame stub function called ");  
    }
    
}    
