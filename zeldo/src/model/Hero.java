package model;

public class Hero extends Unit implements Move {

	Coordonnee coord;

	public Hero() {
		this.setNom("Zeldo");
		this.setImageURL("Image Zeldo");
		this.coord = new Coordonnee(0,0);
	}

	public Hero(Coordonnee c) {
		this.setNom("Hero");
		this.setImageURL("Image Zeldo");
		this.coord = c;
	}

	public Coordonnee getCoordonnee() {
		return null;
	}

	public Coordonnee getCoord() {
		return coord;
	}

	public void setCoord(Coordonnee coord) {
		this.coord = coord;
	}

	public void move(Board board, Case nextCase) {
		board.getBoard()[this.getCoord().getX()][this.getCoord().getY()].setUnit(new UnitVoid());
		this.setCoord(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()]
				.setUnit(new Hero(nextCase.getCoordonnee()));

	}
}
