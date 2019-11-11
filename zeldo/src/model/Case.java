package model;

public class Case {

	private Decor decor;
	private Unit unit;
	private Coordonnees coordonnees;

	// CONSTRUCTEUR
	public Case(Coordonnees coord, Decor decor, Unit unit) {
		this.coordonnees = coord;
		this.decor = decor;
		this.unit = unit;
	}

	public Case(Coordonnees coord) {
		this.coordonnees = coord;
		this.decor = new DecorVoid();
		this.unit = new UnitVoid();

	}

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

	public Coordonnees getCoordonnee() {
		return coordonnees;
	}

	public void setCoordonnee(Coordonnees coordonnees) {
		this.coordonnees = coordonnees;
	}

	@Override
	public String toString() {
		return "coordonnees = " + coordonnees.toString() + "\n unit=" + unit.getNom() + "\n" + "decors="
				+ decor.getNom() + "\n";
	}

}
