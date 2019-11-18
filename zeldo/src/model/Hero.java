package model;

import pkinterface.Life;

public class Hero extends Unit implements Move, Life {

	public Hero(Coordonnee c) {
		this.setNom("Hero");
		this.setImageURL("hyrule/link/beat/D1.png");
		this.setCoordonnee(c);
		this.setLifeMax(5);
		this.setLife(5);
		this.setDirection(new Direction("left"));
	}

	public void move(Board board) {
		Case nextCase = board.getCaseDirection(this);
		board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
		this.setCoordonnee(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()].setUnit(this);
	}

	public void attack(Board board) {
		Case caseDevant = board.getCaseDirection(this);

		if (caseDevant.getUnit().isMonster()) {

			Monster mstr = (Monster) caseDevant.getUnit();
			mstr.loseLife();
		}
	}

	public void gainLife(int nbVie) {
		if (nbVie - this.getLifeMax() > 0) {
			this.setLife(this.getLifeMax());
		} else {
			this.setLife(this.getLife() + nbVie);
		}
	}

	@Override
	public void loseLife() {
		this.setLife(this.getLife() - 1);
		if (this.getLife() <= 0) {
			this.setLife(this.getLifeMax());
		}

	}

	public String getImageURL() {
		// System.out.println(this.getDirection().getDirection());
		return "hyrule/link/beat/" + this.getDirection().getDirection().substring(0, 1).toUpperCase() + "1.png";

	}

}
