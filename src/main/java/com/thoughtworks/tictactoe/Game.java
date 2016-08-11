package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class Game {
    private final PrintStream printStream;
    private final Board board;
    private BufferedReader reader;

    public Game(PrintStream printStream, Board board, BufferedReader reader) {
        this.printStream = printStream;
        this.board = board;
        this.reader = reader;
    }


    public void start() throws IOException {

        promptUserMove(1,"X");
        promptUserMove(2, "O");

    }

    private void promptUserMove(int player, String userShape) throws IOException {
        printStream.println("Player "+player+": Select your move\n>");
        String moveLocation = reader.readLine();
        board.update(moveLocation,userShape);
        board.printBoard();
    }
}
