/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import byui.cit260.desertEscapeGame.exceptions.GameControlException;
import byui.cit260.desertEscapeGame.model.InventoryItem;
import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;
import citbyui.cit260.desertEscapeGame.view.GameMenuView;
import desertescape.DesertEscape;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

/**
 *
 * @author Paez
 */
public class InventoryMenu extends View {

    private String message = "";
    private String displayScene = "";

    public InventoryMenu() {

        super("\n#####################################"
                + "\n#                                   #"
                + "\n#       I N V E N T O R Y           #"
                + "\n#   =========================       #"
                + "\n#     V     View the Inventory      #"
                + "\n#     D     Sorted by Description   #"
                + "\n#     S     Sorted by Stock         #"
                + "\n#     I     Sorted by Requirement   #"
                + "\n#   -------------------------       #"
                + "\n#     L     Inventory List Save     #"
                + "\n#     F     Inventory File Report   #"
                + "\n#   -------------------------       #"
                + "\n#     R     Return back             #"
                + "\n#                                   #"
                + "\n#####################################"
                + "\n"
                + "\n        Enter your selection");
    }

    @Override
    public boolean doAction(String value) {
        this.console.println("\n Choose your Scene");
        value = value.toUpperCase(); // Convert menuOpton to uppercase

        switch (value) {
            case "V": // Sort by Item description
                this.ViewInventory();
                break;
            case "D": // Sort by Item description
                this.SortItemDescription();
                break;
            case "S": // Sort by Item Inventory
                this.SortItemInventory();
                break;
            case "I": // Sort by Item Requirements
                this.SortItemRequirement();
                break;
            case "L": // Inventory List 
                this.InventoryList();
                break;
            case "F": // Inventory File Report
                this.ReportList();
                break;
            case "R": // return previous menu
                return true;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void ViewInventory() {
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

    private void SortItemDescription() {
        this.console.println("   Items ordered by Description");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        InventoryItem[] inventory2 = DesertEscape.getCurrentGame().getInventoryItem();

        //Java do the sorting for you
        Arrays.sort(inventory2, new Comparator<InventoryItem>() {
            @Override
            public int compare(InventoryItem o1, InventoryItem o2) {
                return o1.getDescription().compareTo(o2.getDescription());
            }
        });

        for (InventoryItem item : inventory2) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
        // this.console.println("\n*** SortItemDescription() function called ***");
    }

    private void SortItemInventory() {

        this.console.println("   Items ordered by Inventory Stock");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        InventoryItem[] inventory2 = DesertEscape.getCurrentGame().getInventoryItem();

        //Java do the sorting for you
        Arrays.sort(inventory2, new Comparator<InventoryItem>() {
            @Override
            public int compare(InventoryItem o1, InventoryItem o2) {
                return o1.getQuantityInStock() - o2.getQuantityInStock();
            }
        });

        for (InventoryItem item : inventory2) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
    }

    private void SortItemRequirement() {

        this.console.println("   Items ordered by Inventory Stock");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        InventoryItem[] inventory2 = DesertEscape.getCurrentGame().getInventoryItem();

        //Java do the sorting for you
        Arrays.sort(inventory2, new Comparator<InventoryItem>() {
            @Override
            public int compare(InventoryItem o1, InventoryItem o2) {
                return o1.getRequiredAmount() - o2.getRequiredAmount();
            }
        });

        for (InventoryItem item : inventory2) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }

    }

    private void InventoryList() {
        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();

        //InventoryList inventoryList = new InventoryList();
        //inventoryList.display();
        this.console.println("\tList of Inventory Items");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        for (InventoryItem item : inventory) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
    }

    private void ReportList() {
        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();

        //InventoryList inventoryMenu = new InventoryList();
        //inventoryMenu.display();
        this.console.println("\tList of Inventory Items");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        for (InventoryItem item : inventory) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
    }

    static void InventoryPrint(InventoryItem[] inventory, String filepath) throws GameControlException {

        try (PrintWriter out = new PrintWriter(filepath)) {

            // print title and column heading
            out.println("\n\n                Inventory Report                 ");
            out.printf("%n%-20s%10s%10s", "Description", "Quantity In Stock", "Required Amount");
            out.printf("%n%-20s%10s%10s", "---------------------------------------------------");

//print the description, the required amount and amount in stock
            for (InventoryItem item : inventory) {

                out.printf("%1$10s%2$10s%3$15s", item.getDescription(), item.getQuantityInStock(), item.getRequiredAmount());
            }

        } catch (Exception ex) {
            //System.out.println("GameMenuView" + ex.getMessage());
            //throw new GameControlException(ex.getMessage());
        }

    }
}
