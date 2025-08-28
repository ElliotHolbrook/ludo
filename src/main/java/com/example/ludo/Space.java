package com.example.ludo;

public class Space {
    private int[] coords = new int[2];

    public Space(int x, int y) {
        coords[0] = x;
        coords[1] = y;
    }

    public int[] getCoords(){
        return coords;
    }
}
