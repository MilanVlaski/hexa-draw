package com.mutaki.hexadraw.canvas;

import java.awt.Graphics;
import java.awt.Point;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBoxFactory;

public class Canvas {

    private final Circuit circuit;
    private CanvasListener canvasListener;
    private State state = new NothingState();

    public Canvas(Circuit circuit) {
	this.circuit = circuit;
    }

    public void clicked(Point point) {
	state.click(point);
    }

    public void addCanvasListener(CanvasListener canvasListener) {
	this.canvasListener = canvasListener;
    }

    public void toPlacingState(JunctionBoxFactory junctionBoxFactory) {
	this.state = new PlacingState(junctionBoxFactory, circuit, canvasListener, this);
    }

    public void resetState() {
	state = new NothingState();
    }

    public void paint(Graphics g) {
	circuit.paint(g);
    }

}
