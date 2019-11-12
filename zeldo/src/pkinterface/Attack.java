package pkinterface;

import model.Case;
import model.Direction;
import model.Board;


public interface Attack {
	
	void attack(Board board, Direction direction);

}
