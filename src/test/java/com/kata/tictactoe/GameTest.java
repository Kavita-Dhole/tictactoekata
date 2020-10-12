package com.kata.tictactoe;

import static org.junit.Assert.assertThat;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import com.kata.tictactoe.CellOccupiedException;
import com.kata.tictactoe.GameResultEnum;
import com.kata.tictactoe.InvalidCellRangeException;
import com.kata.tictactoe.Game;

public class GameTest {

	private static final char PLAYER_O = 'O';
	private static final int THREE = 3;
	private static final char PLAYER_X = 'X';
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final int ONE = 1;

	Game game;

	@Before
	public void init() {
		game = new Game();
	}

	@Test
	public void playerOneShouldBeAbleToPlaceXInAnyCell()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ZERO, ZERO);

		assertThat(game.getPlayerAt(ZERO, ZERO), CoreMatchers.is(PLAYER_X));
	}

	@Test(expected = CellOccupiedException.class)
	public void shouldThroughExceptionWhenPlayerTryToFillInNonEmptyCell()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ZERO, ZERO);
		game.play(ZERO, ZERO);
	}

	@Test(expected = InvalidCellRangeException.class)
	public void shouldThroughExceptionWhenPlayerTryToFillInACellOutOfRange()
			throws InvalidCellRangeException, CellOccupiedException {

		game.play(ZERO, ZERO);
		game.play(THREE, THREE);
	}

	@Test
	public void shouldDeclareWinnerWhenAnyOfTheHorizontalRowsAreMarkedBySamePlayer()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ZERO, ZERO);
		game.play(TWO, ONE);
		game.play(ZERO, ONE);
		game.play(ONE, TWO);

		assertThat(game.play(ZERO, TWO), CoreMatchers.is(PLAYER_X + " is the Winner!"));

	}

	@Test
	public void shouldDeclareWinnerWhenAnyOfTheVerticalColumnsAreMarkedBySamePlayer()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ZERO, ZERO);
		game.play(TWO, TWO);
		game.play(ONE, ZERO);
		game.play(ONE, TWO);

		assertThat(game.play(TWO, ZERO), CoreMatchers.is(PLAYER_X + GameResultEnum.WINS.value));

	}

	@Test
	public void shouldDeclareWinnerWhenLeftTopToRightBottomDiagonalCellsAreMarkedBySamePlayer()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ZERO, ONE);
		game.play(ZERO, ZERO);
		game.play(ONE, TWO);
		game.play(ONE, ONE);
		game.play(TWO, ONE);

		assertThat(game.play(TWO, TWO), CoreMatchers.is(PLAYER_O + GameResultEnum.WINS.value));

	}

	@Test
	public void shouldDeclareWinnerWhenRightToptToLeftBottomDiagonalCellsAreMarkedBySamePlayer()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ZERO, TWO);
		game.play(ZERO, ZERO);
		game.play(ONE, ONE);
		game.play(ONE, TWO);

		assertThat(game.play(TWO, ZERO), CoreMatchers.is(PLAYER_X + GameResultEnum.WINS.value));

	}

	@Test
	public void shouldDeclareGameIsDrawWhenAllTheCellsAreMarkedByPlayers()
			throws CellOccupiedException, InvalidCellRangeException {

		game.play(ONE, ONE);
		game.play(ZERO, TWO);
		game.play(ONE, TWO);
		game.play(ONE, ZERO);
		game.play(ZERO, ZERO);
		game.play(TWO, TWO);
		game.play(TWO, ONE);
		game.play(ZERO, ONE);

		assertThat(game.play(TWO, ZERO), CoreMatchers.is(GameResultEnum.DRAW.value));

	}
}
