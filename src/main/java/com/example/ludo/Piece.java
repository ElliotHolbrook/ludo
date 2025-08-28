package com.example.ludo;

public class Piece {
    private int position = -1;
    private boolean finisher = false;

    public Piece() {

    }

    public void move(int spaces) {
        int newPosition = (position + spaces) % 54;
        if(newPosition < position) {
            newPosition = newPosition - 54;
            finisher = true;
        } else {

        }
    }


}
