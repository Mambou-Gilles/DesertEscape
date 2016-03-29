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
 * @author Mambou & Paez 
 * 
 * 
 */
public class InventoryItem implements Serializable {
     
    private String description;
    private String inventory;
    private Integer quantityInStock;
    private Integer requiredAmount;
    
    public InventoryItem() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInventoryItem() {
        return inventory;
    }

    public void setInventoryItem(String inventoryItem) {
        this.inventory = inventoryItem;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public Integer getRequiredAmount() {
        return requiredAmount;
    }

    public void setRequiredAmount(Integer requiredAmount) {
        this.requiredAmount = requiredAmount;
    }
}
