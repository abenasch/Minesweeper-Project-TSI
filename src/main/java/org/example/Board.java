package org.example;
import  java.util.*;
public class Board {
    private int bombCount;
    private int flagCount;
    private int TotalOpened;
    private int width;
    private int height;
    private Cell [][] cells;

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        this.flagCount = 0;
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

    public void OpenCell(int x, int y){
        cells[x][y].Open();
    }


    public void generateMines(int mines) {
        Random random = new Random();
        for (int a = 0; a < mines; a++){
            addBomb(new Position(random.nextInt(mines),random.nextInt(mines)));
        }
    }

    private void addBomb(Position position) {

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
}
