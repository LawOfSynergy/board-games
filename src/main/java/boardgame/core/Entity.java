package boardgame.core;

/**
 * Represents an in-game entity.
 */
public interface Entity extends Positional, Renderable{
	Player getOwningPlayer();
}
