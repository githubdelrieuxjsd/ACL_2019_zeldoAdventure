package model;

import pkinterface.Life;

public class Hero extends Unit implements Move,Life {

	
	public Hero(Coordonnee c) {
		this.setNom("Hero");
		this.setImageURL("hyrule/link/beat/D1.png");
		this.setCoordonnee(c);
		this.setLifeMax(5);
		this.setLife(5);
		this.setDirection(new Direction("right"));
	}

	public void move(Board board) {
		Case nextCase= board.getCaseDirection(this);
		board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
		this.setCoordonnee(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()]
				.setUnit(new Hero(nextCase.getCoordonnee()));

	}
	
	public void attack(Board board, Direction direction) {
		Case caseFront = board.getCaseDirection(this);
		if (caseFront.getUnit().isMonster()) {
			 ((Monster) caseFront.getUnit()).loseLife(1);
		}
			
	}

	public String toString() {
		return "Le Héro est positionné en (x,y)=("+this.getCoordonnee().getX()+","+this.getCoordonnee().getY()+"), \n et sa vie est à "+this.getLife() ;	
	}

	@Override
	public void gainLife(int nbVie) {
		if(nbVie-this.getLifeMax() > 0) {
			this.setLife(this.getLifeMax());
		}
		else {this.setLife(this.getLife()+nbVie);
		}		
	}

	@Override
	public void loseLife(int damage) {
		this.setLife(this.getLife()-damage);
		if(this.getLife()<=0) {
			this.setLife(this.getLifeMax());
		}
		
	}
	
	
}
