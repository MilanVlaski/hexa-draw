package com.mutaki.hexadraw;

import com.mutaki.hexadraw.canvas.OnHitCallback;
import com.mutaki.hexadraw.model.Element;
import com.mutaki.hexadraw.model.events.ElementHitEvent;
import com.mutaki.hexadraw.model.events.ElementType;
import com.mutaki.hexadraw.model.document.Document;

import java.awt.*;

public class JunctionPoint implements Element {

    private final int width;
    private final int height;
    private final Rectangle bounds;

    @Override
    public Document<?> toDocument() {
        // TODO
        return null;
    }

    @Override
    public void paint(Graphics g) {
        // TODO
    }

    private final Point location;

    public JunctionPoint(Point location) {
        this.location = location;
        width = 20;
        height = 20;
        this.bounds = new Rectangle(location.x - 10, location.y - 10, width, height);
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

    @Override
    public void hit(Point point, OnHitCallback onHitCallback) {
        if(bounds.contains(point)) {
            onHitCallback.hitSuccessful(new ElementHitEvent(ElementType.Connectee, this));
        }
    }
}
