package com.kata.tictactoe;

public class InvalidCellRangeException extends Exception{

	private static final long serialVersionUID = 911638379698525138L;

	private String errorMessage;

	public InvalidCellRangeException(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	@Override
	public String toString() {
		return errorMessage;

	}
}
