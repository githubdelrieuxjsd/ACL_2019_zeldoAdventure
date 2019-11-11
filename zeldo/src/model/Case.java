package model;

public class Case {

	private DecorABS decors;
	private UnitABS unit;
	private Coordonnee coordonnee;



	// CONSTRUCTEUR 
	public Case(Coordonnee coord, DecorABS decor, UnitABS unit) {
		this.coordonnee=coord;
		this.decors=decor;
		this.unit=unit;
	}
	
	public Case(Coordonnee coord) {
		this.coordonnee=coord;
		this.decors=new DecorVoid();
		this.unit = new UnitVoid();
		
	}
	
	public boolean isEmpty() {
		if (this.decors.getNom().equals("UnitVoid") && unit.getNom().equals("DecorVoid")) {
			return true;
		}
		return false;
	}

	public boolean isPraticable(UnitABS u) {
		if (decors.getNom().equals("Grass") && u.getNom().equals("UnitVoid")) {
			return true;
		}
		return false;

	}


	public DecorABS getDecors() {
		return decors;
	}

	public void setDecors(DecorABS decor) {
		this.decors = decor;
	}

	public UnitABS getUnit() {
		return unit;
	}

	public void setUnit(UnitABS unit) {
		this.unit = unit;
	}

	public Coordonnee getCoordonnee() {
		return coordonnee;
	}

	public void setCoordonnee(Coordonnee coordonnee) {
		this.coordonnee = coordonnee;
	}

	@Override
	public String toString() {
		return "coordonnee= " + coordonnee.toString() + "\n unit=" + unit.getNom() + "\n"  + "decors=" + decors.getNom() +"\n";

	}




}
