package com.kata.tictactoe;

import java.util.logging.Logger;

public class Board {

	private final static Logger LOGGER = Logger.getLogger(Board.class.getName());
	private static final int BOARD_MAX_BOUND = 9;
	private static final char EMPTY = '\0';
	private static final int ZERO = 0;
	private static final int TWO = 2;
	private static final char SYMBOL_O = 'O';
	private static final char SYMBOL_X = 'X';
	private static final int THREE = 3;
	private static final int ONE = 1;
	private char[][] cells;
	private char currentSymbol;
	private int noOfCellsFilled = 0;

	public Board() {
		cells = new char[THREE][THREE];
	}

	public char getSymbolAt(final int row, final int column) {
		return cells[row][column];
	}

	public void drawSymbolAt(final int row, final int column) {
		currentSymbol = getNextSymbol();
		cells[row][column] = currentSymbol;
		noOfCellsFilled++;
	}

	char getNextSymbol() {
		return SYMBOL_X == currentSymbol ? SYMBOL_O : SYMBOL_X;
	}

	public char getCurrentSymbol() {
		return currentSymbol;
	}

	public boolean isCellEmpty(int row, int column) {
		return cells[row][column] == EMPTY;
	}

	public boolean isValidCellRange(int row, int column) {
		if (row > TWO || row < ZERO || column > TWO || column < ZERO) {
			return false;
		}
		return true;
	}

	public boolean isAnyHorizontalCellsMarkedBySameSymbol() {
		for (int row = ZERO; row <= TWO; row++) {
			if (isCellContentsAreEqual(cells[row][ZERO], cells[row][ONE], cells[row][TWO])) {
				return true;
			}
		}
		return false;
	}

	public boolean isAnyVerticalCellsMarkedBySameSymbol() {
		for (int column = ZERO; column <= TWO; column++) {
			if (isCellContentsAreEqual(cells[ZERO][column], cells[ONE][column], cells[TWO][column])) {
				return true;
			}
		}
		return false;
	}

	public boolean isLeftTopToRightBottomDiagonalCellsAreMarkedBySameSymbol() {

		boolean isLeftDiagonalElementsAreEqual = true;
		int cellContentToCompare = cells[ZERO][ZERO];
		for (int row = ZERO; row < THREE; row++) {
			if (cells[row][row] != cellContentToCompare || cellContentToCompare == EMPTY) {
				isLeftDiagonalElementsAreEqual = false;
				break;
			}
		}
		return isLeftDiagonalElementsAreEqual;
	}

	public boolean isRightTopToLeftBottomDiagonalCellsAreMarkedBySameSymbol() {
		boolean isRightDiagonalElementsAreEqual = true;
		int length = cells.length;
		int cellContentToCompare = cells[ZERO][length - ONE];
		for (int row = 0, column = length - ONE; row < length; row++, column--) {
			if (cells[row][column] != cellContentToCompare || cellContentToCompare == EMPTY) {
				isRightDiagonalElementsAreEqual = false;
				break;
			}
		}
		return isRightDiagonalElementsAreEqual;
	}

	public Boolean isCellsFullyOccupiedBySymbols() {
		return noOfCellsFilled == BOARD_MAX_BOUND;
	}

	private boolean isCellContentsAreEqual(char cellContentInputOne, char cellContentInputTwo,
			char cellContentInputThree) {
		return ((cellContentInputOne != EMPTY) && (cellContentInputOne == cellContentInputTwo)
				&& (cellContentInputTwo == cellContentInputThree));
	}

	public void printBoard() {
		StringBuffer boardPrinter = new StringBuffer();
		boardPrinter.append("\n-------------\n");

		for (int row = ZERO; row < THREE; row++) {
			boardPrinter.append("| ");
			for (int column = ZERO; column < THREE; column++) {
				boardPrinter.append(cells[row][column] + " | ");
			}
			boardPrinter.append("\n");
			boardPrinter.append("-------------\n");
		}

		LOGGER.info(boardPrinter.toString());
	}

}
