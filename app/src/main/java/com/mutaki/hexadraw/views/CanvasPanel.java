package com.mutaki.hexadraw.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasListener;

public class CanvasPanel extends JPanel implements MouseListener, CanvasListener {

    private final Canvas canvas;

    public CanvasPanel(Canvas canvas) {
	super();
	this.canvas = canvas;
	setName(ComponentNames.DIAGRAM_PANEL);
	// Ah yes. Listen to yourself.
	addMouseListener(this);
    }

    protected void paintComponent(Graphics g) {
	super.paintComponent(g);
	Graphics2D g2d = (Graphics2D) g;
	g2d.setFont(new Font("Arial", Font.PLAIN, 12));
	g2d.drawString("Circuit opened!", 50, 50);
	setBackground(Color.cyan);
	canvas.paint(g);
    }


    // Mouse pressed gives a more snappy feeling. * Tremendous *
    @Override
    public void mousePressed(MouseEvent e) {
	canvas.clicked(e.getPoint());
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void pleaseRepaint() {
	repaint();
    }


    @Override
    public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub

    }

}
