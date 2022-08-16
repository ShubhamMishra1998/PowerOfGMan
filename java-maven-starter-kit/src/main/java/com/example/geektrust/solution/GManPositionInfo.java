package com.example.geektrust.solution;

public class GManPositionInfo {
    private int row;
    private int col;
    private int power;
    private String direction;

    public GManPositionInfo(int row, int col,int power,String direction) {
        this.row = row;
        this.col = col;
        this.direction = direction;
        this.power=power;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public int getPower() {
        return power;
    }

    public String getDirection() {
        return direction;
    }
}
