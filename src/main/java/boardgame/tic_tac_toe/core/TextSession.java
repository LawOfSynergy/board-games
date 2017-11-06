package boardgame.tic_tac_toe.core;

import boardgame.core.Point;
import boardgame.tic_tac_toe.core.ai.BaseAI;
import org.jetbrains.annotations.Contract;

public class TextSession implements Runnable{
	private BaseAI[] players;
	private TicTacToeBoard board;

	@Contract("null, _ -> fail; _ , null -> fail")
	public TextSession(BaseAI p1, BaseAI p2) {
		if(p1 == null) throw new IllegalArgumentException("p1 cannot be null");
		if(p2 == null) throw new IllegalArgumentException("p2 cannot be null");

		board = new TicTacToeBoard();
		players = new BaseAI[]{p1, p2};
	}

	public void run() {
		int currentPlayer = 0;
		while(!isOver(board)) {
			System.out.println(board);
			board.set(players[currentPlayer].getNextMove(board), new Move(currentPlayer == 0));
			currentPlayer = (currentPlayer+1)%2;
		}
		System.out.println(board);
	}

	private boolean isOver(TicTacToeBoard board) {
		if (board.isFull()) {
			return true;
		}

		if(checkRows()) {
			return true;
		}

		if(checkColumns()) {
			return true;
		}

		if (checkDiagonals()) {
			return true;
		}

		return false;
	}

	private boolean checkRows() {
		for(int y = 0; y < 3; y++) {
			Point[] points = {new Point(0, y), new Point(1, y), new Point(2, y)};
			if(checkSequence(points)) {
				return true;
			}
		}

		return false;
	}

	private boolean checkColumns() {
		for(int x = 0; x < 3; x++) {
			Point[] points = {new Point(x, 0), new Point(x, 1), new Point(x, 2)};
			if(checkSequence(points)) {
				return true;
			}
		}

		return false;
	}

	private boolean checkDiagonals() {
		if(checkSequence(new Point[]{new Point(0,0), new Point(1,1), new Point(2,2)})){
			return true;
		}

		if(checkSequence(new Point[]{new Point(0,2), new Point(1,1), new Point(2,0)})){
			return true;
		}

		return false;
	}

	@Contract("null -> fail")
	private boolean checkSequence(Point[] points) {
		if (points == null) { throw new IllegalArgumentException("points cannot be null"); }
		if (points.length != 3) { throw new IllegalArgumentException("points.length must have 3 entries"); }

		int[] counts = {0, 0};
		for(Point p : points) {
			Boolean cell = board.get(p).getValue();
			if(cell == null) {
				//noop
			}else if(cell) {
				counts[0]++;
			} else {
				counts[1]++;
			}
		}

		return counts[0] == 3 || counts[1] == 3;
	}
}
