package model;

public class Coordonnee {
	
	private int x;
	private int y;
	
	public Coordonnee(){
		this.x=-1;
		this.y=-1;
	}
	
	private int[] getCoordonee() {
		int[] result = {this.x , this.y};
		return result;
	}

	private int getX() {
		return x;
	}


	private int getY() {
		return y;
	}

	

}
