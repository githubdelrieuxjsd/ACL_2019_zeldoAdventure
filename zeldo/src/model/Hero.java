package model;

public class Hero extends Unit implements Move {

	Coordonnee coordonnee;

	public Hero() {
		this.setNom("Zeldo");
		this.setImageURL("Image Zeldo");
		this.coordonnee = new Coordonnee(0,0);
	}

	public Hero(Coordonnee c) {
		this.setNom("Hero");
		this.setImageURL("hyrule/link/beat/D1.png");
		this.coordonnee = c;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	
	public void setCoordonnee(Coordonnee coord) {
		this.coordonnee = coord;
	}

	public void move(Board board, Case nextCase) {
		board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
		this.setCoordonnee(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()]
				.setUnit(new Hero(nextCase.getCoordonnee()));

	}
}
