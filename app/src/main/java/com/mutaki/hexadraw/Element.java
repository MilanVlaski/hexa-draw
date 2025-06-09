package com.mutaki.hexadraw;

import java.awt.Point;

/**
 * Element is a placeholder generic name. Obviously, a connector wouldn't have a
 * location, exactly.
 */
public interface Element extends Painting {
    boolean isAt(Point point);
}
