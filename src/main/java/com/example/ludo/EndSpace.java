package com.example.ludo;

import javafx.scene.layout.Pane;

public class EndSpace extends Space{
    private Colour colour;


    public EndSpace(int position, Pane root, Colour colour) {
        this.position = position;
        this.root = root;
        this.colour = colour;
        this.setRootColour(colour);
    }

    private void setRootColour(Colour colour) {
        switch (colour) {
            case RED -> this.getRoot().setStyle("-fx-background-color: red;");
            case BLUE -> this.getRoot().setStyle("-fx-background-color: blue;");
            case GREEN -> this.getRoot().setStyle("-fx-background-color: green;");
            case YELLOW -> this.getRoot().setStyle("-fx-background-color: yellow;");
        }
        this.root.setStyle(this.root.getStyle() +  "-fx-border-color: darkgrey; -fx-border-width: 1;");
    }

    public Colour getColour() {
        return this.colour;
    }
}
