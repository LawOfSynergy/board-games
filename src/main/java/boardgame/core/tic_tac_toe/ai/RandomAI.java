package boardgame.core.tic_tac_toe.ai;

import boardgame.core.Point;
import boardgame.core.tic_tac_toe.TicTacToeBoard;

import java.util.Random;

public class RandomAI extends BaseAI {
	@Override
	public Point getNextMoveImpl(TicTacToeBoard board) {
		Random r = boardgame.core.Random.INSTANCE;
		Point p;
		do {
			int y = r.nextInt(board.getHeight());
			int x = r.nextInt(board.getWidth(y));
			p = new Point(x, y);
		}while(board.isOccupied(p));

		return p;
	}
}
