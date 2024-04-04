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
        boolean GameOver = false;
        do {
            System.out.println("Found cells: "+board.getTotalOpened()+ "/90");
            board.printBoard();
            Position move;
            move = getInput();
            if(board.getTotalOpened() == 90){
                board.printBoard();
                System.out.println("You have found all the Mines! You WIN");
                GameOver = true;
            }
            if (move.getX()!=-99 && move.getX()!=-98){
                Cell cell = board.getCells()[move.getX()][move.getY()];
                if (cell.getisOpen() || cell.isHasFlag()){
                    System.out.println("This Cell is already open/flagged, please select another cell");
                }
                else if (cell.getHasMine()){
                    board.revealAllMines();
                    board.printBoard();
                    System.out.println("You have clicked a mine, GAME OVER!");
                    GameOver = true;
                }

                else{
                    board.OpenCell(move.getX(), move.getY());
                }
            }
            else if (move.getX()==-99) {
                System.out.println("invalid input, please provide 2 numbers in the form 'X Y'");
                move.setX(0);
                scanner = new Scanner(System.in);
            }
            else{
                move.setX(0);
                scanner = new Scanner(System.in);
            }
        }while (!GameOver);


    }

    private Position getInput() { //make sure input is valid, not a string
            Position input = new Position();
            System.out.println("Please enter coordinates to OPEN (separate by space) or F to FLAG a coordinate");
            if (scanner.hasNext("F")){
                input = InputFlag(input);
            }
            else {
                if (scanner.hasNextInt()) {
                    input.setX(scanner.nextInt());
                    if (scanner.hasNextInt()) {
                        input.setY(scanner.nextInt());
                    } else {
                        input.setX(-99);
                        return input;
                    }
                } else {
                    input.setX(-99);
                    return input;
                }
                System.out.println("You have entered: x= " + input.getX() + " y = " + input.getY());
                if (input.getX() > 9 || input.getX() < 0 || input.getY() > 9 || input.getY() < 0) {
                    System.out.println("invalid inputs, make sure that the inputs are within the range 0-9, please try again ");
                    input = getInput();
                    return input;
                }
            }
        return input;
    }

    private Position InputFlag(Position input) {
        System.out.println("Please enter coordinates to FLAG (separate by space)");
        scanner = new Scanner(System.in);
        if (scanner.hasNextInt()) {
            input.setX(scanner.nextInt());
            if (scanner.hasNextInt()) {
                input.setY(scanner.nextInt());
            } else {
                input.setX(-99);
            }
        } else {
            input.setX(-99);
        }
        System.out.println("You have entered: x= " + input.getX() + " y = " + input.getY() + " TO FLAG");
        if (input.getX() > 9 || input.getX() < 0 || input.getY() > 9 || input.getY() < 0) {
            System.out.println("invalid inputs, make sure that the inputs are within the range 0-9, please try again ");
            scanner = new Scanner(System.in);
        }
        else{
            board.getCells()[input.getX()][input.getY()].setHasFlag();
            input.setX(-98);
        }
        return (input);

    }
}
