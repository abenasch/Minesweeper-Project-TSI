package org.example;

public class Position { //coordinates coresponding to each cell on the board (should have done input validation in here)
    public int x;
    public int y;

    public Position() {
        this.x = 0;
        this.y = 0;
    }

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
 //       System.out.println("Bomb at: x="+ x+ " y="+y );

    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
}