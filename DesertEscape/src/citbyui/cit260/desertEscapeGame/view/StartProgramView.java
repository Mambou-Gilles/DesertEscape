/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import byui.cit260.desertEscapeGame.control.GameControl;
import byui.cit260.desertEscapeGame.exceptions.GameControlException;
import byui.cit260.desertEscapeGame.model.Player;
import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;
import desertescape.DesertEscape;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mambou
 */
public class StartProgramView extends View {

    private String displayPromptMessage;
    
    protected final BufferedReader keyboard = DesertEscape.getInFile();
        protected final PrintWriter console = DesertEscape.getOutFile();

    public StartProgramView() {

        // this.displayPromptMessage = "\nPlease enter your name";
        super("\n*****************************************************************"
                + "\n*                                                               *"
                + "\n*   ||EEEE\\\\         DDD  EEEE  SSS  EEEE RRR  TTTTT            *"
                + "\n*   ||     \\\\        D  D E    S     E    R  R   T              *"
                + "\n*   ||EEE   ||       D  D EEE   SS   EEE  RRR    T              *"
                + "\n*   ||     //        D  D E       S  E    R  R   T              *"
                + "\n*   ||EEEE//         DDD  EEDE SSS   EEEE R  R   T              *"
                + "\n*                                  ||                           *"
                + "\n*                                   = = = >>>>> E S C A P E     *"
                + "\n*                                                               *"
                + "\n* This is Nicolas Williams Desert Escape Game                   *"
                + "\n* In this game you will take the role of Nicolas Williams       *"
                + "\n* who was born on earth in a distant future                     *"
                + "\n* But there was a global catastroph.                            *"
                + "\n* You are forced to leave earth and travel to another planet    *"
                + "\n*                                                               *"
                + "\n* You will face many threat on this new planet,                 *"
                + "\n* and you must avoid being taken by an enemy alien race         *"
                + "\n* In the game course, you will come to learn of a time machine  *"
                + "\n* that will allow you to rewrite time and reverse               *"
                + "\n* he global catastroph that destroyed earth.                    *"
                + "\n* This will become your and van be achieved by hunting down     *"
                + "\n* artifacts and items and assembling a time machine based off   *"
                + "\n* of a schematic hat was discovered                             *"
                + "\n* Find the resources needed to build the time machine and       *"
                + "\n* save the earth.                                               *"
                + "\n*                                                               *"
                + "\n*            Good luck and enjoy the adventure                  *"
                + "\n*                                                               *"
                + "\n*     Please Enter Your Name Below (eg: Shawn or shawn)         *"
                + "\n*                                                               *"
                + "\n*****************************************************************");
    }

    @Override
    public boolean doAction(String value) {

        if (value.length() < 2) {
             ErrorView.display(this.getClass().getName(),
                     "\nInvalid player name: "
                    + "The name must be greater than one character in length");
            return false;
        }

        //call createPlayer() control function
        Player player = null;
        try {
            player = GameControl.createPlayer(value);
        } catch (GameControlException ex) {
            Logger.getLogger(StartProgramView.class.getName()).log(Level.SEVERE, null, ex);
        }

        /*if (player == null) { // if unsuccesful
            this.console.println("\nError creating the player.");
            return false;
        }*/

        //display next view
        this.displayNextView(player);
        return true;
    }

    private void displayNextView(Player player) {
        this.console.println("\n================================================"
                + "\n Welcome to Desert Escape *** " + player.getPlayerName() + " ***"
                + "\n We hope that you have a lot of fun!"
                + "\n=================================================="
        );
    }
}
