package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.contains;
import static org.mockito.Mockito.*;

public class GameTest {

    private Board board;
    private PrintStream printStream;
    private Game game;
    private BufferedReader reader;
    private Player firstPlayer;
    private Player secondPlayer;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        printStream = mock(PrintStream.class);
        reader = mock(BufferedReader.class);
        firstPlayer = mock(Player.class);
        secondPlayer = mock(Player.class);
        game = new Game(printStream, board, reader, firstPlayer, secondPlayer);
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
    

    //    @Test
//    public void shouldPromptFirstUserToSelectMoveLocationWhenGameStarts() throws Exception {
//        game.start();
//        verify(printStream).println(contains("Player 1: Select your move\n>"));
//    }
//
//    @Test
//    public void shouldCallMoveOnBoardWhenUserEntersNumber() throws Exception {
//        when(reader.readLine()).thenReturn("1");
//        game.start();
//        verify(board).update(1, "X");
//
//    }
//
//    @Test
//    public void shouldCallMoveOnBoardWhenSecondUserEntersNumber() throws Exception {
//        when(reader.readLine()).thenReturn("1","2");
//        game.start();
//        verify(board).update(1, "X");
//        verify(board).update(2, "O");
//
//    }

//    @Test
//    public void shouldEnterTwoMovesIfFirstSquareTaken() throws IOException {
//        when(board.enterMove(any(Integer.class),any(String.class))).thenReturn(false,true);
//        when(reader.readLine()).thenReturn("1","2");
//        game.movePlayer(1,"X");
//        verify(board,times(2)).enterMove(any(Integer.class),any(String.class));
//    }
//
//    @Test
//    public void shouldEnterOneMoveIfFirstSquareFrees() throws IOException {
//        when(board.enterMove(any(Integer.class),any(String.class))).thenReturn(true);
//        when(reader.readLine()).thenReturn("2");
//        game.movePlayer(1,"X");
//        verify(board,times(1)).enterMove(any(Integer.class),any(String.class));
//    }


}