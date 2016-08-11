package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;

import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class GameTest {

    private Board board;
    private PrintStream printStream;
    private Game game;
    private BufferedReader reader;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        game = new Game(printStream, board, reader);
    }

    @Test
    public void shouldPromptFirstUserToSelectMoveLocationWhenGameStarts() throws Exception {
        game.start();
        verify(printStream).println(contains("Player 1: Select your move\n>"));
    }

    @Test
    public void shouldCallMoveOnBoardWhenUserEntersNumber() throws Exception {
        when(reader.readLine()).thenReturn("1");
        game.start();
        verify(board).update("1", "X");

    }
}