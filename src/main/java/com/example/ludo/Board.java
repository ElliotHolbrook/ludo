package com.example.ludo;

import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;

class Board {
    private static Board instance = null;


    private Player[] players = new Player[4];


    //One board at a time
    private Board() {

    }

    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }

    //create the players
    public void createPlayers() {
        if(players.length != 0) {
            return;
        }

        int i = 0;
        for(Colour colour : Colour.values()) {
            players[i++] = new Player(colour=colour);
        }
    }

}