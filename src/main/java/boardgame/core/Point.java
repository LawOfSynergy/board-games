package boardgame.core;

import org.jetbrains.annotations.Contract;

public class Point {
    private int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Contract(pure = true)
    public int getX() {
        return x;
    }

    @Contract(pure = true)
    public int getY() {
        return y;
    }

    @Contract(pure = true)
    public String toString() {
        return "Point(" + x + "," + y + ")";
    }
}
