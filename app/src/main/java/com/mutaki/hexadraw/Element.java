package com.mutaki.hexadraw;

import java.awt.Point;

import javax.swing.JPanel;

/**
 * Element is a placeholder generic name. Obviously, a connector wouldn't have a
 * location, exactly.
 */
public interface Element {
    boolean isAt(Point point);

    JPanel draw();
}
