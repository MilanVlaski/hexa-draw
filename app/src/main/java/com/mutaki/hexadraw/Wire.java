package com.mutaki.hexadraw;

import com.mutaki.hexadraw.canvas.OnHitCallback;
import com.mutaki.hexadraw.model.Element;
import com.mutaki.hexadraw.model.document.Document;

import java.awt.*;

public class Wire implements Element {
    private final com.mutaki.hexadraw.Element junctionPoint1;
    private final com.mutaki.hexadraw.Element junctionPoint2;

    public Wire(com.mutaki.hexadraw.Element junctionPoint1, com.mutaki.hexadraw.Element junctionPoint2) {
        if(junctionPoint1.equals(junctionPoint2)) {
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
        // TODO
    }

    @Override
    public void hit(Point point, OnHitCallback onHitCallback) {

    }
}
