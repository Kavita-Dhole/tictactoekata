package com.kata.tictactoe;

public enum GameResultEnum {
	WINS(" is the Winner!"), CONTINUES(" Game Continues"), DRAW("Game is Draw");

	public final String value;

	private GameResultEnum(String value) {
		this.value = value;
	}

}