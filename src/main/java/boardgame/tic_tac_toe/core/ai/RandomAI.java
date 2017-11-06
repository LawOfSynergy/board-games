package boardgame.tic_tac_toe.core.ai;

import boardgame.core.Point;
import boardgame.tic_tac_toe.core.TicTacToeBoard;
import org.jetbrains.annotations.Contract;

import java.util.Random;

public class RandomAI extends BaseAI {
	@Override
	@Contract("null -> fail")
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
