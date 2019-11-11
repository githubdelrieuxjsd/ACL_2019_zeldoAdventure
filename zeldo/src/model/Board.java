package model;

import java.util.Arrays;

public class Board {
	
	private int nbCaseHorizontaly;
	private int nbCaseVerticaly;
	
	private Case[][] board;
	
	public Board(int nbCaseHorizontaly, int nbCaseVerticaly) {
		this.nbCaseHorizontaly = nbCaseHorizontaly ;
		this.nbCaseVerticaly = nbCaseVerticaly ;
		this.board = new Case[nbCaseHorizontaly][nbCaseVerticaly];
		for (int kx=0; kx<nbCaseHorizontaly; kx++) {
			for (int ky=0; ky<nbCaseVerticaly; ky++) {
				this.board[kx][ky]= new Case(new Coordonnee(kx,ky));
				this.board[kx][ky].setDecors(new Grass());
				this.board[kx][ky].setUnit(new UnitVoid());
				this.board[kx][ky].setCoordonnee(new Coordonnee(kx,ky));
			}
		}
	}
	
	
	// GETCASEUP / DOWN 
	/*
	public Case getCaseUp(Case c){
		
		
	}
*/
	public int getNbCaseHorizontaly() {
		return nbCaseHorizontaly;
	}

	public void setNbCaseHorizontaly(int nbCaseHorizontaly) {
		this.nbCaseHorizontaly = nbCaseHorizontaly;
	}

	public int getNbCaseVerticaly() {
		return nbCaseVerticaly;
	}

	public void setNbCaseVerticaly(int nbCaseVerticaly) {
		this.nbCaseVerticaly = nbCaseVerticaly;
	}

	public Case[][] getBoard() {
		return board;
	}

	public void setBoard(Case[][] board) {
		this.board = board;
	}


	@Override
	public String toString() {
		return "Board [nbCaseHorizontaly=" + nbCaseHorizontaly + ", nbCaseVerticaly=" + nbCaseVerticaly + ", board="
				+ Arrays.toString(board) + "]";
	}
	
	
	
	

}
