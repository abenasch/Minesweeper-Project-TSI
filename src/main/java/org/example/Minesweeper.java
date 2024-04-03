package org.example;
import java.util.*;
public class Minesweeper {
    private Scanner scanner;
    private Board board;

    public Minesweeper() {
        scanner = new Scanner(System.in);
        this.board = new Board(10,10);
        board.generateMines(10);
        //board.revealBoard;
    }

    public void startGame() {
        do {
            board.printBoard();
            Position move = getInput();
            board.OpenCell(move.getX(), move.getY());
        }while (true);


    }

    private Position getInput() {
        Position input = new Position();
        System.out.println("Please enter coordinates to open (separate by space)");
        input.setX(scanner.nextInt());
        input.setY(scanner.nextInt());
        System.out.println("You have entered: x= "+ input.getX()+ " y = " + input.getY());
        System.out.println(input.getY());
        return input;
    }
}
