package model;

public class PrincipaleTestModel {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Grass grass = new Grass ();
		System.out.println(grass.getNom());
		
		Board board = new Board(3,6);
		 
		for (int k = 0; k<3; k++) {
			for(int j =0; j<6;j++) {
				board.getBoard()[k][j].toString();
				System.out.println();
			}
			
		}
		

	}
	
}
