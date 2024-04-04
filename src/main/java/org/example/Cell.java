package org.example;

public class Cell {
    private boolean hasMine;
    private boolean isOpen;
    private boolean hasFlag;
    private int NeighbouringMine;

    public Cell() {
        this.hasMine = false;
        this.isOpen = false;
        this.hasFlag = false;
        this.NeighbouringMine = 0;
    }
    public void Open() {
        isOpen = true;
    }

    public boolean isHasFlag() {
        return hasFlag;
    }

    public void setHasFlag() {
        this.hasFlag = true;
    }

    public boolean getisOpen() {
        return isOpen;
    }

    public int getNeighbouringMine() {

        return NeighbouringMine;
    }

    public String reveal() { //flag unicode: 🚩
        if(isOpen) {
            if(hasMine){
                return " \uD83D\uDCA3";
            }
            else{
                return( " " +Integer.toString(getNeighbouringMine()) + " ");
            }

        } else {
            return " * ";
        }
    }

    public boolean getHasMine() {
        return hasMine;
    }

    public void setHasMine() {
        this.hasMine = true;
    }


    public void addNeighbourMine() {
        this.NeighbouringMine++;
    }
}

