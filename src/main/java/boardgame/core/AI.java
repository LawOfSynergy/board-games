package boardgame.core;

/**
 * Represents an AI.
 * @param <T> some object encapsulating the move to be made.
 * @param <B> The type of entities that the board holds.
 */
public interface AI<T, B>{
	T getNextMove(Board<B> board);
}
