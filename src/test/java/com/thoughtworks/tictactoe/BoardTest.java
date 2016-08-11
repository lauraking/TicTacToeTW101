package com.thoughtworks.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.*;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {
    @Test
    public void shouldInitialLine() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        board.printBoard();
        verify(printStream).println(contains("1|2|3\n-----\n4|5|6\n-----\n7|8|9"));
    }

}