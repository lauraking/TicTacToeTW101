package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private PrintStream printStream;
    private List<String> boardState;


    public Board(PrintStream printStream, List<String> boardState) {
        this.printStream = printStream;
        this.boardState = boardState;

    }


    public void printBoard() {

        String boardString = createBoardString();
        printStream.println(boardString);
    }


    private String createBoardString() {
        String formatter = "%s|%s|%s\n-----\n%s|%s|%s\n-----\n%s|%s|%s";
        String boardString = String.format(formatter,boardState.toArray());
        return boardString;
    }


    public void update(int location, String userShape) {
        boardState.set(location-1,userShape);
    }


    public boolean isCellAvailable(int location) {
        String boardValue = (boardState.get(location - 1));
        String locationString = String.valueOf(location);
        boolean isAvailable = boardValue.equals(locationString);
        return isAvailable;

    }

    public boolean isFull() {
        for (int i = 1; i<=boardState.size(); i++) {
            if (isCellAvailable(i)) return false;
        }
        return true;
    }

    public boolean isHorizontalWin() {
       for (int i = 1; i <=3; i++) {
           if (isWinForRow(i)) return true;
       }
        return false;
    }

    private boolean isWinForRow(int row) {
        int startIndex = 3*(row-1);
        String leftMost = boardState.get(startIndex);
        boolean rowIsSame = boardState.get(startIndex + 1).equals(leftMost) && boardState.get(startIndex + 2).equals(leftMost);
        return rowIsSame;
    }
}
