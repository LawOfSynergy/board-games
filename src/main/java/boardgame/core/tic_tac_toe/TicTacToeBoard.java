package boardgame.core.tic_tac_toe;

import boardgame.core.BoundedBoard;
import boardgame.core.Point;

public class TicTacToeBoard extends BoundedBoard<Boolean> {
	public TicTacToeBoard() {
		super(3, 3);
	}

	public String toString() {
		String result = "";

		for(int y = 0; y < getHeight(); y++) {
			for(int x = 0; x < getWidth(y); x++) {
				Boolean firstPlayer = get(new Point(x, y));
				String cell = (firstPlayer == null) ? " " : (firstPlayer) ? "X" : "O";
				String terminus = (x == (getWidth(y) - 1)) ? "\n" : "|";
				result += cell + terminus;
			}
		}

		return result;
	}
}
