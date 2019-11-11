package model;


//import java.util.Arrays;

public class Board {

	private int nbCaseHorizontal;
	private int nbCaseVertical;

	private Case[][] board;

	public Board(int nbCaseHorizontal, int nbCaseVertical) {

		this.nbCaseHorizontal = nbCaseHorizontal;
		this.nbCaseVertical = nbCaseVertical;

		this.board = new Case[nbCaseHorizontal][nbCaseVertical];
		
		for (int kx = 0; kx < nbCaseHorizontal; kx++) {
			for (int ky = 0; ky < nbCaseVertical; ky++) {
				this.board[kx][ky] = new Case(new Coordonnee(kx, ky));
				this.board[kx][ky].setDecor(new Grass());
				this.board[kx][ky].setUnit(new UnitVoid());
				this.board[kx][ky].setCoordonnee(new Coordonnee(kx, ky));

			}
		}
	}
	public Case getCaseUp(Case c) {
		int x = c.getCoordonnee().getX();
		int y = c.getCoordonnee().getY();
		return this.board[x][y-1];
	}


	public Case getCaseDown(Case c) {
		int x = c.getCoordonnee().getX();
		int y = c.getCoordonnee().getY();
		return this.board[x][y+1];
	}

	public Case getCaseLeft(Case c) {
		int x = c.getCoordonnee().getX();
		int y = c.getCoordonnee().getY();
		return this.board[x-1][y];
	}

	public Case getCaseRight(Case c) {
		int x = c.getCoordonnee().getX();
		int y = c.getCoordonnee().getY();
		return this.board[x+1][y];
	}

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

