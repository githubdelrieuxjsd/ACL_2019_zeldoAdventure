package model;

public class Case {
	
	
	private boolean isEmpty() {
		if (DecorABS.nom.equals("UnitVoid") && UnitABS.nom.equals("DecorVoid")) {
			return true;
		}
		else {
		return false;
		}
	}
	
	private boolean isPraticable(UnitABS u) {
		if (DecorABS.nom.equals("Grass") && UnitABS.nom.equals("UnitVoid")) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	

}
