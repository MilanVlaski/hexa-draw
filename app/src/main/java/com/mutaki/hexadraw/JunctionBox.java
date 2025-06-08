package com.mutaki.hexadraw;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

public class JunctionBox implements Element {

    private Point location;

    public JunctionBox(Point location) {
	this.location = location;
    }

    @Override
    public boolean isAt(Point point) {
	return location.equals(point);
    }

    @Override
    public JPanel draw() {
	var drawing = new JunctionBoxDrawing();
	// This places it in a flex layout in the parent panel, which is the JPanel
	// default.
	// But when done in the constructor, it places in properly.
//	drawing.setLocation(location);
	return drawing;
    }

    public class JunctionBoxDrawing extends JPanel {
	@Override
	    protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		setLocation(location);
		// Enable anti-aliasing for smoother edges
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);

		// Draw the rectangle
		Rectangle rect = new Rectangle(50, 50, 200, 100);
		g2d.setColor(Color.LIGHT_GRAY);
		g2d.fill(rect);
		g2d.setColor(Color.BLACK);
		g2d.draw(rect);

		// Draw the electricity symbol (lightning bolt)
		drawElectricitySymbol(g2d, rect);
	    }

	    private void drawElectricitySymbol(Graphics2D g2d, Rectangle bounds) {
		// Calculate dimensions relative to rectangle
		int centerX = bounds.x + bounds.width / 2;
		int centerY = bounds.y + bounds.height / 2;
		int size = Math.min(bounds.width, bounds.height) * 2 / 3;

		// Create the lightning bolt path
		Path2D.Double bolt = new Path2D.Double();

		// Points for the lightning bolt shape
		double[] xPoints = { 0, -0.4, -0.1, 0.4, 0.1, 0 };
		double[] yPoints = { -0.8, 0, 0, 0.8, 0.8, 0 };

		// Scale and position the points
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
    }

}
