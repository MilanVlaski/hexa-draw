package com.mutaki.hexadraw;

import com.mutaki.hexadraw.canvas.OnHitListener;
import com.mutaki.hexadraw.model.Element;
import com.mutaki.hexadraw.model.events.ElementHitEvent;
import com.mutaki.hexadraw.model.events.ElementType;
import com.mutaki.hexadraw.model.document.Document;

import java.awt.*;

public class JunctionPoint implements Element {

    private final int width;
    private final int height;
    private final Rectangle bounds;
    private final Point location;
    private final Point topLeft;


    @Override
    public Document<?> toDocument() {
        // TODO
        return null;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawOval(topLeft.x, topLeft.y, width, height);
    }

    public JunctionPoint(Point location) {
        this.location = location;
        this.width = 20;
        this.height = 20;
        this.topLeft = location.getLocation();
        topLeft.translate(-width/2, -height/2);

        this.bounds = new Rectangle(topLeft.x, topLeft.y, width, height);
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
    public void hit(Point point, OnHitListener onHitListener) {
        if(bounds.contains(point)) {
            onHitListener.hitSuccessful(new ElementHitEvent(ElementType.Node, this));
        }
    }
}
