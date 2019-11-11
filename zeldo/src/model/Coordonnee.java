package model;

public class Coordonnee {

	private int x;
	private int y;

	// contructeur int x , int y
	public Coordonnee() {
		this.x = -1;
		this.y = -1;
	}

	public Coordonnee(int x, int y) {
		this.x = x;
		this.y = y;
	}

	private int[] getCoordonnee() {
		int[] result = { this.x, this.y };
		return result;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
