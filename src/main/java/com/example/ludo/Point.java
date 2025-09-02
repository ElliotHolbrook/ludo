package com.example.ludo;

public record Point(int x, int y) {
    public static Point left(Point point) {
        return new Point(point.x() - 1, point.y());
    }

    public static Point right(Point point) {
        return new Point(point.x() + 1, point.y());
    }

    public static Point up(Point point) {
        return new Point(point.x(), point.y() - 1);
    }

    public static Point down(Point point) {
        return new Point(point.x(),point.y() + 1);
    }
}
