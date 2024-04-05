package org.example;

public class Cell { //each cell has 3 different boolean state conditions, and a counter to know how many mines are neighbouring.
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
    } //set state of cell to Open

    public boolean isHasFlag() {
        return hasFlag;
    } //getter flag status, check if Cell has a flag

    public void setHasFlag() { //if flag isn't opened, toggle the flag state
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
    } //check if cell is open

    public int getNeighbouringMine() { //return the counter

        return NeighbouringMine;
    }

    public String reveal() { //flag unicode: 🚩, mine unicode: 💣 otherwise *
        if (isHasFlag()){
            return " \uD83D\uDEA9";
        }
        if(getisOpen()) {
            if(getHasMine()){
                return " \uD83D\uDCA3";
            }
            else{
                return( " " + getNeighbouringMine() + " ");
            }

        } else {
            return " * ";
        }
    }

    public boolean getHasMine() {
        return hasMine;
    } //check if cell has a mine

    public void setHasMine() {
        this.hasMine = true;
    } //set this cell to have a mine


    public void addNeighbourMine() {
        this.NeighbouringMine++;
    } //add 1 to counter
}

