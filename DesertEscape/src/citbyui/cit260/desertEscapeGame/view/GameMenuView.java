/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import byui.cit260.desertEscapeGame.exceptions.MovementControllerException;
import byui.cit260.desertEscapeGame.control.MovementController;
import byui.cit260.desertEscapeGame.model.Game;
import byui.cit260.desertEscapeGame.model.InventoryItem;
//import byui.cit260.desertEscapeGame.model.InventoryItem;
import byui.cit260.desertEscapeGame.model.Location;
import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;
import desertescape.DesertEscape;
import java.io.BufferedReader;
//import java.io.FileNotFoundException;
import java.io.PrintWriter;
//import java.util.logging.Level;
//import java.util.logging.Logger;



/**
 *
 * @author mambou
 */
public class GameMenuView extends View {
    protected final BufferedReader keyboard = DesertEscape.getInFile();
        protected final PrintWriter console = DesertEscape.getOutFile();

    public GameMenuView() {

        super("\n"
                + "\n----------------------------"
                + "\n     G A M E   M E N U "
                + "\n----------------------------"
                + "\n  M - View Map"
                + "\n  A - View list of actors"
                + "\n  T - View time machine status"
                + "\n  L - View content of locations"
                + "\n  N - Move person to North"
                + "\n  E - Move person to East"
                + "\n  S - Move person to South"
                + "\n  W - Move person to West"
                + "\n  I - View inventory list with costs"
                + "\n  P - Print inventory list"
                + "\n  Z - Sort inventory list"
                + "\n  I - Inventory activities"
                + "\n  R - Estimate the resource needed"
                + "\n  H - Help"
                + "\n  Q - Quit"
                + "\n"
                + "\n  Please Enter Your Selection Below"
                + "\n  "
                + "\n----------------------------");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Convert menuOpton to uppercase

        switch (value) {
            case "V": // view inventory Menu
                this.InventoryMenu();
                break;
            case "M": // travel to new location
                this.Map();
                break;
            case "A": // View list of actors
                this.Actors();
                break;
            case "T": // View time machine status
                this.displayTimeMachineStatus();
                break;
            case "L": // View content of locations
                this.ContentLocation();
                break;
            case "N":
                this.MoveNorth();
                break;
            case "E": // Move person to New location
                this.MoveEast();
                break;
            case "S": // Move person to New location
                this.MoveSouth();
                break;
            case "W": // Move person to New location
                this.MoveWest();
                break;

            case "I": // View inventory list with costs
                this.ViewInventory();
                break;
            case "P": // View inventory list with costs
                this.PrintReport();
                break;
            case "Z": // Sorted inventory list
                this.SortInventory();
                break;
            case "R": // Estimate the resource needed
                this.displayEstimatedResource();
                break;
            case "H": // View help
                this.displayHelp();
                break;
            case "Q": // quit the game
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void InventoryMenu() {

        InventoryMenu inventoryMenu = new InventoryMenu();
        inventoryMenu.display();

    }

    private void Map() {
        this.console.println(DesertEscape.getCurrentGame().getMap().getMapString());


    }

    void ViewInventory() {

        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();

        this.console.println("\tList of Inventory Items");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        for (InventoryItem item : inventory) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
    }

    private void SortInventory() {

        InventorySort inventorySortItem = new InventorySort();
        inventorySortItem.display();


    }

    private void Actors() {
        this.console.println("\n *** viewActors stub function called ***");
    }

    private void ContentLocation() {
        Location lc = DesertEscape.getCurrentGame().getPlayer().getLocation();
        this.console.println("You are at: (" + lc.getRow() + "," + lc.getColumn() + ")");
    }

    private void displayEstimatedResource() {
        this.console.println("\n *** viewEstimatedResourceNeeded stub function called ***");
    }

    private void displayHelp() {
        this.console.println("\n *** viewhelp stub function called ***");
    }

    private void displayTimeMachineStatus() {
        this.console.println("\n *** viewTimeMachineStatus stub function called ***");
    }

    public void MoveNorth() {
        MovementController mc = new MovementController();
        try {
            mc.moveNorth(DesertEscape.getCurrentGame());
        } catch (MovementControllerException ex) {
            this.console.println(ex.getMessage());
            //Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }

        // if (mc.moveNorth(DesertEscape.getCurrentGame()) == false) {
        // this.console.println("You cannot move there");
    }

    private void MoveEast() {
        MovementController mc = new MovementController();
        try {
            mc.moveEast(DesertEscape.getCurrentGame());
        } catch (MovementControllerException ex) {
            this.console.println(ex.getMessage());
            //Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }

        //mc.moveEast(DesertEscape.getCurrentGame();
//        if (mc.moveEast(DesertEscape.getCurrentGame()) == false) {
//            this.console.println("You cannot move there");
//        }
    }

    private void MoveSouth() {
        MovementController mc = new MovementController();
        try {
            mc.moveSouth(DesertEscape.getCurrentGame());
        } catch (MovementControllerException ex) {
            this.console.println(ex.getMessage());
            //Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        //if (mc.moveSouth(DesertEscape.getCurrentGame()) == false) {
        //    this.console.println("You cannot move there");
        //}
    }

    private void MoveWest() {
        MovementController mc = new MovementController();
        try {
            mc.moveWest(DesertEscape.getCurrentGame());
        } catch (MovementControllerException ex) {
            this.console.println(ex.getMessage());
            //Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        /*if (mc.moveWest(DesertEscape.getCurrentGame()) == false) {
            this.console.println("You cannot move there");
        }*/
    }

    private void PrintReport() {
        this.console.println("\n Enter the file path  of where the report is to be printed.");
        
        String filepath = this.getInput();
       
        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();
        try {
        InventorySort.InventoryPrint(inventory, filepath);
    } catch (Exception e) {
        ErrorView.display("GameMenuView", e.getMessage());
    }
    }

}
