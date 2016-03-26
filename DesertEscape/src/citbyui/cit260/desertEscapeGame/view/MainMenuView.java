/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import byui.cit260.desertEscapeGame.control.GameControl;
import byui.cit260.desertEscapeGame.exceptions.MapControlException;
import byui.cit260.desertEscapeGame.model.Player;
import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;
import desertescape.DesertEscape;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Paez & Mambou
 */
public class MainMenuView extends View {

    private String displayMessage = "";
    private String displayMenu = "";
    
    protected final BufferedReader keyboard = DesertEscape.getInFile();
    protected final PrintWriter console = DesertEscape.getOutFile();

    public MainMenuView() throws MapControlException{

        // displayPromptMessage = "Please enter any menu option ";       
        //this.displayMessage = "\nPlease enter menu option";
        super("\n"
                + "\n----------------------------"
                + "\n         MAIN MENU"
                + "\n----------------------------"
                + "\n  N - Start New Game"
                + "\n  R - Resume Saved Game"
                + "\n  H - How to play the game"
                + "\n  S - Save Game"
                + "\n  G - Go to Scenes"
                + "\n  Q - Quit"
                + "\n"
                + "\n  Please Ente Your Menu Selection Below"
                + "\n  "
                + "\n----------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Convert menuOpton to uppercase

        switch (value) {
            case "N": {
                try {
                    // Create and Start New Game
                    this.startNewGame();
                } catch (MapControlException ex) {
                    this.console.println(ex.getMessage());
                    GameMenuView gameMenu = new GameMenuView();
                    gameMenu.display();

                    //this.console.println();
                    //Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            break;
            case "R": // resume the game
                this.resumeSavedGame();
                break;
            case "H": // dislay help menu
                this.displayHelpMenu();
                break;
            case "S": // save the game
                this.saveGame();
                break;
            case "G": // Go to Scenes
                this.goToScene();
                break;
            case "Q": // quit the game
                break;
            default:
                ErrorView.display(this.getClass().getName(),
                    "\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void startNewGame() throws MapControlException {

        try {
            // fuel use control
            FuelUseVolume fuelUse = new FuelUseVolume();
            fuelUse.fuelUse();
            
            //create BodyMassView() and display the calculation
            BodyMassView bodyMassView = new BodyMassView();
            bodyMassView.displayBodyMassView();
            
            
            //create new Game
            GameControl.createNewGame(DesertEscape.getPlayer());
            
            //display the game menu
            GameMenuView gameMenu = new GameMenuView();
            gameMenu.display();
            
            //GameMenuView game = new GameMenuView();
            //game.MoveNorth();
            // Run Mission select
            // Mission(AlienCamp);
        } catch (byui.cit.desertEscapeGame.exceptions.MapControlException ex) {
            Logger.getLogger(MainMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void resumeSavedGame() {
        this.console.println("\n\n Enter the file path for file wher the game"
                +" is to saved");
        //String filePath = this.getInput();
        
        try {
             String filePath = keyboard.readLine();
            //save the game to the specified file
            GameControl.getSavedGame(filePath);
            GameMenuView gmv = new GameMenuView();
            gmv.display();
        } catch (Exception ex){
            ErrorView.display(this.getClass().getName(), "Error on Input");
        }
    }

    private void displayHelpMenu() {
        GettingHelpView gettingHelpView = new GettingHelpView();
        gettingHelpView.display();
    }

    private void saveGame() {
        
        //Prompt for and and get the name of the file to save the game
        this.console.println("\n\n Enter the file path for the file where "
                + "the game is to be saved ");
        // filePath = this.getInput();
        
        try {
             String filePath = keyboard.readLine();
            //save the game to the specified file
            GameControl.saveGame(filePath);
        } catch (Exception ex){
            ErrorView.display(this.getClass().getName(), "Error on Input");
            //ErrorView.display("MainMenuView", ex.getMessage());
        }
    }

    private void goToScene() {
        SceneView sceneView = new SceneView();
        sceneView.display();
    }

    public static Player createPlayer(String name) {

        if (name == null) {
            return null;
        }

        Player player = new Player();
        player.setPlayerName(name);

        DesertEscape.setPlayer(player); // save the player

        return player;
    }

}
