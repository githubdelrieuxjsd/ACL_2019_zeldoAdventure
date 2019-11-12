package model;

public class Direction {
	
	String direction;
	
	public Direction(String direction) {
		switch(direction.toUpperCase()) {
		case "UP":
			this.direction = "up";
			System.out.println(this.direction);
			break;
		case "DOWN":
			this.direction = "down";
			System.out.println(this.direction);
			break;
		case "RIGHTt":
			this.direction = "right";
			System.out.println(this.direction);

			break;
		case "LEFT":
			this.direction = "left";
			System.out.println(this.direction);
			break;
		default:
			this.direction = "down";
			System.out.println(this.direction);
			break;
		}
		
		
	}
	
	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	} 

}
