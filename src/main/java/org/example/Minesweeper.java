package org.example;
import java.util.*;
public class Minesweeper {
    private Scanner scanner;
    private Board board;

    public Minesweeper() {
        scanner = new Scanner(System.in);
        this.board = new Board(10,10);
        board.generateMines(10); //need to avoid generating duplicate bombs in same position
        //board.revealBoard;
    }

    public void startGame() {
        boolean GameOver = false;
        do {
            System.out.println("Found cells: "+board.getTotalOpened()+ "/90");
            board.printBoard();
            Position move;
            move = getInput();
            if (move.getX()!=-99){

                Cell cell = board.getCells()[move.getX()][move.getY()];
                if (cell.getisOpen() || cell.isHasFlag()){
                    System.out.println("This Cell is already open/falgged, please select another cell");
                }
                else{
                    board.OpenCell(move.getX(), move.getY());
                }
                if (cell.getHasMine()){
                    board.revealAllMines();
                    board.printBoard();
                    System.out.println("You have clicked a mine, GAME OVER!");
                    GameOver = true;
                }
                else if(board.getTotalOpened() == 90){
                    board.printBoard();
                    System.out.println("You have found all the Mines! You WIN");
                    GameOver = true;
                }
            }
            else {
                System.out.println("invalid input, please provide 2 numbers in the form 'X Y'");
                move.setX(0);
                scanner = new Scanner(System.in);
            }
        }while (!GameOver);


    }

    private Position getInput() { //make sure input is valid, not a string

            Position input = new Position();
            System.out.println("Please enter coordinates to open (separate by space)");
            if (scanner.hasNextInt()) {
                input.setX(scanner.nextInt());
                if (scanner.hasNextInt()) {
                    input.setY(scanner.nextInt());
                }
                else{
                    input.setX(-99);
                    return input;
                }
            }
            else {
                input.setX(-99);
                return input;
            }
            System.out.println("You have entered: x= " + input.getX() + " y = " + input.getY());
            if (input.getX() > 9 || input.getX() < 0 || input.getY() > 9 || input.getX() < 0) {
                System.out.println("invalid inputs, make sure that the inputs are within the range 0-9, please try again ");
                input = getInput();
                return input;
            }
            return input;


    }
}
