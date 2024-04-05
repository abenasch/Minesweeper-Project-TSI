package org.example;
import  java.util.*;
public class Board { //creates the board, asssigns mines, prints board when required

    private int TotalOpened;
    private final int width;
    private final int height;
    private Cell [][] cells;
    private ArrayList<Cell> minesList = new ArrayList<Cell>();

    public Board(int width, int height) { //generates cells in vector (width x height)
        this.width = width;
        this.height = height;
        this.TotalOpened = 0;
        cells = new Cell[width][height];
        for (int x=0; x<width; x++){
            for (int y=0; y<height; y++){
                cells[x][y]= new Cell();
            }
        }
    }
    public void printBoard() { //print board by calling reveal() on each cell
        for(int y = 0; y < height; y++) {
            for(int x = 0; x < width; x++) {
                System.out.print(cells[x][y].reveal());
            }
            System.out.println(" |"+y);
        }
        System.out.println("⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯⎯");
        System.out.println(" 0  1  2  3  4  5  6  7  8  9 ");
    }

    public int getTotalOpened() {
        return TotalOpened;
    } //returns total Opened cells

    public Cell[][] getCells() {
        return cells;
    } //getter for cells

    public void OpenCell(int x, int y){ //Opens a cell and adds a counter to TotalOpened
        TotalOpened ++;
        cells[x][y].Open();
        if (cells[x][y].getNeighbouringMine() == 0 && !cells[x][y].getHasMine()){ //if it has no neighbouring mines (neighbouringMine=0), open all neighbours
            OpenAllNeighbours(x ,y);
        }
    }

    private void OpenAllNeighbours(int x, int y) { //if statements checking neighbours are in board range, and if so open them.
        if (x-1>=0 && y-1>=0){
            if (!cells[x - 1][y - 1].getisOpen()) {
                OpenCell(x - 1, y - 1);
            }
        }
        if (x-1>=0){
            if (!cells[x - 1][y].getisOpen()) {
                OpenCell(x - 1, y);
            }
        }
        if (x-1>=0 && y+1 <=9){
            if (!cells[x - 1][y+1].getisOpen()) {
                OpenCell(x - 1, y + 1);
            }
        }
        if (y-1>=0){
            if (!cells[x][y-1].getisOpen()) {
                OpenCell(x, y - 1);
            }
        }
        if (y+1<=9){
            if (!cells[x][y+1].getisOpen()) {
                OpenCell(x, y + 1);
            }
        }
        if (x+1<=9 && y-1>=0){
            if (!cells[x + 1][y-1].getisOpen()) {
                OpenCell(x + 1, y - 1);
            }
        }
        if (x+1<=9){
            if (!cells[x + 1][y].getisOpen()) {
                OpenCell(x + 1, y);
            }
        }
        if (x+1<=9 && y+1 <=9){
            if (!cells[x + 1][y+1].getisOpen()) {
                OpenCell(x + 1, y+1);
            }
        }
    }


    public void generateMines(int mines) { //creates mines in randomised positions
        Random random = new Random();

        for (int a = 0; a < mines; a++){
            Position MinePosition = new Position(random.nextInt(mines),random.nextInt(mines));
            if (!cells[MinePosition.getX()][MinePosition.getY()].getHasMine()){
                addMine(MinePosition);
                minesList.add(cells[MinePosition.getX()][MinePosition.getY()]);
            }
            else{
                a--;
            }
        }
    }

    private void addMine(Position position) {  //add a mine in specified position, add one to NeighbouringMine counter to all neighbouring cells of that mine if in range

        cells[position.getX()][position.getY()].setHasMine();
        if ((position.getX()-1)>=0 && position.getY()-1>=0){
            cells[position.getX()-1][position.getY()-1].addNeighbourMine();
        }
        if ((position.getX()-1)>=0){
            cells[position.getX()-1][position.getY()].addNeighbourMine();
        }
        if ((position.getX()-1)>=0 && (position.getY()+1)<=9){
            cells[position.getX()-1][position.getY()+1].addNeighbourMine();
        }
        if ( (position.getY()-1)>=0){
            cells[position.getX()][position.getY()-1].addNeighbourMine();
        }
        if (( position.getY()+1<=9)){
            cells[position.getX()][position.getY()+1].addNeighbourMine();
        }
        if ((position.getX()+1)<=9 && position.getY()-1>=0){
            cells[position.getX()+1][position.getY()-1].addNeighbourMine();
        }
        if ((position.getX()+1)<=9){
            cells[position.getX()+1][position.getY()].addNeighbourMine();
        }
        if ((position.getX()+1)<=9 && position.getY()+1<=9){
            cells[position.getX()+1][position.getY()+1].addNeighbourMine();
        }
    }

    public void revealAllMines() { //show all mines when user loses
        for (Cell cell: minesList){
            cell.Open();
        }
    }

}
