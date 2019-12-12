package model;

public class Slime extends Monster implements Move{

	public Slime(Coordonnee c) {
		this.setNom("Slime");
		this.setImageURL("hyrule/slime/R1.png");
		this.setCoordonnee(c);
		this.setDirection(new Direction("right"));
		this.setLifeMax(5);
		this.setLife(this.getLifeMax());
	}

	@Override
	/**
	 * if the case in front of the Slime is practicable he will move()
	 * 		
	 * else (a hero must be in front of him) and he will attack()	 */
	public void choisirAction(Board board) {
		this.rotateDirectionNinety();
		Case nextCase= board.getCaseDirection(this);
		if (!(nextCase == null)) {
			if(nextCase.isPraticable(this)){
				this.move(board);
			}
			else {
				this.attack(board);
			}
		}


	}



	@Override
	/**
	 * this monster (Slime) will move in a random direction and in one case range
	 */
	public void move(Board board) {
		Case nextCase= board.getCaseDirection(this);
		board.getBoard()[this.getCoordonnee().getX()][this.getCoordonnee().getY()].setUnit(new UnitVoid());
		this.setCoordonnee(nextCase.getCoordonnee());
		board.getBoard()[nextCase.getCoordonnee().getX()][nextCase.getCoordonnee().getY()].setUnit(this);

	}
	/**
	 * This monster (Slime) can only attack a hero
	 */
	public void attack(Board board) {
		Case caseFront = board.getCaseDirection(this);
		if (caseFront.getUnit().getNom().equals(new String("Hero"))) {
			((Hero) caseFront.getUnit()).loseLife(1);
		}

	}
	/**
	 * a Slime must move in a sqare, so he shall rotate by ninety degree in the right way 
	 */
	public void rotateDirectionNinety() {
		switch(this.getDirection().getDirection()) {
		case "up":
			this.setDirection(new Direction("right"));
			break;
		case "right":
			this.setDirection(new Direction("down"));
			break;
		case "down":
			this.setDirection(new Direction("left"));
			break;
		case "left":
			this.setDirection(new Direction("up"));
			break;
		default:
			// throwOutException
		}
	}

	@Override
	public void loseLife(int damage) {
		// TODO Auto-generated method stub

	}







}
