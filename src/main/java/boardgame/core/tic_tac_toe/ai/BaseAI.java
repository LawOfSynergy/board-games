package boardgame.core.tic_tac_toe.ai;

import boardgame.core.AI;
import boardgame.core.Board;
import boardgame.core.Point;
import boardgame.core.tic_tac_toe.TicTacToeBoard;

public abstract class BaseAI implements AI<Point, Boolean> {
	@Override
	public Point getNextMove(Board<Boolean> board) {
		validateBoard(board);
		return getNextMoveImpl((TicTacToeBoard)board);
	}

	private void validateBoard(Board<Boolean> board) {
		if (!(board instanceof TicTacToeBoard)) {
			throw new IllegalArgumentException("board must be an instance of TicTacToeBoard");
		}

		TicTacToeBoard b = (TicTacToeBoard) board;

		if (b.isFull()) {
			throw new IllegalArgumentException("board is full");
		}
	}

	protected abstract Point getNextMoveImpl(TicTacToeBoard board);
}
