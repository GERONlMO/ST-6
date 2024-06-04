package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class AppTest {
    private Game game;
    private Player player1, player2;
    private TicTacToeCell cell;

    @BeforeEach
    public void setUp() {
        game = new Game();
        player1 = new Player();
        player2 = new Player();
        player1.symbol = 'X';
        player2.symbol = 'O';
        cell = new TicTacToeCell(0, 0, 0);
    }

    // Tests for Game class
    @Test
    public void testCheckStatePlaying() {
        assertEquals(State.PLAYING, game.checkState(game.board));
    }

    @Test
    public void testCheckStateXWin() {
        game.board = new char[] {'X', 'X', 'X', ' ', ' ', ' ', ' ', ' ', ' '};
        game.symbol = 'X';  // Добавляем символ для проверки
        assertEquals(State.XWIN, game.checkState(game.board));
    }

    @Test
    public void testCheckStateOWin() {
        game.board = new char[] {'O', 'O', 'O', ' ', ' ', ' ', ' ', ' ', ' '};
        game.symbol = 'O';  // Добавляем символ для проверки
        assertEquals(State.OWIN, game.checkState(game.board));
    }

    @Test
    public void testCheckStateDraw() {
        game.board = new char[] {'X', 'O', 'X', 'O', 'X', 'O', 'O', 'X', 'O'};
        assertEquals(State.DRAW, game.checkState(game.board));
    }

    @Test
    public void testGenerateMoves() {
        ArrayList<Integer> moveList = new ArrayList<>();
        game.generateMoves(game.board, moveList);
        assertEquals(9, moveList.size());
    }

    @Test
    public void testMiniMax() {
        game.board = new char[] {'X', 'O', 'X', 'O', 'X', ' ', ' ', ' ', 'O'};
        assertTrue(game.MiniMax(game.board, player2) >= 0);
    }

    @Test
    public void testMinMove() {
        game.board = new char[] {'X', 'O', 'X', 'O', 'X', ' ', ' ', ' ', 'O'};
        assertTrue(game.MinMove(game.board, player2) <= Game.INF);
    }

    @Test
    public void testMaxMove() {
        game.board = new char[] {'X', 'O', 'X', 'O', 'X', ' ', ' ', ' ', 'O'};
        assertTrue(game.MaxMove(game.board, player2) >= -Game.INF);
    }

    // Tests for Player class
    @Test
    public void testPlayerInitialization() {
        assertNotNull(player1);
        assertFalse(player1.selected);
        assertFalse(player1.win);
    }

    // Tests for TicTacToeCell class
    @Test
    public void testInitialMarker() {
        assertEquals(' ', cell.getMarker());
    }

    @Test
    public void testSetMarker() {
        cell.setMarker("X");
        assertEquals('X', cell.getMarker());
    }

    @Test
    public void testGetRow() {
        assertEquals(0, cell.getRow());
    }

    @Test
    public void testGetCol() {
        assertEquals(0, cell.getCol());
    }

    @Test
    public void testGetNum() {
        assertEquals(0, cell.getNum());
    }

}

