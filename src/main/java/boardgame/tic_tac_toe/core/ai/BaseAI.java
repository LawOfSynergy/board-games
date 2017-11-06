package boardgame.tic_tac_toe.core.ai;

import boardgame.core.AI;
import boardgame.core.board.Board;
import boardgame.core.Point;
import boardgame.tic_tac_toe.core.Move;
import boardgame.tic_tac_toe.core.TicTacToeBoard;
import org.jetbrains.annotations.Contract;

public abstract class BaseAI implements AI<Point, Move> {
	@Override
	@Contract("null -> fail")
	public Point getNextMove(Board<Move> board) {
		validateBoard(board);
		return getNextMoveImpl((TicTacToeBoard)board);
	}

	@Contract("null -> fail")
	private void validateBoard(Board<Move> board) {
		if (!(board instanceof TicTacToeBoard)) {
			throw new IllegalArgumentException("board must be an instance of TicTacToeBoard");
		}

		TicTacToeBoard b = (TicTacToeBoard) board;

		if (b.isFull()) {
			throw new IllegalArgumentException("board is full");
		}
	}

	@Contract("null -> fail")
	protected abstract Point getNextMoveImpl(TicTacToeBoard board);
}
