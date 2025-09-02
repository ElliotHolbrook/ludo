package com.example.ludo;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;

class Board {
    private static Board instance = null;

    private Player[] players;
    private Space[] spaces;

    //One board at a time
    private Board() {
        players = new Player[4];
        createPlayers();
        spaces = new Space[52];

    }

    public static Board getInstance() {
        if(instance == null) {
            instance = new Board();
        }
        return instance;
    }

    public static Board reset() {
        instance = null;
        return new Board();
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

    public void addSpace(Space space, int location) {
        spaces[location] = space;
    }

    public Player[] getPlayers() { return players; }
    public Space[] getSpaces() { return spaces; }

    public void setSpaces(Pane[] roots) {
        int index = 0;
        for(Pane root : roots) {
            Space space = new Space(index, root);
            this.addSpace(space, index++);
        }
    }
}