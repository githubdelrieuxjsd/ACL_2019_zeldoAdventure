package model;

import pkinterface.ChoisirAction;
import pkinterface.Life;

public abstract class Monster extends Unit implements Life, ChoisirAction{

	public String toString() {
		return "Le "+this.getNom()+" est positionné en (x,y)=("+this.getCoordonnee().getX()+","+this.getCoordonnee().getY()+"), \n et sa vie est à "+this.getLife() ;
	}


	public void gainLife(int nbVie) {
		if(nbVie-this.getLifeMax() > 0) {
			this.setLife(this.getLifeMax());
		}
		else {this.setLife(this.getLife()+nbVie);
		}
	}
	
	






}
