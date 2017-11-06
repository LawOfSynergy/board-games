package boardgame.core.board;

import boardgame.core.Point;
import org.jetbrains.annotations.Contract;

/**
 * If, T is some implements the Cell interface, then all appropriate checks will be delegated to the cell.
 * Otherwise, checks will operate on whether or not the position returns a null value;
 *
 * get and set DO NOT forward their calls to the cell object.
 *
 * @param <T> The type of object this board will hold.
 */
public class BoundedBoard<T> implements Board<T>{
	private Object[][] data;

	public BoundedBoard(int width, int height) {
		data = new Object[height][width];
	}

	/**
	 * This method can be used to allow a jagged array to be used for the bounded board.
	 * This could be particularly useful for making hexagonal grids, or for pre-populated state.
	 *
	 * @param data - the array to use as the backing data store. For program safety, it is important to
	 *             keep this array 'private' to the class (i.e. this object is the only one that should have
	 *             a reference to the array).
	 *             Also, if this array comes pre-populated, it is also important that this array only have elements
	 *             of type T.
	 */
	@Contract("null -> fail")
	protected BoundedBoard(T[][] data) {
		if (data == null) { throw new IllegalArgumentException("data cannot be null"); }
		this.data = data;
	}

	@Override
	@Contract(value = "null -> false", pure = true)
	public boolean isValidPos(Point p) {
		if(p == null) return false;
		int y = p.getY();
		int x = p.getX();
		return y >= 0 && y < data.length && x >= 0 && x < data[y].length;
	}

	@Contract(value = "null -> fail")
	private void assertPositionIsValid(Point p) {
		if(!isValidPos(p)) {
			throw new IllegalArgumentException("Position " + p + " is invalid.");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	@Contract(value = "null -> fail", pure = true)
	public T get(Point p) {
		assertPositionIsValid(p);
		return (T)data[p.getY()][p.getX()];
	}

	@Override
	@Contract(value = "null, _ -> fail")
	public void set(Point p, T element) {
		assertPositionIsValid(p);
		data[p.getY()][p.getX()] = element;
	}

	@Override
	@Contract("null -> fail")
	public void clearLocation(Point p) {
		assertPositionIsValid(p);
		T element = get(p);
		if(element instanceof Cell){
			((Cell)element).clear();
		}else {
			data[p.getY()][p.getX()] = null;
		}
	}

	@Override
	@Contract(value = "null -> fail", pure = true)
	public boolean isOccupied(Point p) {
		T element = get(p);

		//null == unoccupied
		if(element == null) {
			return false;
		}

		//if a cell, defer to what the cell says
		if(element instanceof Cell) {
			return ((Cell)element).isOccupied();
		}

		//not null and not a cell == occupied
		return true;
	}

	@Override
	@Contract(pure = true)
	public boolean isEmpty() {
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[y].length; x++) {
				if(isOccupied(new Point(x, y))) { return false; }
			}
		}
		return true;
	}

	@Override
	@Contract(pure = true)
	public boolean isFull() {
		for (int y = 0; y < data.length; y++) {
			for (int x = 0; x < data[y].length; x++) {
				if(!isOccupied(new Point(x, y))) { return false; }
			}
		}
		return true;
	}

	@Contract(pure = true)
	public int getHeight() {
		return data.length;
	}

	@Contract(pure = true)
	public int getWidth(int row) {
		if(row < 0 || row >= data.length) throw new IllegalArgumentException("row is invalid");
		return data[row].length;
	}
}
