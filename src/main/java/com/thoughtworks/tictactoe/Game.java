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
    private Referee referee;


    public Game(PrintStream printStream, Board board, BufferedReader reader, Player firstPlayer, Player secondPlayer, Referee referee) {
        this.printStream = printStream;
        this.board = board;
        this.reader = reader;
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.referee = referee;
    }


    public void start() throws IOException {
        printStream.println("Hello Tic Tac Toe");
        board.printBoard();
        currentPlayer = secondPlayer;
        boolean isOver = board.isFull() | board.isHorizontalWin();
        boolean isOverReferee = referee.isOver(currentPlayer);

        while(!isOverReferee) {
            switchPlayers();
            currentPlayer.move();
            board.printBoard();
            isOver = board.isFull() | board.isHorizontalWin();
            isOverReferee = referee.isOver(currentPlayer);
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
