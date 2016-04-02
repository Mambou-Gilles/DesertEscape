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
import java.util.logging.Level;
import java.util.logging.Logger;

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
                + "\n  L - View content of locations"
                + "\n  N - Move person to North"
                + "\n  E - Move person to East"
                + "\n  S - Move person to South"
                + "\n  W - Move person to West"
                + "\n----------------------------"
                + "\n  I - Inventory menu"
                + "\n  P - Print inventory list"
                + "\n----------------------------"
                + "\n  R - Return to Main Menu"
                + "\n"
                + "\n    Enter Your Selection");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Convert menuOpton to uppercase

        switch (value) {
            case "M": // travel to new location
                this.Map();
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
            case "I": // view inventory Menu
                this.InventoryMenu();
                break;
            case "P": // View inventory list with costs
                this.PrintReport();
                break;
            case "R": // quit the game
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
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

    private void ContentLocation() {
        Location lc = DesertEscape.getCurrentGame().getPlayer().getLocation();
        this.console.println("You are at: (" + lc.getRow() + "," + lc.getColumn() + ")");
    }

    public void MoveNorth() {
        MovementController mc = new MovementController();
        try {
            mc.moveNorth(DesertEscape.getCurrentGame());
        } catch (MovementControllerException ex) {
            this.console.println(ex.getMessage());
            //Logger.getLogger(GameMenuView.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ContentLocation();

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
        
        ContentLocation();

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
        
        ContentLocation();
        
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
        
        ContentLocation();
        
        /*if (mc.moveWest(DesertEscape.getCurrentGame()) == false) {
            this.console.println("You cannot move there");
        }*/
    }

    private void InventoryMenu() {
        InventoryMenu inventoryMenu = new InventoryMenu();
        inventoryMenu.display();

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
