package control;

import java.awt.event.KeyEvent;

import model.Board;
import model.Case;
import model.Coordonnee;
import model.Direction;
import model.Hero;
import model.Tree;

public class Control {   
	/** Constructeur privé */
	private Control(){}

	/** Instance unique pré-initialisée */
	private static Control INSTANCE = new Control();

	/** Point d'accès pour l'instance unique du singleton */
	public static Control getInstance(){
		return INSTANCE;}

	private int tailleCase = 80;

	public Hero hero;

	public Board board;

	public void initPlateau(int tailleHoriz, int tailleVerti) {

		int nbCaseHori = tailleHoriz / getTailleCase();
		int nbCaseVerti = tailleVerti / getTailleCase();

		board = new Board(nbCaseHori, nbCaseVerti);
		board.addDecorRandom(new Tree(), 20);
		board.completeGrass();



	}

	public void placerHero() {
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

	public String verifierPlayerDecision(String commande) {
		Case[][] plateau = board.getBoard();

		String rslt = "nothing";
		switch (commande) {
		case "moveUp":
			hero.setDirection(new Direction("up"));
			if (hero.getCoordonnee().getY() != 0
					&& plateau[hero.getCoordonnee().getX() ][hero.getCoordonnee().getY() -1].isPraticable(hero)) {
				rslt = "move";
			}
			break;
		case "moveDown":
			hero.setDirection(new Direction("down"));

			if ((hero.getCoordonnee().getY() != board.getNbCaseVertical()-1)
					&& plateau[hero.getCoordonnee().getX()][hero.getCoordonnee().getY() +1].isPraticable(hero)) {
				rslt = "move";
			}
			break;
		case "moveRight":
			hero.setDirection(new Direction("right"));

			if ((hero.getCoordonnee().getX() != board.getNbCaseHorizontal()-1)
					&& plateau[hero.getCoordonnee().getX() + 1][hero.getCoordonnee().getY()].isPraticable(hero)) {
				rslt = "move";
			}
			break;
		case "moveLeft":
			hero.setDirection(new Direction("left"));

			if (hero.getCoordonnee().getX() != 0
					&& plateau[hero.getCoordonnee().getX() - 1][hero.getCoordonnee().getY()].isPraticable(hero)) {
				rslt = "move";
			}
			break;
		default:
			;
		}
		return rslt;
	}



	public String action(String playerDecision) {
		switch (playerDecision) {
		case "move" :
			hero.move(board);

			break;
		case "attack":
			break;
		default:
		}
		return "nothing";
	}


	public int getTailleCase() {
		return tailleCase;
	}


}
