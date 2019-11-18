package model;

public class Gobelin extends Monster implements Move{

	public Gobelin(Coordonnee c) {
		
		this.setNom("Gobelin");
		this.setImageURL("hyrule/goblin/beat/L1.png");
		this.setCoordonnee(c);
		this.setDirection(new Direction("left"));
		this.setLifeMax(5);
		this.setLife(this.getLifeMax());
		
	}
	
	public void loseLife() {
		this.setLife(this.getLife()-1);
		if(this.getLife()<=0) {
			//this.setLife(this.getLifeMax());
			this.setImageURL("hyrule/block/tree.png");

		}
	}

	@Override
	public void move(Board board) {
		this.randomDirection();
		Case nextCase= board.getCaseDirection(this);
		if (!(nextCase == null) ) {
			if (nextCase.isPraticable(this)) {
				board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
				this.setCoordonnee(nextCase.getCoordonnee());
				board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()].setUnit(this);
				
			}
			else {
				// attaquer(nextCase) a coder ...
			}
		}
		
		
	}
	
	public void randomDirection() {
		int rng = 0 + (int)(Math.random()*((3-0)+1));
		switch (rng) {
		case 0:
			this.setDirection(new Direction("up"));
			break;
		case 1:
			this.setDirection(new Direction("right"));
			break;
		case 2:
			this.setDirection(new Direction("down"));
			break;
		case 3:
			this.setDirection(new Direction("left"));
			break;
		default:
			// throwError à coder
		}
	}





}

