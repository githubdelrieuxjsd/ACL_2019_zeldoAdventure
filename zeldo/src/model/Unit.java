package model;

public abstract class Unit extends Element {

	private Coordonnee coordonnee;
	private Direction direction;
	private int life;
	private int lifeMax;

	
	public boolean isMonster() {
		boolean rslt =false;
		switch (this.getNom()) {
		case "Gobelin":
			rslt=true;
			break;
		case "Slime":
			rslt=true;
			break;
		default:
			break;
		}
		return rslt;

	}

	public Direction getDirection() {
		return this.direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}
	
	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coord) {
		this.coordonnee = coord;
	}

	public int getLifeMax() {
		return lifeMax;
	}

	public void setLifeMax(int lifeMax) {
		this.lifeMax = lifeMax;
	}

	public int getLife() {
		return lifeMax;
	}

	public void setLife(int life) {
		this.life = life;
	}

}
