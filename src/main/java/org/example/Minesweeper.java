package org.example;
import java.util.*;
public class Minesweeper { //contains core game functionality - allows user input and generates board
    private Scanner scanner;
    private Board board;

    public Minesweeper() {
        scanner = new Scanner(System.in);
        this.board = new Board(10,10);
        board.generateMines(10);
        //board.revealBoard;
    }

    public void startGame() { //set win and lose conditions, contains input validation
        boolean GameOver = false;
        do {
            System.out.println("Found cells: "+board.getTotalOpened()+ "/90");
            board.printBoard();
            if(board.getTotalOpened() == 90){ //win condition
                board.printBoard();
                System.out.println("You have found all the Mines! You WIN");
                GameOver = true;
            }
            Position move;
            move = getInput();
            if (move.getX()!=-99 && move.getX()!=-98){ //-99 is set as X if there is an invalid input, -98 is set if a flag is being placed
                Cell cell = board.getCells()[move.getX()][move.getY()];
                if (cell.getisOpen() || cell.isHasFlag()){
                    System.out.println("This Cell is already open/flagged, please select another cell");
                }
                else if (cell.getHasMine()){ //lose condition
                    board.revealAllMines();
                    board.printBoard();
                    System.out.println("You have clicked a mine, GAME OVER!");
                    GameOver = true;
                }

                else{ //Open a new cell
                    board.OpenCell(move.getX(), move.getY());
                }
            }
            else if (move.getX()==-99) { //input is invalid, reset scanner and try again
                System.out.println("invalid input, please provide 2 numbers (0 - 9) in the form 'X Y'");
                move.setX(0);
                scanner = new Scanner(System.in);
            }
            else{ //x is -98, flag is set and scanner reset
                move.setX(0);
                scanner = new Scanner(System.in);
            }
        }while (!GameOver);


    }

    private Position getInput() { //allows input to the user
            Position input = new Position();
            System.out.println("Please enter coordinates to OPEN (separate by space) or 'F' to FLAG a coordinate");
            if (scanner.hasNext("F")){
                input = InputFlag(input); //InputFlag function is called if user wants to flag
            }
            else {
                if (scanner.hasNextInt()) {
                    input.setX(scanner.nextInt());
                    if (scanner.hasNextInt()) { //only if 2 integers are detected
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
                if (input.getX() > 9 || input.getX() < 0 || input.getY() > 9 || input.getY() < 0) { //if out of range
                    System.out.println("invalid inputs, make sure that the inputs are within the range 0-9, please try again ");
                    input = getInput();
                    return input;
                }
            }
        return input;
    }

    private Position InputFlag(Position input) { //reset scanner and ask for coordinate input to flag with input validation
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
            scanner = new Scanner(System.in);
            input.setX(-99);
        }
        else{
            board.getCells()[input.getX()][input.getY()].setHasFlag();
            input.setX(-98);
        }
        return (input);

    }
}
