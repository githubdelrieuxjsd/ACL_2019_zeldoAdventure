package control;

import java.awt.event.KeyEvent;

import model.Board;
import model.Case;
import model.Hero;

public class Control {

	private static int tailleCase = 80;
	public static Hero hero;

	public static Board board;

	public static void initPlateau(int tailleHoriz, int tailleVerti) {

		int nbCaseHori = tailleHoriz / getTailleCase();
		int nbCaseVerti = tailleVerti / getTailleCase();

		board = new Board(nbCaseHori, nbCaseVerti);
		hero = new Hero();
	}

	public static String verifierPlayerDecision(String commande) {
		Case[][] plateau = board.getBoard();

		String rslt = "nothing";
		switch (commande) {
		case "moveUp":
			if (hero.getCoordonnee().getX() != 0
					&& plateau[hero.getCoordonnee().getX() - 1][hero.getCoordonnee().getY()].isPraticable(hero)) {
				rslt = "moveUp";
			}
			break;
		case "moveDown":
			if ((hero.getCoordonnee().getX() != plateau.length - 1)
					&& plateau[hero.getCoordonnee().getX() + 1][hero.getCoordonnee().getY()].isPraticable(hero)) {
				rslt = "moveDown";
			}
			break;
		case "moveRight":
			if ((hero.getCoordonnee().getY() != plateau[0].length - 1)
					&& plateau[hero.getCoordonnee().getX()][hero.getCoordonnee().getY() + 1].isPraticable(hero)) {
				rslt = "moveRight";
			}
			break;
		case "moveLeft":
			if (hero.getCoordonnee().getY() != 0
					&& plateau[hero.getCoordonnee().getX()][hero.getCoordonnee().getY() - 1].isPraticable(hero)) {
				rslt = "moveLeft";
			}
			break;
		default:
			;
		}
		return rslt;

	}

	static String action(String playerDecision) {

		return "nothing";

	}

	public static int getTailleCase() {
		return tailleCase;
	}

	public static void setTailleCase(int tailleCase) {
		Control.tailleCase = tailleCase;
	};
}
