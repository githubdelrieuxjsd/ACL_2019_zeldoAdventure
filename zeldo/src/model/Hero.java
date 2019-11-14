package model;

public class Hero extends Unit implements Move {

	
	public Hero(Coordonnee c) {
		this.setNom("Hero");
		this.setImageURL("hyrule/link/beat/D1.png");
		this.setCoordonnee(c);
		// setDirection et vie
		
	}

	

	public void move(Board board, Case nextCase) {
		board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
		this.setCoordonnee(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()]
				.setUnit(new Hero(nextCase.getCoordonnee()));
	}
	
	public void attack(Board board, Direction direction) {
		switch (direction.getDirection()) {
		case "up":
			if(!(this.getCoordonnee().getY()==0) && !board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()-1].isPraticable(this)){
				
				Monster monster = board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()-1].getUnit();
				monster.perdreVie() ;
				
			}
			break;
		case "down":
			if(!(this.getCoordonnee().getY()==board.getNbCaseVertical()) && !board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()+1].isPraticable(this)){
				Unit monster = board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()+1].getUnit();
				monster.perdreVie();
			}
			break;
		case "right":
			if(!(this.getCoordonnee().getY()==board.getNbCaseHorizontal()) && !board.getBoard()[this.getCoordonnee().getX()+1][this.getCoordonnee().getY()].isPraticable(this)){
				Unit monster = board.getBoard()[this.getCoordonnee().getX()+1][this.getCoordonnee().getY()].getUnit();
				monster.perdreVie();
			}
			break;
		case "left":
			if(!(this.getCoordonnee().getY()==0) && !board.getBoard()[this.getCoordonnee().getX()-1][this.getCoordonnee().getY()].isPraticable(this)){
				Unit monster = board.getBoard()[this.getCoordonnee().getX()-1][this.getCoordonnee().getY()].getUnit();
				monster.perdreVie();
			}
			break;
		}
			
		
	}


	@Override
	public String toString() {
		return "Hero []";
	}


	
	
	
}
