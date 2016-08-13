package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

public class Game {
    private PrintStream printStream;
    private Board board;
    private Player secondPlayer;
    private Player firstPlayer;
    private BufferedReader reader;


    public Game(PrintStream printStream, Board board, BufferedReader reader, Player firstPlayer, Player secondPlayer) {
        this.printStream = printStream;
        this.board = board;
        this.reader = reader;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }


    public void start() throws IOException {
        printStream.println("Hello Tic Tac Toe");
        board.printBoard();
        firstPlayer.move();
        board.printBoard();
        secondPlayer.move();
        board.printBoard();

    }

}
