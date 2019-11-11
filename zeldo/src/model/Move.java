/**
 * 
 */
package model;

/**
 * @author Linlupok
 *
 */

import model.Case;
import model.Board;

public interface Move {
	
	void move(Board board, Case NextCase);
	

}
