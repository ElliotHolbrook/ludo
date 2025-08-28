package com.example.ludo;

import javafx.scene.layout.Pane;

public class EndSpace extends Space{
    private Colour colour;

    public EndSpace(int id, Pane root, Colour colour) {
        super(id, root);
        this.colour = colour;
    }
}
