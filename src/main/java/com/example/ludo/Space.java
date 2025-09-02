package com.example.ludo;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.LinkedList;

public class Space {
    private int position;
    private Pane root;
    private boolean safe;
    private LinkedList<Piece> occupiers = new LinkedList<>();

    public Space(int position, Pane root) {
        this.root = root;
        this.position = position;

        if(position % 13 == 0) {
            this.safe = true;
            switch (position / 13) {
                case 0:
                    root.setStyle("-fx-background-color: darkred");
                    break;
                case 1:
                    root.setStyle("-fx-background-color: darkgreen");
                    break;
                case 2:
                    root.setStyle("-fx-background-color: gold");
                    break;
                case 3:
                    root.setStyle("-fx-background-color: darkblue");
                    break;

            }
        }
    }

    public int getPosition() { return position; }

    public void addOccupier(Piece piece) {
        occupiers.add(piece);
    }

    public void removeOccupier(Piece piece) {
        occupiers.remove(piece);
    }

    public void clearOccupiers() {
        occupiers.clear();
    }

    public Pane getRoot() { return root; }

}
