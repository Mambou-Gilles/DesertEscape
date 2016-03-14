/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import java.util.Scanner;

/**
 *
 * @author mambou
 */
public interface ViewInterface {

    public void display();

    public String getInput();

    public boolean doAction(String value);

    public abstract class View implements ViewInterface {

        protected String displayMessage;
        protected String displayScene;
        protected String displayHelp;
        protected String displayPromptMessage;

        public View() {
        }

        public View(String message) {
            this.displayMessage = message;
        }

        public View(String scene, String help, String promptMessage) {
            this.displayScene = scene;
            this.displayHelp = help;
            this.displayPromptMessage = promptMessage;
        }

        @Override
        public void display() {

            boolean done = false; // set flag to not done
            do {
                // prompt for and get players name
                String value = this.getInput();
                if (value.toUpperCase().equals("Q")) // user wants to quit
                {
                    return; // exit the game
                }
                // do the requested action and display the next view
                done = this.doAction(value);

            } while (!done);
        }

        @Override
        public String getInput() {

            Scanner keyboard = new Scanner(System.in); //get infile for keyboard
            String value = ""; //value to be returned
            boolean valid = false; //initialize to not valid

            while (!valid) { //loop while an invalid is entered
                System.out.println(this.displayMessage);

                value = keyboard.nextLine();// get next line typed on keyboard
                value = value.trim();// trim of leading and trailing blanks

                if (value.length() < 1) { // value is blank
                    System.out.println("Invalid value: value cannot be blank, please enter a value");
                    continue;
                }
                break; // end loop
            }
            return value; // return value entered
        }

       @Override
        public boolean doAction(String value) {

            value = value.toUpperCase();
            return false;
        }

    }
}
