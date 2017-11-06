package boardgame.tic_tac_toe.core;

import boardgame.core.board.Cell;
import boardgame.core.Renderable;
import boardgame.core.Renderer;
import org.jetbrains.annotations.Contract;

public class Move implements Renderable, Cell<Boolean>{
	public static final String TEXT_EMPTY = " ";
	public static final String TEXT_PLAYER_1 = "X";
	public static final String TEXT_PLAYER_2 = "O";

	public final Renderer TEXT_RENDERER = () -> (this.isPlayer1 == null) ? TEXT_EMPTY : (this.isPlayer1) ? TEXT_PLAYER_1 : TEXT_PLAYER_2;

	private Boolean isPlayer1;

	public Move(Boolean isPlayer1) {
		this.isPlayer1 = isPlayer1;
	}

	@Override
	@Contract(pure = true)
	public Renderer getRenderer() {
		return TEXT_RENDERER;
	}

	@Override
	public boolean isOccupied() {
		return isPlayer1 != null;
	}

	@Override
	public Boolean getValue() {
		return isPlayer1;
	}

	@Override
	public void setValue(Boolean value) {
		isPlayer1 = value;
	}

	@Override
	public void clear() {
		isPlayer1 = null;
	}
}
