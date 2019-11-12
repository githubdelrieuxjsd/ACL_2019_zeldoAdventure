package model;

public abstract class Unit extends Element {
	private Coordonnee coordonnee;
	
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	
	public void setCoordonnee(Coordonnee coord) {
		this.coordonnee = coord;
	}

}
