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
 * @author mambou & Paez 
 */
public class Inventory implements Serializable {
     
    private String description;
    private String inventoryItem;
    private Integer quantityInStock;
    private Integer requiredAmount;
    private String medecine;
    private String water;
    private String knife;
    private String boots;
    private String food;
    private String shirt;

    public Inventory() {
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getInventoryItem() {
        return inventoryItem;
    }

    public void setInventoryItem(String inventoryItem) {
        this.inventoryItem = inventoryItem;
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

    public String getMedecine() {
        return medecine;
    }

    public void setMedecine(String medecine) {
        this.medecine = medecine;
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water;
    }

    public String getKnife() {
        return knife;
    }

    public void setKnife(String knife) {
        this.knife = knife;
    }

    public String getBoots() {
        return boots;
    }

    public void setBoots(String boots) {
        this.boots = boots;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public String getShirt() {
        return shirt;
    }

    public void setShirt(String shirt) {
        this.shirt = shirt;
    }

    @Override
    public String toString() {
        return "Inventory{" + "description=" + description + ", inventoryItem=" + inventoryItem + ", quantityInStock=" + quantityInStock + ", requiredAmount=" + requiredAmount + ", medecine=" + medecine + ", water=" + water + ", knife=" + knife + ", boots=" + boots + ", food=" + food + ", shirt=" + shirt + '}';
    }
    
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 43 * hash + Objects.hashCode(this.description);
        hash = 43 * hash + Objects.hashCode(this.inventoryItem);
        hash = 43 * hash + Objects.hashCode(this.quantityInStock);
        hash = 43 * hash + Objects.hashCode(this.requiredAmount);
        hash = 43 * hash + Objects.hashCode(this.medecine);
        hash = 43 * hash + Objects.hashCode(this.water);
        hash = 43 * hash + Objects.hashCode(this.knife);
        hash = 43 * hash + Objects.hashCode(this.boots);
        hash = 43 * hash + Objects.hashCode(this.food);
        hash = 43 * hash + Objects.hashCode(this.shirt);
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
        final Inventory other = (Inventory) obj;
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.inventoryItem, other.inventoryItem)) {
            return false;
        }
        if (!Objects.equals(this.medecine, other.medecine)) {
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
        if (!Objects.equals(this.quantityInStock, other.quantityInStock)) {
            return false;
        }
        if (!Objects.equals(this.requiredAmount, other.requiredAmount)) {
            return false;
        }
        return true;
    }

    
    
    
    
}
