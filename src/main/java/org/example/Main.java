package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main { //Main -- start, create a minesweeper object and start a new game
    public static void main(String[] args) {
        Minesweeper minesweeper = new Minesweeper();
        minesweeper.startGame();
    }
}