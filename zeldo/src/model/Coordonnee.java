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
	
	public  Coordonnee(int minX, int maxX, int minY, int maxY) {
		int x = minX + (int)(Math.random()*((maxX-minX)+1));
		int y = minY + (int)(Math.random()*((maxY-minY)+1));
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
