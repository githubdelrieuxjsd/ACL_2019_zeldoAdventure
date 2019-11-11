package model;

public class Case {

	private DecorABS decors;
	private UnitABS unit;
	private Coordonnee coordonnee;

	// CONSTRUCTEUR 

	public boolean isEmpty() {
		if (this.decors.getNom().equals("UnitVoid") && unit.getNom().equals("DecorVoid")) {
			return true;
		}
		return false;
	}

	public boolean isPraticable(UnitABS u) {
		if (decors.getNom().equals("Grass") && unit.getNom().equals("UnitVoid")) {
			return true;
		}
		return false;

	}

	public DecorABS getDecors() {
		return decors;
	}

	public void setDecors(DecorABS decors) {
		this.decors = decors;
	}

	public UnitABS getUnit() {
		return unit;
	}

	public void setUnit(UnitABS unit) {
		this.unit = unit;
	}




}
