package model;

public class Direction {
	
	private String direction;
	
	public Direction(String direction) {
		switch(direction.toUpperCase()) {
		case "UP":
			this.direction = "up";
			//System.out.println(this.direction);
			break;
		case "DOWN":
			this.direction = "down";
			//System.out.println(this.direction);
			break;
		case "RIGHT":
			this.direction = "right";
			//System.out.println(this.direction);
			break;
		case "LEFT":
			this.direction = "left";
			//System.out.println(this.direction);
			break;
		default:
			this.direction = "down";
<<<<<<< HEAD
			//System.out.println(this.direction);
=======
			System.out.println("ERROR");
>>>>>>> branch 'david' of https://github.com/githubdelrieuxjsd/ACL_2019_zeldoAdventure.git
			break;
		}
	}
	
	public String getDirection() {
		return direction;
	}

<<<<<<< HEAD
	public void setDirection(String direction) {
		this.direction = direction;
	}
=======
	public void setDirection(Direction direction) {
		this.direction = direction.getDirection();
	} 
>>>>>>> branch 'david' of https://github.com/githubdelrieuxjsd/ACL_2019_zeldoAdventure.git

}
