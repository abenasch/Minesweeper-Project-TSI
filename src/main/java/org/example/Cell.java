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
        if (isOpen){
            System.out.println("This cell is already open");
        }
        else if (!hasFlag) {
            this.hasFlag = true;
        }
        else {
            this.hasFlag = false;
        }
    }

    public boolean getisOpen() {
        return isOpen;
    }

    public int getNeighbouringMine() {

        return NeighbouringMine;
    }

    public String reveal() { //flag unicode: 🚩
        if (isHasFlag()){
            return " \uD83D\uDEA9";
        }
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

