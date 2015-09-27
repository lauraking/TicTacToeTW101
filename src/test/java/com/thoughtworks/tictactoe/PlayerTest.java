package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private static final String A_STRING = "AnyString";
    private static final String A_DIFFERENT_STRING = "ADifferentString";
    private BufferedReader bufferedReader;
    private Board board;
    private Player player;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        bufferedReader = mock(BufferedReader.class);
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        player = new Player(bufferedReader, board, printStream);
    }

    @Test
    public void shouldUpdateBoardWhenEnteringMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn(A_STRING);

        player.move();

        verify(board).update(A_STRING);
    }

    @Test
    public void shouldUpdateBoardWhenEnteringADifferentMove() throws IOException {
        when(bufferedReader.readLine()).thenReturn(A_DIFFERENT_STRING);

        player.move();

        verify(board).update(A_DIFFERENT_STRING);
    }

    @Test
    public void shouldPromptPlayerWhenMoving() {
        player.move();

        verify(printStream).println("Make a move dummy");
    }


}