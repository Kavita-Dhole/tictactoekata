package com.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.kata.tictactoe.Board;

public class BoardTest {

	private static final int THREE = 3;
	private static final char SYMBOL_O = 'O';
	private static final int ONE = 1;
	private static final int TWO = 2;
	private static final char SYMBOL_X = 'X';
	private static final int ZERO = 0;

	private Board board;

	@Before
	public void init() {
		board = new Board();
	}

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyCell() {

		board.drawSymbolAt(ZERO, ZERO);

		assertThat(board.getSymbolAt(ZERO, ZERO), CoreMatchers.is(SYMBOL_X));
	}

	@Test
	public void symbolsShouldGetChangeAlternatively() {

		board.drawSymbolAt(ZERO, ZERO);

		assertThat(board.getCurrentSymbol(), CoreMatchers.is(SYMBOL_X));

		board.drawSymbolAt(ONE, ONE);

		assertThat(board.getCurrentSymbol(), CoreMatchers.is(SYMBOL_O));
	}

	@Test
	public void shouldReturnTrueWhenInputCellValuesAreInValidRange() {

		assertThat(board.isValidCellRange(ZERO, ONE), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnFalseWhenInputCellValuesAreNotInValidRange() {

		assertThat(board.isValidCellRange(THREE, ONE), CoreMatchers.is(false));

	}
	
	@Test
	public void shouldValidateWhetherAnyHorizontalCellValuesAreMarkedBySameSymbol() {

		board.drawSymbolAt(ZERO, ZERO);
		board.drawSymbolAt(TWO, ONE);
		board.drawSymbolAt(ZERO, ONE);
		board.drawSymbolAt(ONE, TWO);
		board.drawSymbolAt(ZERO, TWO);
		
		assertThat(board.isAnyHorizontalCellsMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldValidateWhetherAnyVerticalCellsAreMarkedBySameSymbol() {

		board.drawSymbolAt(ZERO, ZERO);
		board.drawSymbolAt(TWO, TWO);
		board.drawSymbolAt(ONE, ZERO);
		board.drawSymbolAt(ONE, TWO);
		board.drawSymbolAt(TWO, ZERO);
		
		assertThat(board.isAnyVerticalCellsMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnTrueWhenLeftTopToRightBottomDiagonalCellsAreMarkedBySameSymbol() {

		board.drawSymbolAt(ZERO, ONE);
		board.drawSymbolAt(ZERO, ZERO);
		board.drawSymbolAt(ONE, TWO);
		board.drawSymbolAt(ONE, ONE);
		board.drawSymbolAt(TWO, ONE);
		board.drawSymbolAt(TWO, TWO);
		
		assertThat(board.isLeftTopToRightBottomDiagonalCellsAreMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnTrueWhenRightTopToLeftBottomDiagonalElementsAreMarkedBySameSymbol() {

		board.drawSymbolAt(ZERO, TWO);
		board.drawSymbolAt(ZERO, ZERO);
		board.drawSymbolAt(ONE, ONE);
		board.drawSymbolAt(ONE, TWO);
		board.drawSymbolAt(TWO, ZERO);
		
		assertThat(board.isRightTopToLeftBottomDiagonalCellsAreMarkedBySameSymbol(), CoreMatchers.is(true));

	}
	
	@Test
	public void shouldReturnTrueWhenAllTheCellsAreMarkedInABoard() {
		
		board.drawSymbolAt(ONE, ONE);
		board.drawSymbolAt(ZERO, TWO);
		board.drawSymbolAt(ONE, TWO);
		board.drawSymbolAt(ONE, ZERO);
		board.drawSymbolAt(ZERO, ZERO);
		board.drawSymbolAt(TWO, TWO);
		board.drawSymbolAt(TWO, ONE);
		board.drawSymbolAt(ZERO, ONE);
		board.drawSymbolAt(TWO, ZERO);
		
		assertThat(board.isCellsFullyOccupiedBySymbols(), CoreMatchers.is(true));
	}
	
	@Test
	public void shouldBeAbleToPrintTheGameBoardAfterPlayerMoves(){
		
		board.drawSymbolAt(ONE, ONE);
		board.drawSymbolAt(ZERO, TWO);
		board.drawSymbolAt(ONE, TWO);
		
		board.printBoard();
	}
}
