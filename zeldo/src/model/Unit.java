package model;

public abstract class Unit extends Element {
	private Coordonnee coordonnee;
	private Direction direction;
	
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	
	public void setCoordonnee(Coordonnee coord) {
		this.coordonnee = coord;
	}


	protected abstract void perdreVie();

}
