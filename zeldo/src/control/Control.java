package control;

import model.Board;

public class Control {

	int Salusse;

	private static int tailleCase = 60;
	public static Board board;

	public static void initPlateau(int tailleHoriz, int tailleVerti) {
		int nbCaseHori = tailleHoriz / tailleCase;
		int nbCaseVerti = tailleVerti / tailleCase;

		board = new Board(nbCaseHori, nbCaseVerti);
	}

	static String verifierPlayerDecision() {
		return null;

	}

	static String action() {
		return null;

	};
}
