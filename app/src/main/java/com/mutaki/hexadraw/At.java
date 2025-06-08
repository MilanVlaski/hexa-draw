package com.mutaki.hexadraw;

import java.awt.Point;

public class At {

    Point point;

    public At(Point point) {
	this.point = point;
    }

    public static At at(Point point) {
	return new At(point);
    }

    @Override
    public String toString() {
	return String.format("(x=%d, y=%d)", point.x, point.y);
    }

}
