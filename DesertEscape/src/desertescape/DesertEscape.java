/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package desertescape;

import byui.cit260.desertEscapeGame.exceptions.MapControlException;
import byui.cit260.desertEscapeGame.model.Difficulty;
import byui.cit260.desertEscapeGame.model.Game;
import byui.cit260.desertEscapeGame.model.Player;
import citbyui.cit260.desertEscapeGame.view.ErrorView;
import citbyui.cit260.desertEscapeGame.view.GameMenuView;
import citbyui.cit260.desertEscapeGame.view.MainMenuView;
import citbyui.cit260.desertEscapeGame.view.StartProgramView;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mambou & Paez
 */
public class DesertEscape {

    /**
     * @param args the command line arguments
     */
    private static Game currentGame; // = null;
    private static Player player;  // = null;
    
    private static PrintWriter outFile = null;
    private static BufferedReader inFile = null;
    
    private static PrintWriter logFile = null;
    
    protected final BufferedReader keyboard = DesertEscape.getInFile();
    protected final PrintWriter console = DesertEscape.getOutFile();
    
    public static PrintWriter getOutFile() {
        return outFile;
    }

    public static void setOutFile(PrintWriter outFile) {
        DesertEscape.outFile = outFile;
    }

    public static BufferedReader getInFile() {
        return inFile;
    }

    public static void setInFile(BufferedReader inFile) {
        DesertEscape.inFile = inFile;
    }

    public static PrintWriter getLogFile() {
        return logFile;
    }

    public static void setLogFile(PrintWriter logFile) {
        DesertEscape.logFile = logFile;
    }
    
    

    public static void main(String[] args) {

        
        try {

            // Open character stream files for input and output 
            DesertEscape.inFile = new BufferedReader(new InputStreamReader(System.in));
            DesertEscape.outFile = new PrintWriter(System.out, true);

            // Open log file
            String filePath = "log.txt";
            DesertEscape.logFile = new PrintWriter(filePath);

            //create StartProgramView()rig and display the start program view
            StartProgramView startProgramView = new StartProgramView();
            startProgramView.display();

            //create MainMenuProgramView() rig and display the main menu view
            MainMenuView mainMenuView = new MainMenuView();
            mainMenuView.display();

            return;

        } catch (Throwable e) {

            System.out.println(
                    "Exception: " + e.toString()
                    + "\nCause:" + e.getCause()
                    + "\nMesssage: " + e.getMessage());
            e.printStackTrace();

        } finally {
            try {
                if (DesertEscape.inFile != null) {
                    DesertEscape.inFile.close();
                }

                if (DesertEscape.outFile != null) {
                    DesertEscape.outFile.close();
                }

                if (DesertEscape.logFile != null) {
                    DesertEscape.logFile.close();
                }

            } catch (IOException ex) {
                //Logger.getLogger(DesertEscape.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error closing files");
                return;
            }
        }

        /*try {
            startProgramView.display();
        } catch (Throwable te) {
            this.console.println(te.getMessage());
            te.printStackTrace();
            startProgramView.display();
            );                    
        }*/
 /*try {
                mainMenuView = new MainMenuView();
            } catch (MapControlException ex) {
                Logger.getLogger(DesertEscape.class.getName()).log(Level.SEVERE, null, ex);
            }*/
 /*//Class instance variable Player 
        Player playerOne = new Player();
        playerOne.setPlayerName("Gilles");
        playerOne.setPlayerTime(5);

        Player playerTwo = new Player();
        playerTwo.setPlayerName("Marco");
        playerTwo.setPlayerTime(5);

        // Class Difficulty
        Difficulty diff = new Difficulty();
        diff.setName("BEGINNER");
        diff.setDescription("Starting level");

        //create MainMenuProgramView() rig and display the main menu view
        /*MainMenuView mainMenuView = null;
        try {
            mainMenuView = new MainMenuView();
        } catch (MapControlException ex) {
            Logger.getLogger(DesertEscape.class.getName()).log(Level.SEVERE, null, ex);
        }
        mainMenuView.display();*/
    }

    public static Game getCurrentGame() {
        return currentGame;
    }

    public static void setCurrentGame(Game currentGame) {
        DesertEscape.currentGame = currentGame;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        DesertEscape.player = player;
    }

}
