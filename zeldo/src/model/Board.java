package model;


import java.util.Arrays;

public class Board {

	private int nbCaseHorizontal;
	private int nbCaseVertical;

	private Case[][] board;

	public Board(int nbCaseHorizontal, int nbCaseVertical) {
		this.nbCaseHorizontal = nbCaseHorizontal;
		this.nbCaseVertical = nbCaseVertical;
		this.board = new Case[nbCaseHorizontal][nbCaseVertical];
		for (Case[] listCase : this.board) {
			for (Case c : listCase) {
				c.setDecor(new Grass());
				c.setUnit(new UnitVoid());
			}
		}
	}

	/*
	public Case getCaseUp(Case c) {

	}
	*/

	int getNbCaseHorizontal() {
		return nbCaseHorizontal;
	}

	public void setNbCaseHorizontal(int nbCaseHorizontal) {
		this.nbCaseHorizontal = nbCaseHorizontal;
	}

	public int getNbCaseVertical() {
		return nbCaseVertical;
	}

	public void setNbCaseVertical(int nbCaseVertical) {
		this.nbCaseVertical = nbCaseVertical;
	}

	public Case[][] getBoard() {
		return board;
	}

	public void setBoard(Case[][] board) {
		this.board = board;
	}

	@Override
	public String toString() {
		String res = new String();
		for (int k = 0; k < this.nbCaseHorizontal; k++) {
			for (int j = 0; j < this.nbCaseVertical; j++) {
				res = res + this.board[k][j].toString();
				System.out.println();
			}
		}
		return res;
	}
}

