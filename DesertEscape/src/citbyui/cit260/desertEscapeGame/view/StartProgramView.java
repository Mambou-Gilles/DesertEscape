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
        Player plyrName = null;
        try {
            plyrName = GameControl.createPlayer(value);
        } catch (GameControlException ex) {
            Logger.getLogger(StartProgramView.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (plyrName == null) { // if unsuccesful
            this.console.println("\nError creating the player.");
            return false;
        }

        //display next view
        this.displayNextView(plyrName);
        return true;
    }

    private void displayNextView(Player plyrName) {
        this.console.println("\n================================================"
                + "\n Welcome to Desert Escape *** " + plyrName.getPlayerName() + " ***"
                + "\n We hope that you have a lot of fun!"
                + "\n=================================================="
        );
    }
}
