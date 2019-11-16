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
		switch (direction.getDirection()) {
		case "up":
			if(!(this.getCoordonnee().getY()==0)){
				if(board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()-1].getUnit().isMonster()) {
					Monster mstr = (Monster) board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()-1].getUnit();
					mstr.loseLife();
				}				
			}
			break;
		case "down":
			if(!(this.getCoordonnee().getY()==board.getNbCaseVertical())){
				if(board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()+1].getUnit().isMonster()) {
					Monster mstr = (Monster) board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()+1].getUnit();
					mstr.loseLife();
				}
			}
			break;
		case "right":
			if(!(this.getCoordonnee().getY()==board.getNbCaseHorizontal())){
				if(board.getBoard()[this.getCoordonnee().getX()+1][this.getCoordonnee().getY()].getUnit().isMonster()) {
					Monster mstr = (Monster) board.getBoard()[this.getCoordonnee().getX()+1][this.getCoordonnee().getY()].getUnit();
					mstr.loseLife();
				}
			}
			break;
		case "left":
			if(!(this.getCoordonnee().getY()==0)){
				if(board.getBoard()[this.getCoordonnee().getX()-1][this.getCoordonnee().getY()].getUnit().isMonster()) {
					Monster mstr = (Monster) board.getBoard()[this.getCoordonnee().getX()-1][this.getCoordonnee().getY()].getUnit();
					mstr.loseLife();
				}
			}
			break;
		default:
			break;
		}
			
		
	}

	public void gainLife(int nbVie) {
		if(nbVie-this.getLifeMax() > 0) {
			this.setLife(this.getLifeMax());
		}
		else {this.setLife(this.getLife()+nbVie);
		}		
	}

	@Override
	public void loseLife() {
		this.setLife(this.getLife()-1);
		if(this.getLife()<=0) {
			this.setLife(this.getLifeMax());
		}
		
	}


	
	
	
	
}
