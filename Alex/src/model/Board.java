package model;

public class Board {
	
	private int nbCaseHorizontaly;
	private int nbCaseVerticaly;
	
	private Case[][] board;
	
	public Board(int nbCaseHorizontaly, int nbCaseVerticaly) {
		this.nbCaseHorizontaly = nbCaseHorizontaly ;
		this.nbCaseVerticaly = nbCaseVerticaly ;
		this.board = new Case[nbCaseHorizontaly][nbCaseVerticaly];
		for (Case[] listCase : this.board) {
			for (Case c : listCase) {
				c.setDecors(new Grass());
				c.setUnit(new UnitVoid());
				
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
	
	

}
