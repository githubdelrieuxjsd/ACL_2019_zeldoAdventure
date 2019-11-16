package control;

import java.awt.event.KeyEvent;

import model.Board;
import model.Case;
import model.Coordonnee;
import model.Hero;
import model.Tree;

public class Control {

	private static int tailleCase = 80;
	public static Hero hero;

	public static Board board;

	public static void initPlateau(int tailleHoriz, int tailleVerti) {

		int nbCaseHori = tailleHoriz / getTailleCase();
		int nbCaseVerti = tailleVerti / getTailleCase();

		board = new Board(nbCaseHori, nbCaseVerti);
		board.addDecorRandom(new Tree(), 20);
		board.completeGrass();

		
		
	}
	
	public static void placerHero() {
		boolean placer = false;
		int x= 0;
		int y =0;
		hero = new Hero(new Coordonnee(x,y));
		while(!placer) {
			if (board.getBoard()[x][y].isPraticable(hero)) {
				board.addUnit(hero);
				placer = true;
			}
			else {
				x++;
				if (x==board.getNbCaseHorizontal()-1) {
					y++;
				}
				hero.setCoordonnee(new Coordonnee(x,y));
			}
		}
	}

	public static String verifierPlayerDecision(String commande) {
		Case[][] plateau = board.getBoard();

		String rslt = "nothing";
		switch (commande) {
		case "moveUp":

			if (hero.getCoordonnee().getY() != 0
					&& plateau[hero.getCoordonnee().getX() ][hero.getCoordonnee().getY() -1].isPraticable(hero)) {
				rslt = "moveUp";
			}
			break;
		case "moveDown":
			
			if ((hero.getCoordonnee().getY() != board.getNbCaseVertical()-1)
					&& plateau[hero.getCoordonnee().getX()][hero.getCoordonnee().getY() +1].isPraticable(hero)) {
				rslt = "moveDown";
			}
			break;
		case "moveRight":
			
			if ((hero.getCoordonnee().getX() != board.getNbCaseHorizontal()-1)
					&& plateau[hero.getCoordonnee().getX() + 1][hero.getCoordonnee().getY()].isPraticable(hero)) {
				rslt = "moveRight";
			}
			break;
		case "moveLeft":
			
			if (hero.getCoordonnee().getX() != 0
					&& plateau[hero.getCoordonnee().getX() - 1][hero.getCoordonnee().getY()].isPraticable(hero)) {
				rslt = "moveLeft";
			}
			break;
		default:
			;
		}
		return rslt;
	}

	
	//#
	public static String action(String playerDecision) {
		if (  playerDecision.equals("moveLeft") ){
			hero.move(board, board.getCaseLeft(new Case (hero.getCoordonnee())));
		}
		if (  playerDecision.equals("moveRight") ){
			hero.move(board, board.getCaseRight(new Case (hero.getCoordonnee())));
		}
		if (  playerDecision.equals("moveUp") ){
			hero.move(board, board.getCaseUp(new Case (hero.getCoordonnee())));
		}
		if (  playerDecision.equals("moveDown") ){
			hero.move(board, board.getCaseDown(new Case (hero.getCoordonnee())));
		}
		return "nothing";
	}

	public static int getTailleCase() {
		return tailleCase;
	}

	public static void setTailleCase(int tailleCase) {
		Control.tailleCase = tailleCase;
	};

}
