package model;

public class Case {

	private Decor decor;
	private Unit unit;
	private Coordonnees coordonnees;

	// CONSTRUCTEUR

	public boolean isEmpty() {

		return this.decor.getNom().equals("UnitVoid") && unit.getNom().equals("DecorVoid");
	}

	public boolean isPraticable(Unit u) {
		if (decor.getNom().equals("Grass") && unit.getNom().equals("UnitVoid")) {

			// test sur u

			return true;
		}
		return false;

	}

	public Decor getDecor() {
		return decor;
	}

	public void setDecor(Decor decor) {
		this.decor = decor;
	}

	public Unit getUnit() {
		return unit;
	}

	public void setUnit(Unit u) {
		this.unit = u;
	}

}
