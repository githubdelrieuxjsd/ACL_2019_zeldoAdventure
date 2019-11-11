package model;

public class Coordonnees {

	private int x;
	private int y;

	// contructeur int x , int y
	public Coordonnees() {
		this.x = -1;
		this.y = -1;
	}

	private int[] getCoordonees() {
		int[] result = { this.x, this.y };
		return result;
	}

	private int getX() {
		return x;
	}

	private int getY() {
		return y;
	}

}
