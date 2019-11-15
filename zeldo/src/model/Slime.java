package model;

public class Slime extends Monster implements Move{
	
	public Slime(Coordonnee c) {
		this.setNom("Slime");
		this.setImageURL("hyrule/tomato/beat/Down/3.png");
		this.setCoordonnee(c);
		this.setDirection(new Direction("left"));
		this.setLifeMax(5);
		this.setLife(this.getLifeMax());
	}

	@Override
	public void loseLife() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void move(Board board) {
		this.rotateDirection90Right();
		Case nextCase= board.getCaseDirection(this);
		if (nextCase.isPraticable(this)) {
			board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
			this.setCoordonnee(nextCase.getCoordonnee());
			board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()].setUnit(new Slime(nextCase.getCoordonnee()));
			
		}
		else {
			// attaquer(nextCase) a coder ...
		}
		
	}
	
	public void rotateDirection90Right() {
		switch(this.getDirection().getDirection()) {
		case "up":
			this.setDirection(new Direction("right"));
			break;
		case "right":
			this.setDirection(new Direction("down"));
			break;
		case "down":
			this.setDirection(new Direction("left"));
			break;
		case "left":
			this.setDirection(new Direction("up"));
			break;
		default:
				// throwOutException
		}
	}
	
	

	

}
