package boardgame.core.board;

public interface Cell<T>{
	boolean isOccupied();
	T getValue();
	void setValue(T value);
	void clear();
}
