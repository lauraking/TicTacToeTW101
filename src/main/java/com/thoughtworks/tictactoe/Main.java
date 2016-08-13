package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        PrintStream printStream = System.out;
        List<String> boardState = Arrays.asList("1","2","3","4","5","6","7","8","9");
        Board board = new Board(printStream, boardState);
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Player firstPlayer = new Player(System.out,"X",board,1,reader);
        Player secondPlayer = new Player(System.out,"O",board,2,reader);
        Game game = new Game(printStream,board,reader,firstPlayer,secondPlayer);
        try {
            game.start();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
