package com.mutaki.hexadraw;

import java.awt.*;

public class JunctionPoint {
    private final Point location;

    public JunctionPoint(Point location) {
        this.location = location;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        JunctionPoint that = (JunctionPoint) o;
        return location.equals(that.location);
    }

    @Override
    public int hashCode() {
        return location.hashCode();
    }
}
