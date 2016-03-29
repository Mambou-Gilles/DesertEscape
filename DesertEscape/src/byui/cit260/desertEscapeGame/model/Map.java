/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscapeGame.model;

import citbyui.cit260.desertEscapeGame.view.ErrorView;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Objects;

/**
 *
 * @author mambou & Paez
 */
public class Map implements Serializable {

    public static  final int noOfRows = 5;
    public static final int noOfColumns = 5;
 //public static final int noOfColumns = 5;
    
    private Location[][] locations;
    private String mapString;
    private int noOfRow;
    private int noOfColumn;
    
   

    public Map() {
        locations = new Location[noOfRows][noOfColumns];

    }

    public Map(int noOfRows, int noOfColumns) {

        if (noOfRows < 1 || noOfColumns < 1) {
            ErrorView.display(this.getClass().getName(),
                "\n number of rows and columns must be > zero");
            return;
        }
        
        //this.noOfRows = noOfRows;
        //this.noOfColumns = noOfColumns;

        //create 2-D array for location object
        this.locations = new Location[noOfRows][noOfColumns];

        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                // create an initialise new location object instance
                Location location = new Location();
                location.setColumn(column);
                location.setRow(row);
                location.setPlaceVisited(false);

                //create a random location type
                location.setType(SceneType.values()[(int) (Math.random() * SceneType.values().length)]);
               

                //assign the location object to current position in array
                locations[row][column] = location;
            }
        }

    }

    public int getNoOfRow() {
        return noOfRow;
    }

    public void setNoOfRow(int noOfRow) {
        this.noOfRow = noOfRow;
    }

    public int getNoOfColumn() {
        return noOfColumn;
    }

    public void setNoOfColumn(int noOfColumn) {
        this.noOfColumn = noOfColumn;
    }
    
    
    
    public String getMapString() {
        String rtn = "";

        for (int row = 0; row < noOfRows; row++) {
            for (int column = 0; column < noOfColumns; column++) {
                rtn += locations[row][column].getType().name().charAt(0) + "\t";
            }
            rtn += "\n";
        }
        return rtn;
    }

    public Location getLocation(int row, int column) {
        return locations[row][column];
    }

    public Location[][] getLocations() {
        return locations;
    }

    public void setLocations(Location[][] locations) {
        this.locations = locations;
    }

}
