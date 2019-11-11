package model;

public class Coordonnee {

	private int x;
	private int y;
	
	// contructeur int x , int y 
		public Coordonnee(int x, int y){
			this.x=x;
			this.y=y;
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


	@Override
	public String toString() {
		return "Coordonnee [x=" + x + ", y=" + y + "]";
	}




}
