/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package byui.cit260.desertEscapeGame.control;

import byui.cit260.desertEscapeGame.model.BuildTimeMachine;
import byui.cit260.desertEscapeGame.model.FillPit;
import byui.cit260.desertEscapeGame.model.Game;
import byui.cit260.desertEscapeGame.model.InventoryItem;
import byui.cit260.desertEscapeGame.model.Item;
import byui.cit260.desertEscapeGame.model.Location;
import byui.cit260.desertEscapeGame.model.Map;
import byui.cit260.desertEscapeGame.model.Mission;
import byui.cit260.desertEscapeGame.model.Player;
import byui.cit260.desertEscapeGame.model.Scene;
import byui.cit260.desertEscapeGame.model.SceneType;
import byui.cit260.desertEscapeGame.model.ShopDownTree;
import desertescape.DesertEscape;

/**
 *
 * @author mambou
 */
public class GameControl {

    public static InventoryItem[] createInventoryList() {
        // Created array(list) of inventory items
        InventoryItem[] inventory = new InventoryItem[6];

        InventoryItem medicine = new InventoryItem();
        medicine.setDescription("Medicine");
        medicine.setQuantityInStock(2);
        medicine.setRequiredAmount(1);
        inventory[Item.medicine.ordinal()] = medicine;

        InventoryItem water = new InventoryItem();
        water.setDescription("Water");
        water.setQuantityInStock(0);
        water.setRequiredAmount(0);
        inventory[Item.water.ordinal()] = water;

        InventoryItem food = new InventoryItem();
        food.setDescription("Food");
        food.setQuantityInStock(0);
        food.setRequiredAmount(0);
        inventory[Item.food.ordinal()] = food;

        InventoryItem knife = new InventoryItem();
        knife.setDescription("Knife");
        knife.setQuantityInStock(0);
        knife.setRequiredAmount(0);
        inventory[Item.knife.ordinal()] = knife;

        InventoryItem boot = new InventoryItem();
        boot.setDescription("Boot");
        boot.setQuantityInStock(0);
        boot.setRequiredAmount(0);
        inventory[Item.boot.ordinal()] = boot;

        InventoryItem shirt = new InventoryItem();
        shirt.setDescription("Shirt");
        shirt.setQuantityInStock(0);
        shirt.setRequiredAmount(0);
        inventory[Item.shirt.ordinal()] = shirt;

        return inventory;
    }

    /*static boolean getSortedInventoryList() {
        InventoryItem[] inventoryItem = InventoryItem[8];

        for (int i = 0; i < InventoryItem.class.getModifiers(); i++) {
            System.out.println("\n" + InventoryItem(i);     
        
        }
        return true;

    }*/

    public static void createNewGame(Player player) {
        Game game = new Game();  // create a new game
        DesertEscape.setCurrentGame(game); // save game in DesertEscape

        
        game.setPlayer(player); // save player in the game

        //create the inventory list and save in the game
        InventoryItem[] inventoryList = GameControl.createInventoryList();
        game.setInventoryItem(inventoryList);

        FillPit pit = new FillPit();
        game.setPit(pit);

        BuildTimeMachine machine = new BuildTimeMachine();
        game.setMachine(machine);

        ShopDownTree tree = new ShopDownTree();
        game.setTree(tree);

        Mission mission = new Mission();
        game.setMission(mission);

        Map map = MapControl.createMap();
        game.setMap(map);
        
        //Map gameMap = new Map();
        //game.setMap(gameMap);
        
        player.setLocation(map.getLocation(0, 0));
        
        DesertEscape.setCurrentGame(game);

        //Move actor to starting position in the map
        MapControl.moveActorsToStartinglocation(map);
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

    static void assignScenesToLocations(Map map, Scene[] scenes) {
        Location[][] locations = map.getLocations();

        //start point
        locations[0][0].setScene(scenes[SceneType.alienCamp.ordinal()]);
        locations[0][1].setScene(scenes[SceneType.alienCamp.ordinal()]);
        locations[0][2].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][3].setScene(scenes[SceneType.caves.ordinal()]);
        locations[0][4].setScene(scenes[SceneType.caves.ordinal()]);
        locations[0][5].setScene(scenes[SceneType.start.ordinal()]);
        locations[0][6].setScene(scenes[SceneType.cliffs.ordinal()]);
        locations[0][7].setScene(scenes[SceneType.cliffs.ordinal()]);
        locations[0][8].setScene(scenes[SceneType.desert.ordinal()]);
        
        locations[9][9].setScene(scenes[SceneType.pyramids.ordinal()]);

    }
}
