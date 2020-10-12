package com.kata.tictactoe;

public class Game {
	Board gameBoard;

	public Game() {
		gameBoard = new Board();
	}

	public char getPlayerAt(final int row, final int column) {
		return gameBoard.getSymbolAt(row, column);
	}

	public String play(final int row, final int column) throws CellOccupiedException, InvalidCellRangeException {

		validateInputsToPlayFurther(row, column);

		gameBoard.drawSymbolAt(row, column);

		if (isWinner()) {
			return getCurrentPlayer() + GameResultEnum.WINS.value;
		} else if (gameBoard.isCellsFullyOccupiedBySymbols()) {
			return GameResultEnum.DRAW.value;
		}
		return GameResultEnum.CONTINUES.value;
	}

	private void validateInputsToPlayFurther(final int row, final int column)
			throws InvalidCellRangeException, CellOccupiedException {
		if (!gameBoard.isValidCellRange(row, column)) {
			throw new InvalidCellRangeException(
					"Given cell is out of range, Please select any valid cell in the range of 0 to 2");
		} else if (!gameBoard.isCellEmpty(row, column)) {
			throw new CellOccupiedException(
					"Given cell is not empty as it is already occupied by another symbol, Please select any other valid cell");
		}
	}

	boolean isWinner() {
		return gameBoard.isAnyHorizontalCellsMarkedBySameSymbol() || gameBoard.isAnyVerticalCellsMarkedBySameSymbol()
				|| gameBoard.isLeftTopToRightBottomDiagonalCellsAreMarkedBySameSymbol()
				|| gameBoard.isRightTopToLeftBottomDiagonalCellsAreMarkedBySameSymbol();
	}

	private char getCurrentPlayer() {
		return gameBoard.getCurrentSymbol();
	}
}