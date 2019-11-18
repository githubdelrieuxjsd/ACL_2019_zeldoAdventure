package control;

import java.awt.event.KeyEvent;

import model.Board;
import model.Case;
import model.Coordonnee;
import model.Direction;
import model.Hero;
import model.Tree;
import model.Slime;
import model.Gobelin;

public class Control {

	private static int tailleCase = 80;
	public static Hero hero;
	public static Slime slime; 
	public static Board board;
	public static Gobelin gobelin; 

	public static void initPlateau(int tailleHoriz, int tailleVerti) {

		int nbCaseHori = tailleHoriz / getTailleCase();
		int nbCaseVerti = tailleVerti / getTailleCase();

		board = new Board(nbCaseHori, nbCaseVerti);
		board.addDecorRandom(new Tree(), 5);
		board.completeGrass();
		
		slime = new Slime (new Coordonnee(10,3));
		board.addUnit( slime );
		gobelin = new Gobelin (new Coordonnee (6,5));
		board.addUnit(gobelin);
		
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
		String rslt = "nothing";
		Case[][] plateau = board.getBoard();

		Case caseDevant = board.getCaseDirection(hero);
		if ( !(caseDevant == null)) {
			switch (commande) {
			case "move":
				if (caseDevant.isPraticable(hero)) {
					rslt = "move";
				}
				break;
			case "attack" : 
				if (caseDevant.getUnit().isMonster()) {
					rslt = "attack" ;

				}
			default:
				;
			}
		}
		
		return rslt;
	}

	
	public static String action(String playerDecision) {
		switch (playerDecision) {
		case "move" :
			hero.move(board);
			slime.move(board);
			gobelin.move(board);
			break;
		case "attack":

			hero.attack(board);
			slime.move(board);
			gobelin.move(board);
			break;
		default :
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
