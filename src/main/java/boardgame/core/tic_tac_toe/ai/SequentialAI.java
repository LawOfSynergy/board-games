package boardgame.core.tic_tac_toe.ai;

import boardgame.core.Point;
import boardgame.core.tic_tac_toe.TicTacToeBoard;

public class SequentialAI extends BaseAI{
	@Override
	protected Point getNextMoveImpl(TicTacToeBoard board) {
		Point p = null;

		outer:for(int y = 0; y < board.getHeight(); y++) {
			for(int x = 0; x < board.getWidth(y); x++) {
				p = new Point(x, y);
				if(!board.isOccupied(p)) {
					break outer;
				}
			}
		}

		return p;
	}
}
