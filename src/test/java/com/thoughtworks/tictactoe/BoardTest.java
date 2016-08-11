package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BoardTest {

    private PrintStream printStream;
    private Board board;
    private List<String> boardState;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        boardState = Arrays.asList("1","2","3","4","5","6","7","8","9");
        board = new Board(printStream, boardState);
    }

    @Test
    public void shouldInitialLine() {
        board.printBoard();
        verify(printStream).println(contains("1|2|3\n-----\n4|5|6\n-----\n7|8|9"));
    }

    @Test
    public void shouldUpdate1ValueToXWhenUpdateCalledWith1X() throws Exception {
        boardState = Arrays.asList("X","2","3","4","5","6","7","8","9");
        board = new Board(printStream, boardState);
        board.printBoard();
        verify(printStream).println(contains("X|2|3\n-----\n4|5|6\n-----\n7|8|9"));

    }

    @Test
    public void shouldUpdatePrintArrayWithDifferentCharacters() throws Exception {
        boardState = Arrays.asList("X","2","3","x","5","6","c","8","9");
        board = new Board(printStream, boardState);
        board.printBoard();
        verify(printStream).println(contains("X|2|3\n-----\nx|5|6\n-----\nc|8|9"));

    }

    @Test
    public void shouldUpdate4ValueToXWhenUpdateCalledWith4X() throws Exception {
        board.update(4,"X");
        assertThat(boardState.get(3),is("X"));
    }




}