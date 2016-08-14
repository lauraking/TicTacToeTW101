package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {
    private PrintStream printStream;
    private Board board;
    private Player secondPlayer;
    private Player firstPlayer;
    private BufferedReader reader;
    private Player currentPlayer;


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
        currentPlayer = firstPlayer;
        boolean isOver = board.isFull() | board.isHorizontalWin();

        while(!isOver) {
            currentPlayer.move();
            board.printBoard();
            isOver = board.isFull() | board.isHorizontalWin();
            switchPlayers();
        }

    }

    private void switchPlayers() {
        if (currentPlayer.equals(firstPlayer)) {
            currentPlayer = secondPlayer;
        } else {
            currentPlayer = firstPlayer;
        }
    }

}
