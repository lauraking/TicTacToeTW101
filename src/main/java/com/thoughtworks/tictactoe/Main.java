package com.thoughtworks.tictactoe;

import java.io.PrintStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Tic Tac Toe");
        PrintStream printStream = System.out;
        Board board = new Board(printStream);
        board.printBoard();
    }
}
