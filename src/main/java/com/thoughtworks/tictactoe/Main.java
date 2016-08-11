package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Tic Tac Toe");
        PrintStream printStream = System.out;
        List<String> boardState = Arrays.asList("1","2","3","4","5","6","7","8","9");
        Board board = new Board(printStream, boardState);
        board.printBoard();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Game game = new Game(printStream,board,reader);
        try {
            game.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
