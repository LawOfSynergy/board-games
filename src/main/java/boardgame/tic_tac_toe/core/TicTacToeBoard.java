package boardgame.tic_tac_toe.core;

import boardgame.core.board.BoundedBoard;
import boardgame.core.Point;
import boardgame.core.Renderable;
import boardgame.core.Renderer;
import org.jetbrains.annotations.Contract;

public class TicTacToeBoard extends BoundedBoard<Move> implements Renderable{
	public static final String TEXT_CELL = "|";
	public static final String TEXT_ROW = "\n";

	public final Renderer TEXT_RENDERER = () -> {
		String result = "";

		for(int y = 0; y < getHeight(); y++) {
			for(int x = 0; x < getWidth(y); x++) {
				Move move = get(new Point(x, y));
				String cell = move.getRenderer().getResourceString();
				String terminus = (x == (getWidth(y) - 1)) ? TEXT_ROW : TEXT_CELL;
				result += cell + terminus;
			}
		}

		return result;
	};

	public TicTacToeBoard() {
		super(3, 3);

		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 3; x++) {
				set(new Point(x, y), new Move(null));
			}
		}
	}

	@Override
	@Contract(pure = true)
	public String toString() {
		return TEXT_RENDERER.getResourceString();
	}

	public Renderer getRenderer() {
		return TEXT_RENDERER;
	}
}
