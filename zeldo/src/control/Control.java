package control;

import model.Board;

public class Control {

	public static int tailleCase = 60;
	public static Board board;

	public static void initPlateau(int tailleHoriz, int tailleVerti) {
		int nbCaseHori = tailleHoriz / getTailleCase();
		int nbCaseVerti = tailleVerti / getTailleCase();

		board = new Board(nbCaseHori, nbCaseVerti);
	}

	static String verifierPlayerDecision() {
		return null;

	}

	static String action() {
		return null;

	}

	public static int getTailleCase() {
		return tailleCase;
	}

	public static void setTailleCase(int tailleCase) {
		Control.tailleCase = tailleCase;
	};
}
