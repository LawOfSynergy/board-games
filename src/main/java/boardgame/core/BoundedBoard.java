package boardgame.core;

import java.util.Arrays;

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
	 *             Also, if this array comes prepopulated, it is also important that this array only have elements
	 *             of type T.
	 */
	protected BoundedBoard(T[][] data) {
		this.data = data;
	}

	@Override
	public boolean isValidPos(Point p) {
		if(p == null) return false;
		int y = p.getY();
		int x = p.getX();
		return y >= 0 && y < data.length && x >= 0 && x < data[y].length;
	}

	private void assertPositionIsValid(Point p) {
		if(!isValidPos(p)) {
			throw new IllegalArgumentException("Position " + p + " is invalid.");
		}
	}

	@Override
	@SuppressWarnings("unchecked")
	public T get(Point p) {
		assertPositionIsValid(p);
		return (T)data[p.getY()][p.getX()];
	}

	@Override
	public void set(Point p, T element) {
		assertPositionIsValid(p);
		data[p.getY()][p.getX()] = element;
	}

	@Override
	public void clearLocation(Point p) {
		assertPositionIsValid(p);
		data[p.getY()][p.getX()] = null;
	}

	@Override
	public boolean isOccupied(Point p) {
		return get(p) != null;
	}

	/**
	 * @return
	 */
	@Override
	public boolean isEmpty() {
		for (Object[] row : data) {
			for(Object element : row) {
				if(element != null) return false;
			}
		}
		return true;
	}

	@Override
	public boolean isFull() {
		for (Object[] row : data) {
			for(Object element : row) {
				if(element == null) return false;
			}
		}
		return true;
	}

	public int getHeight() {
		return data.length;
	}

	public int getWidth(int row) {
		if(row < 0 || row >= data.length) throw new IllegalArgumentException("row is invalid");
		return data[row].length;
	}
}
