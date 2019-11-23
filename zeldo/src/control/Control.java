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
	/** Constructeur privé */
	private Control() {
		
		
	}

	/** Instance unique pré-initialisée */
	private static Control INSTANCE = new Control();

	/** Point d'accès pour l'instance unique du singleton */
	public static Control getInstance() {
		return INSTANCE;
	}

	private int tailleCase = 80;

	private Hero hero;

	private Board board;

	private Slime slime;
	private Gobelin gobelin;

	public void initPlateau(int tailleHoriz, int tailleVerti) {

		int nbCaseHori = tailleHoriz / getTailleCase();
		int nbCaseVerti = tailleVerti / getTailleCase();

		board = new Board(nbCaseHori, nbCaseVerti);
		board.addDecorRandom(new Tree(), 5);
		board.completeGrass();

		slime = new Slime(new Coordonnee(10, 3));
		board.addUnit(slime);
		gobelin = new Gobelin(new Coordonnee(6, 5));
		board.addUnit(gobelin);

	}

	public void placerHero() {
		boolean placer = false;
		int x = 0;
		int y = 0;
		hero = new Hero(new Coordonnee(x, y));
		while (!placer) {
			if (board.getBoard()[x][y].isPraticable(hero)) {
				board.addUnit(hero);
				placer = true;
			} else {
				x++;
				if (x == board.getNbCaseHorizontal() - 1) {
					y++;
				}
				hero.setCoordonnee(new Coordonnee(x, y));
			}
		}
	}

	public String verifierPlayerDecision(String commande) {
		Case[][] plateau = board.getBoard();
		String rslt = "nothing";
		Case caseDevant = board.getCaseDirection(hero);
		if (!(caseDevant == null)) {
			switch (commande) {
			case "move":
				if (caseDevant.isPraticable(hero)) {
					rslt = "move";
				}
				break;
			case "attack":
				if (caseDevant.getUnit().isMonster()) {
					rslt = "attack";

				}
			default:
				;
			}
		}
		return rslt;
	}

	public String action(String playerDecision) {
		
		switch (playerDecision) {
		case "move":
			hero.move(board);
			
			break;
		case "attack":

			hero.attack(board);
			
			break;
		default:
		}
		if (!(playerDecision == "nothing")) {
			slime.choisirAction(board);
			gobelin.choisirAction(board);
		}

		return "nothing";
	}

	public int getTailleCase() {
		return tailleCase;
	}

	public Hero getHero() {
		return hero;
	}

	public Board getBoard() {
		return board;
	}

}
