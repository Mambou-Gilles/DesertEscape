/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import byui.cit260.desertEscapeGame.model.InventoryItem;
import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;
import citbyui.cit260.desertEscapeGame.view.GameMenuView;
import desertescape.DesertEscape;
import java.io.PrintWriter;

/**
 *
 * @author Paez & Mambou
 */
public class InventorySort extends View {

    static void InventoryPrint(InventoryItem[] inventory, String filepath) {
        try (PrintWriter out = new PrintWriter(filepath)){
            
            // print tittle and column heading
            out.println("\n\n                Inventory Report                 ");
            out.printf("%n%-20s%10s%10s", "Description", "Quantity In Stock", "Required Amount");
            out.printf("%n%-20s%10s%10s", "---------------------------------------------------");
            
             //print the description, the required amount and amount in stock
            for (InventoryItem item : inventory) {
           
            out.printf("%n%-20s%7d%13.2f", item.getDescription()
                                                       ,item.getQuantityInStock()
                                                    ,item.getRequiredAmount());
        }
           
        } catch (Exception ex) {
           System.out.println("I/O Error: " + ex.getMessage());
        }
    }

    private String message = "";
    private String displayScene = "";

    public InventorySort() {

        super("\n#####################################"
                + "\n#                                   #"
                + "\n#   INVENTORY ORDER SELECTION       #"
                + "\n#   =========================       #"
                + "\n#                                   #"
                + "\n#   LETTER       SORT BY            #"
                + "\n#     D       Item Description      #"
                + "\n#     S       Item Stock            #"
                + "\n#     R       Item Requirement      #"
                + "\n#     Q       Quit                  #"
                + "\n#                                   #"
                + "\n#####################################");
    }

    @Override
    public boolean doAction(String value) {
        this.console.println("\n Choose your Scene");
        value = value.toUpperCase(); // Convert menuOpton to uppercase

        switch (value) {
            case "D": // Sort by Item description
                this.SortItemDescription();
                break;
            case "S": // Sort by Item Inventory
                this.SortItemInventory();
                break;
            case "R": // Sort by Requirements
                this.SortItemRequirment();
                break;
            case "Q": // return previous menu
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void SortItemDescription() {
        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();
        String tempDesc;
        Integer tempSotck;
        Integer tempReq;
        Boolean breaked = false;

        this.console.println("Items ordered by Description");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        while (!breaked) {
            for (InventoryItem item1 : inventory) {
                for (InventoryItem item2 : inventory) {
                    if (item2.getDescription().compareTo(item1.getDescription()) > 0) {
                        tempDesc = item1.getDescription();
                        tempSotck = item1.getQuantityInStock();
                        tempReq = item1.getRequiredAmount();
                        item1.setDescription(item2.getDescription());
                        item1.setQuantityInStock(item2.getQuantityInStock());
                        item1.setRequiredAmount(item2.getRequiredAmount());
                        item2.setDescription(tempDesc);
                        item2.setQuantityInStock(tempSotck);
                        item2.setRequiredAmount(tempReq);
                        breaked = true;
                        break;
                    } else {
                        breaked = false;
                    }
                }
            }
            if (breaked) {
                breaked = false;
                break;
            } 
            
        }

        InventoryItem[] inventory2 = DesertEscape.getCurrentGame().getInventoryItem();

        for (InventoryItem item : inventory2) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
        // this.console.println("\n*** SortItemDescription() function called ***");
    }

    private void SortItemInventory() {
        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();
        String tempDesc;
        Integer tempSotck;
        Integer tempReq;

        this.console.println("Items ordered by Inventory Stock");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        for (InventoryItem item1 : inventory) {
            for (InventoryItem item2 : inventory) {
                if (item2.getQuantityInStock() < item1.getQuantityInStock()) {
                    tempDesc = item1.getDescription();
                    tempSotck = item1.getQuantityInStock();
                    tempReq = item1.getRequiredAmount();
                    item1.setDescription(item2.getDescription());
                    item1.setQuantityInStock(item2.getQuantityInStock());
                    item1.setRequiredAmount(item2.getRequiredAmount());
                    item2.setDescription(tempDesc);
                    item2.setQuantityInStock(tempSotck);
                    item2.setRequiredAmount(tempReq);
                    break;
                }
            }
        }

        InventoryItem[] inventory2 = DesertEscape.getCurrentGame().getInventoryItem();

        for (InventoryItem item : inventory2) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }
        // this.console.println("\n*** SortItemInventory() function called ***");
    }

    private void SortItemRequirment() {
        InventoryItem[] inventory = DesertEscape.getCurrentGame().getInventoryItem();
        String tempDesc;
        Integer tempSotck;
        Integer tempReq;

        this.console.println("Items ordered by Inventory Stock");
        this.console.println(String.format("%1$10s%2$10s%3$15s", "Description", "In Stock", "Requirement"));

        for (InventoryItem item1 : inventory) {
            for (InventoryItem item2 : inventory) {
                if (item2.getRequiredAmount() < item1.getRequiredAmount()) {
                    tempDesc = item1.getDescription();
                    tempSotck = item1.getQuantityInStock();
                    tempReq = item1.getRequiredAmount();
                    item1.setDescription(item2.getDescription());
                    item1.setQuantityInStock(item2.getQuantityInStock());
                    item1.setRequiredAmount(item2.getRequiredAmount());
                    item2.setDescription(tempDesc);
                    item2.setQuantityInStock(tempSotck);
                    item2.setRequiredAmount(tempReq);
                    break;
                }
            }
        }

        InventoryItem[] inventory2 = DesertEscape.getCurrentGame().getInventoryItem();

        for (InventoryItem item : inventory2) {
            //display the description, the required amount and amount in stock
            this.console.println(String.format("%1$10s%2$10s%3$15s", item.getDescription(),
                    item.getQuantityInStock(),
                    item.getRequiredAmount()));
        }

        //this.console.println("\n*** SortItemRequirment() function called ***");
    }
}
