/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citbyui.cit260.desertEscapeGame.view;

import citbyui.cit260.desertEscapeGame.view.ViewInterface.View;

/**
 *
 * @author MarcoA
 */
public class IntroductionView extends View{

    public IntroductionView() {
    
        super("\n*****************************************************************"
                + "\n*                                                               *"
                + "\n* This is Nicolas Williams Desert Escape Game                   *"
                + "\n* In this game you will take the role of Nicolas Williams       *"
                + "\n* who was born on earth in a distant future                     *"
                + "\n* But there was a global catastroph.                            *"
                + "\n* You are forced to leave earth and travel to another planet    *"
                + "\n*                                                               *"
                + "\n* You will face many threat on this new planet,                 *"
                + "\n* and you must avoid being taken by an enemy alien race         *"
                + "\n* In the game course, you will come to learn of a time machine  *"
                + "\n* that will allow you to rewrite time and reverse               *"
                + "\n* he global catastroph that destroyed earth.                    *"
                + "\n* This will become your and van be achieved by hunting down     *"
                + "\n* artifacts and items and assembling a time machine based off   *"
                + "\n* of a schematic hat was discovered                             *"
                + "\n* Find the resources needed to build the time machine and       *"
                + "\n* save the earth.                                               *"
                + "\n*                                                               *"
                + "\n                                                                *"
                + "\n*            Good luck and enjoy the adventure                  *"
                + "\n*                                                               *"
                + "\n*****************************************************************");

    }
    
    @Override
    public boolean doAction(String value) {
        return true;
    }
}
