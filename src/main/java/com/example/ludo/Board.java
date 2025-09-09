package com.example.ludo;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.awt.*;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

class Board {
    private static Board instance = null;

    private Player[] players;
    private Space[] spaces;
    private Dictionary<Colour, EndSpace[]> end_spaces = new Hashtable<>();

    private Dictionary<Colour, Integer> colour_position_offsets = new Hashtable<>();

    //One board at a time
    private Board() {
        players = new Player[4];
        createPlayers();
        spaces = new Space[52];

        this.colour_position_offsets.put(Colour.RED, 0);
        this.colour_position_offsets.put(Colour.GREEN, 13);
        this.colour_position_offsets.put(Colour.YELLOW, 26);
        this.colour_position_offsets.put(Colour.BLUE, 39);

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

    public void addSpace(Space space) {
        spaces[space.getPosition()] = space;
    }

    public void addEndSpace(EndSpace end_space) {
        if(this.end_spaces.get(end_space.getColour()) == null) {
            this.end_spaces.put(end_space.getColour(), new EndSpace[5]);
        }
        EndSpace[] colour_end_spaces = this.end_spaces.get(end_space.getColour());
        colour_end_spaces[end_space.getPosition()] = end_space;
        this.end_spaces.put(end_space.getColour(), colour_end_spaces);
    }

    public Player[] getPlayers() { return players; }
    public Space[] getSpaces() { return spaces; }

    public void setSpaces(Pane[] roots) {
        int index = 0;
        for(Pane root : roots) {
            Space space = new Space(index++, root);
            this.addSpace(space);
        }
    }
}