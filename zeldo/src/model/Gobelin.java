package model;

public class Gobelin extends Monster{

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
			this.setLife(this.getLifeMax());
		}
	}


}

