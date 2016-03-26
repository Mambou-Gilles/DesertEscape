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
 * Changes to lesson 9 individual: Paez
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

    @Override
    public String toString() {
        return "InventoryItem{" + "description=" + description + ", inventoryItem=" 
                + inventory + ", quantityInStock=" + quantityInStock + ", requiredAmount=" 
                + requiredAmount + '}';
/*
                + ", medicine=" + medicine + ", water=" 
                + water + ", knife=" + knife + ", boots=" + boots + ", food=" 
                + food + ", shirt=" + shirt + '}';
*/
        }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.description);
        hash = 43 * hash + Objects.hashCode(this.inventory);
        hash = 43 * hash + Objects.hashCode(this.quantityInStock);
        hash = 43 * hash + Objects.hashCode(this.requiredAmount);
/*        
        hash = 43 * hash + Objects.hashCode(this.medicine);
        hash = 43 * hash + Objects.hashCode(this.water);
        hash = 43 * hash + Objects.hashCode(this.knife);
        hash = 43 * hash + Objects.hashCode(this.boots);
        hash = 43 * hash + Objects.hashCode(this.food);
        hash = 43 * hash + Objects.hashCode(this.shirt);
*/
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final InventoryItem other = (InventoryItem) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.inventory, other.inventory)) {
            return false;
        }
/*        if (!Objects.equals(this.medicine, other.medicine)) {
            return false;
        }
        if (!Objects.equals(this.water, other.water)) {
            return false;
        }
        if (!Objects.equals(this.knife, other.knife)) {
            return false;
        }
        if (!Objects.equals(this.boots, other.boots)) {
            return false;
        }
        if (!Objects.equals(this.food, other.food)) {
            return false;
        }
        if (!Objects.equals(this.shirt, other.shirt)) {
            return false;
        }
*/
        if (!Objects.equals(this.quantityInStock, other.quantityInStock)) {
            return false;
        }
        if (!Objects.equals(this.requiredAmount, other.requiredAmount)) {
            return false;
        }
        return true;
    }   
}
