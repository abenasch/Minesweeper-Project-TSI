package org.example;
import  java.util.*;
public class Board {

    private int TotalOpened;
    private int width;
    private int height;
    private Cell [][] cells;
    private ArrayList<Cell> minesList = new ArrayList<Cell>();

    public Board(int width, int height) {
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
    public void printBoard() {
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
    }

    public Cell[][] getCells() {
        return cells;
    }

    public void OpenCell(int x, int y){
        TotalOpened ++;
        cells[x][y].Open();
        if (cells[x][y].getNeighbouringMine() == 0 && !cells[x][y].getHasMine()){
            OpenAllNeighbours(x ,y);
        }
    }

    private void OpenAllNeighbours(int x, int y) {
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


    public void generateMines(int mines) {
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

    private void addMine(Position position) {

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

    public void revealAllMines() {
        for (Cell cell: minesList){
            cell.Open();
        }
    }

}
