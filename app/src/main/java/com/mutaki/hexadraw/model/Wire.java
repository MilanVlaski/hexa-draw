package com.mutaki.hexadraw.model;

import com.mutaki.hexadraw.JunctionPoint;
import com.mutaki.hexadraw.canvas.OnHitListener;
import com.mutaki.hexadraw.model.document.Document;

import java.awt.*;

public class Wire implements Element {
    private final JunctionPoint junctionPoint1;
    private final JunctionPoint junctionPoint2;

    public Wire(JunctionPoint junctionPoint1, JunctionPoint junctionPoint2) {
        if (junctionPoint1.equals(junctionPoint2)) {
            throw new IllegalArgumentException("JunctionPoints must not be equal");
        }
        this.junctionPoint1 = junctionPoint1;
        this.junctionPoint2 = junctionPoint2;
    }

    @Override
    public Document<?> toDocument() {
        // TODO
        return null;
    }

    @Override
    public void paint(Graphics g) {
        var g2d = (Graphics2D) g;

        g2d.drawLine(junctionPoint1.location.x, junctionPoint1.location.y,
                junctionPoint2.location.x, junctionPoint2.location.y);
    }

    @Override
    public void hit(Point point, OnHitListener onHitListener) {

    }
}
