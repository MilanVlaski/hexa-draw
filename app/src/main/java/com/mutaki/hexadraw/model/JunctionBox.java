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
import com.mutaki.hexadraw.canvas.OnHitCallback;
import com.mutaki.hexadraw.model.document.Document;
import com.mutaki.hexadraw.model.document.JunctionBoxDocument;

public class JunctionBox implements Element {

    private final int width;
    private final int height;
    private final Point location;
    private final Rectangle bounds;
    private final Set<JunctionPoint> junctionPoints;

    public JunctionBox(Point location) {
        this(location, junctionPoints(location));
    }

    // TODO make this give appropriate default Junction points
    private static Set<JunctionPoint> junctionPoints(Point location) {
        return Set.of(new JunctionPoint(location));
    }

    public JunctionBox(Point location, Set<JunctionPoint> junctionPoints) {
        this.location = location;
        this.junctionPoints = junctionPoints;
        this.width = 200;
        this.height = 100;
        this.bounds = new Rectangle(location.x - width/2, location.y - height/2, width, height);
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

        // Calculate centered rectangle position (200x100)
        int rectX = location.x - 100; // Center horizontally
        int rectY = location.y - 50; // Center vertically
        // Draw the rectangle
        g2d.setColor(Color.LIGHT_GRAY);
        g2d.fill(bounds);
        g2d.setColor(Color.BLACK);
        g2d.draw(bounds);

        // Draw the electricity symbol centered at location
        drawElectricitySymbol(g2d);
    }


    private void drawElectricitySymbol(Graphics2D g2d) {
        int centerX = location.x;
        int centerY = location.y;
        int size = 50; // Fixed size for symbol

        // Create the lightning bolt path
        Path2D.Double bolt = new Path2D.Double();

        // Points for lightning bolt shape (relative to center)
        double[] xPoints = {0, -0.4, -0.1, 0.4, 0.1, 0};
        double[] yPoints = {-0.8, 0, 0, 0.8, 0.8, 0};

        // Scale and position points
        bolt.moveTo(centerX + xPoints[0] * size, centerY + yPoints[0] * size);
        for (int i = 1; i < xPoints.length; i++) {
            bolt.lineTo(centerX + xPoints[i] * size, centerY + yPoints[i] * size);
        }
        bolt.closePath();

        // Draw the bolt
        g2d.setColor(Color.YELLOW);
        g2d.fill(bolt);
        g2d.setColor(Color.BLACK);
        g2d.draw(bolt);
    }

    @Override
    public void hit(Point point, OnHitCallback onHitCallback) {
        junctionPoints.forEach(junctionPoint -> junctionPoint.hit(point, onHitCallback));
    }
}
