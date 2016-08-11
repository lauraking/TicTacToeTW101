package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private List<String> boardState;


    public Board(PrintStream printStream, List<String> boardState) {
        this.printStream = printStream;
        this.boardState = boardState;

    }


    public void printBoard() {
        String firstLine = createRowString(1);
        String secondLine = createRowString(2);
        String thirdLine = createRowString(3);
        String dashNewLines = "\n-----\n";
        printStream.println(firstLine+dashNewLines+secondLine+dashNewLines+thirdLine);
    }


    private String createRowString(int i){
        int index = 3*(i-1);
        String returnString = boardState.get(index) + "|" + boardState.get(index+1) + "|" + boardState.get(index+2);
        return returnString;
    }



    public void update(String moveLocation, String userShape) {
        Integer location = Integer.parseInt(moveLocation);
        boardState.set(location-1,userShape);
    }
}
