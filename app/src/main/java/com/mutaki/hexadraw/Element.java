package com.mutaki.hexadraw;

import java.awt.Point;

/**
 * Element is a placeholder generic name. Obviously, a connector wouldn't have a
 * location, exactly.
 */
public class Element {

    private Point location;

    public Element(Point location) {
	this.location = location;
    }

    public boolean isAt(Point point) {
	return location.equals(point);
    }

}
