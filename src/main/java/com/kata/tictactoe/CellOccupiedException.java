package com.kata.tictactoe;

public class CellOccupiedException extends Exception {

	private static final long serialVersionUID = 1582625567260101798L;
	private String errorMessage;

	public CellOccupiedException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;
	}
}
