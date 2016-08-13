package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class PlayerTest {

    private BufferedReader reader;
    private PrintStream printStream;
    private Board board;


    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);

    }

    @Test
    public void shouldPromptPlayerToSelectAMoveLocation() throws Exception {
        Player player = new Player(printStream,"X", board,1,reader);
        when(reader.readLine()).thenReturn("1","2");
        when(board.isCellAvailable(1)).thenReturn(true);
        player.move();
        verify(printStream).println("Player 1: Please Select Your Move\n>");

    }

    @Test
    public void shouldUpdateBoardWithValidMoveAfterInvalildMove() throws Exception {
        Player player = new Player(printStream,"X", board,1,reader);
        when(reader.readLine()).thenReturn("1","2");
        when(board.isCellAvailable(1)).thenReturn(false);
        when(board.isCellAvailable(2)).thenReturn(true);
        player.move();
        verify(board).update(2,"X");

    }

    @Test
    public void shouldUpdateBoardWithValidMove() throws Exception {
        Player player = new Player(printStream,"X", board,1,reader);
        when(reader.readLine()).thenReturn("1","2");
        when(board.isCellAvailable(1)).thenReturn(true);
        player.move();
        verify(board).update(1,"X");

    }
}