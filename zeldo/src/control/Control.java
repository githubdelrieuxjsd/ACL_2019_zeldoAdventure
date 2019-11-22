package control;

import java.awt.event.KeyEvent;

import model.Board;
import model.Case;
import model.Coordonnee;
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
		int nbCaseVerti = tailleVerti / getTailleCase()-1;

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
	public String action(String playerDecision) {
		//oupsi 
		return "nothing";
	}

	public int getTailleCase() {
		return tailleCase;
	}


}
