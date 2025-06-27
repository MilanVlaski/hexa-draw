package com.mutaki.hexadraw.views;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class CanvasJPanel extends JPanel implements MouseListener, CanvasPanel {

    private static final long serialVersionUID = 2625879956344043096L;

    private final Canvas canvas;

    public CanvasJPanel(Canvas canvas) {
        this.canvas = canvas;
        setName(ComponentNames.DIAGRAM_PANEL);
        // Maybe the mouse listener events get sent to canvas..
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
