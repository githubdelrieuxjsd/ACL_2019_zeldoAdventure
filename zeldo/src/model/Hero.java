package model;


public class Hero extends Unit implements Move{

	Coordonnees coord;


	public Hero(Coordonnees c) {
		this.setNom("Hero");
		this.setImageURL("Image Zeldo");
		this.coord = c;
	}



	public Coordonnees getCoord() {
		return coord;
	}



	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}



	public void move(Board board, Case nextCase) {
		board.getBoard()[this.getCoord().getX()][this.getCoord().getY()].setUnit(new UnitVoid());
		this.setCoord(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()].setUnit(new Hero(nextCase.getCoordonnee()));

	}



}
