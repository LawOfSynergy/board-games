package boardgame.tic_tac_toe.core.ai;

import boardgame.core.Point;
import boardgame.tic_tac_toe.core.TicTacToeBoard;
import org.jetbrains.annotations.Contract;

public class SequentialAI extends BaseAI{
	@Override
	@Contract("null -> fail")
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
