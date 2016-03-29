/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import byui.cit260.desertEscapeGame.control.GameControl;
import byui.cit260.desertEscapeGame.model.Player;
import byui.cit260.desertEscapeGame.model.Location;
import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;
import desertescape.DesertEscape;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author MarcoA
 */
public class PlayersView extends View {

    Player player;

    public PlayersView() {

        super("\n#####################################"
                + "\n#                                   #"
                + "\n#         P L A Y E R S             #"
                + "\n#   =========================       #"
                + "\n#                                   #"
                + "\n#   LETTER         ACTION           #"
                + "\n#     P     Player Name             #"
                + "\n#     S     Save Current Player     #"
                + "\n#     L     Current Players List    #"
                + "\n#     Q     Return                  #"
                + "\n#                                   #"
                + "\n#####################################"
                + "\n      Choose your Players Action");
    }

    @Override
    public boolean doAction(String value) {
        value = value.toUpperCase(); // Convert menuOpton to uppercase
        switch (value) {
            case "P": // Sort by Item description
                this.PlayersControl();
                break;
            case "S": // Sort by Item description
                this.SavePlayer(player);
                break;
            case "L": // Inventory List 
                this.PlayerList(player);
                break;
            case "Q": // return previous menu
                break;
            default:
                this.console.println("\n*** Invalid selection *** Try again");
                break;
        }
        return false;
    }

    private void PlayersControl() {
        // Require name
        StartProgramView startProgramView = new StartProgramView();
        startProgramView.display();

        // Call Players Menu
        PlayersView playersView = new PlayersView();
        playersView.display();
        
    }
    
    private void SavePlayer(Player playerName) {

        String pName = DesertEscape.getPlayer().getPlayerName();
        //Integer pTime = DesertEscape.getPlayer().getPlayerTime();
        Location pLocation = DesertEscape.getPlayer().getLocation();
        Integer pTime = 100;
        /*Location pLocation = null;
        pLocation.getRow();
        pLocation.getColumn();
        pLocation.isPlaceVisited();
        pLocation.getAmountRemaining();
         */
        System.out.println("\nWelcome! " + pName);
        System.out.println("Your play time is " + pTime);
        System.out.println("Your location is " + pLocation);

        String dataLine = pName + pTime + pLocation;
        System.out.println("The data line to save is " + dataLine);

        //DesertEscape.setCurrentGame(Game dataLine);
        System.out.println("\n\nEnter path to save your data: ");
        String filePath = this.getInput();
        System.out.println("The file will save as: " + filePath);

        try (FileOutputStream fops = new FileOutputStream(filePath)) {
            ObjectOutputStream output = new ObjectOutputStream(fops);

            output.writeObject(pName);
            output.writeObject(pTime);
            output.writeObject(pLocation);

            System.out.println("\n" + pName + " your game was saved... ");
        } catch (Exception ex) {
            ErrorView.display("PlayerView", ex.getMessage());
        }
        return;
    }

    private void PlayerList(Player playerName) {

        playerName = null;

        System.out.println("\n\nEnter the file name to load your data: ");
        String filePath = this.getInput();
        System.out.println("The file to load is: " + filePath);

        String pName;
        //pName = playerName.getPlayerName();
        Integer pTime;
        //pTime = playerName.getPlayerTime();
        //Location pLocation;
        //pLocation = playerName.getLocation();

        try (FileInputStream fis = new FileInputStream(filePath)) {
            ObjectInputStream ois = new ObjectInputStream(fis);

            playerName = (Player) ois.readObject();

            pName = playerName.getPlayerName();
            pTime = playerName.getPlayerTime();
            //  pLocation = playerName.getLocation();

            System.out.println("The data read is: " + playerName);
            //DesertEscape.setPlayer(pName);
            //DesertEscape.setPlayer(pLocation);

        } catch (Exception ex) {
            ErrorView.display("PlayerView", ex.getMessage());
        }

        // print tittle and column heading
        console.println("\n\n       LIST OF PLAYERS");
        console.println("------------------------------");
        console.printf("%-10s%-10s%-10s", "Name", "Time", "Location");
        console.println("\n------------------------------");
        //
        console.printf("%n%-10s%-10d%-10.2f", playerName.getPlayerName()
                                        ,playerName.getPlayerTime()
                                        ,playerName.getLocation());
    }
    
}
