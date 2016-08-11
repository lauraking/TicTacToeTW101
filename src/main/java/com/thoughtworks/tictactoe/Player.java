package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static sun.audio.AudioPlayer.player;

public class Player {

    private PrintStream printStream;
    private String playerShape;
    private Board board;
    private int playerNumber;
    private BufferedReader reader;

    public Player(PrintStream printStream, String playerShape, Board board, int playerNumber, BufferedReader reader) {

        this.printStream = printStream;
        this.playerShape = playerShape;
        this.board = board;
        this.playerNumber = playerNumber;
        this.reader = reader;
    }


    public void move() throws IOException {

    }

}
