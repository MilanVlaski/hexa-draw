package com.mutaki.hexadraw.model;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;
import java.util.Set;

import com.mutaki.hexadraw.JunctionPoint;
import com.mutaki.hexadraw.canvas.OnHitListener;
import com.mutaki.hexadraw.model.document.Document;
import com.mutaki.hexadraw.model.document.JunctionBoxDocument;

public class JunctionBox implements Element {

    // Please refrain from using the default width and height outside of constructors
    private static final int defaultWidth = 200;
    private static final int defaultHeight = 100;

    private final int width;
    private final int height;
    private final Point location;
    private final Rectangle bounds;
    private final Set<JunctionPoint> junctionPoints;

    public JunctionBox(Point location) {
        this(location, junctionPoints(location, defaultWidth, defaultHeight), defaultWidth, defaultHeight);
    }

    public JunctionBox(Point location, Set<JunctionPoint> junctionPoints) {
        this(location, junctionPoints, defaultWidth, defaultHeight);
    }

    public JunctionBox(Point location, Set<JunctionPoint> junctionPoints, int width, int height) {
        this.location = location;
        this.junctionPoints = junctionPoints;
        this.width = width;
        this.height = height;
        this.bounds = new Rectangle(location.x - width / 2, location.y - height / 2, width, height);
    }

    private static Set<JunctionPoint> junctionPoints(Point location, int width, int height) {
        // 1. Mutable apis suck
        // 2. point.moveLeft(10) returning a Point, would be great,
        // requires custom work
        // etc etc
        Point top = location.getLocation();
        Point bottom = location.getLocation();
        Point right = location.getLocation();
        Point left = location.getLocation();

        int offset = 15;
        top.translate(0, -(height / 2 + offset));
        bottom.translate(0, height / 2 + offset);
        right.translate(width / 2 + offset, 0);
        left.translate(-(width / 2 + offset), 0);
        return Set.of(
            new JunctionPoint(top),
            new JunctionPoint(right),
            new JunctionPoint(bottom),
            new JunctionPoint(left)
        );
    }

    @Override
    public Document<JunctionBox> toDocument() {
        return new JunctionBoxDocument(location);
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(bounds);
        g2d.setColor(Color.BLACK);
        g2d.draw(bounds);

        drawElectricitySymbol(g2d);
        junctionPoints.forEach(p -> p.paint(g2d));
    }


    private void drawElectricitySymbol(Graphics2D g2d) {
        int size = 50; // Fixed size for symbol

        // Create the lightning bolt path
        Path2D.Double bolt = new Path2D.Double();

        // Points for lightning bolt shape (relative to center)
        double[] xPoints = {0, -0.4, -0.1, 0.4, 0.1, 0};
        double[] yPoints = {-0.8, 0, 0, 0.8, 0.8, 0};

        // Scale and position points
        bolt.moveTo(location.x + xPoints[0] * size, location.y + yPoints[0] * size);
        for (int i = 1; i < xPoints.length; i++) {
            bolt.lineTo(location.x + xPoints[i] * size, location.y + yPoints[i] * size);
        }
        bolt.closePath();

        // Draw the bolt
        g2d.setColor(Color.YELLOW);
        g2d.fill(bolt);
        g2d.setColor(Color.BLACK);
        g2d.draw(bolt);
    }

    @Override
    public void hit(Point point, OnHitListener onHitListener) {
        junctionPoints.forEach(junctionPoint -> junctionPoint.hit(point, onHitListener));
    }
}
