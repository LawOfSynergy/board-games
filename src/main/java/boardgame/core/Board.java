package boardgame.core;

public interface Board<T> {
    boolean isValidPos(Point p);
    T get(Point p);
    void set(Point p, T element);
    void clearLocation(Point p);
    boolean isOccupied(Point p);
    boolean isEmpty();
    boolean isFull();
}
