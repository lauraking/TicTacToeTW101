package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private PrintStream printStream;
    private Game game;
    private BufferedReader reader;
    private Player firstPlayer;
    private Player secondPlayer;
    private Referee referee;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        referee = mock(Referee.class);
        game = new Game(printStream, board, reader, firstPlayer, secondPlayer, referee);
    }

    @Test
    public void playerOneShouldMove() throws Exception {
        game.start();
        verify(firstPlayer).move();

    }

    @Test
    public void playerTwoShouldMove() throws Exception {
        game.start();
        verify(secondPlayer).move();
    }

    @Test
    public void shouldEndWhenBoardIsFullFirstRound() throws IOException {
        when(board.isFull()).thenReturn(true);
        game.start();
        verify(firstPlayer,never()).move();
    }

    @Test
    public void shouldEndWhenBoardIsFull() throws IOException {
        when(board.isFull()).thenReturn(false,false,true);
        game.start();
        verify(firstPlayer,times(1)).move();
        verify(secondPlayer,times(1)).move();
    }

    @Test
    public void shouldEndWhenPlayerHasThreeInAHorizontalRow() throws IOException {
        when(board.isFull()).thenReturn(false,false,false);
        when(board.isHorizontalWin()).thenReturn(false,true);
        game.start();
        verify(firstPlayer,times(1)).move();
        verify(secondPlayer,never()).move();
    }

    @Test
    public void shouldEndWhenSecondPlayerHasThreeInAHorizontalRow() throws IOException {
        when(board.isFull()).thenReturn(false, false, false);
        when(board.isHorizontalWin()).thenReturn(false, false, true);
        game.start();
        verify(firstPlayer, times(1)).move();
        verify(secondPlayer, times(1)).move();
    }

    @Test
    public void shouldAskRefereeAfterMoveTo() throws IOException {
        Referee referee = mock(Referee.class);
        when(referee.isOver(any(Player.class))).thenReturn(true);
        game.start();
        verify(firstPlayer, never()).move();
    }


}