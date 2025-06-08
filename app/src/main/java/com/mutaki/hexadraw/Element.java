package com.mutaki.hexadraw;

import java.awt.Graphics;
import java.awt.Point;

/**
 * Element is a placeholder generic name. Obviously, a connector wouldn't have a
 * location, exactly.
 */
public interface Element {
    boolean isAt(Point point);

    void paint(Graphics g);
}
