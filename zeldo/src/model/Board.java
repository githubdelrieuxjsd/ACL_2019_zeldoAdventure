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
				this.board[kx][ky].setDecor(new DecorVoid());
				this.board[kx][ky].setUnit(new UnitVoid());

			}
		}
	}

	public void addDecor(Decor decor, Coordonnee coordonnee) {
		if (this.board[coordonnee.getX()][coordonnee.getY()].getDecor().getNom().equals("DecorVoid")) {
			this.board[coordonnee.getX()][coordonnee.getY()].setDecor(decor);
		}
	}

	public void addUnit(Unit unit) {
		if(this.board[unit.getCoordonnee().getX()][unit.getCoordonnee().getY()].getUnit().getNom().equals("UnitVoid")
				&& this.board[unit.getCoordonnee().getX()][unit.getCoordonnee().getY()].isPraticable(unit)) {
			this.board[unit.getCoordonnee().getX()][unit.getCoordonnee().getY()].setUnit(unit);
		}
	}
	
	public void addDecorRandom(Decor decor, int nombreRandom) {
		for (int i =0; i<nombreRandom; i++) {
			this.addDecor(decor, new Coordonnee(0,nbCaseHorizontal-1, 0, nbCaseVertical-1));
		}
	}
	
	public void completeGrass() {
		for(int i=0; i<this.nbCaseHorizontal; i++) {
			for(int j =0; j<this.nbCaseVertical; j++) {
				addDecor(new Grass(), new Coordonnee(i,j));
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

	public int getNbCaseHorizontal() {
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

	public Case getCaseDirection(Case c) {
		return null;
	}
	
}

