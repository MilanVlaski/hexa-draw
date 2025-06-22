package com.mutaki.hexadraw.model;

import java.awt.Point;

public class JunctionBoxFactory {

    public JunctionBox create(Point point) {
        return new JunctionBox(point);
    }
}
