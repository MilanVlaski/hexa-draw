package com.mutaki.hexadraw;

import java.awt.Point;

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
	this.state = new PlacingState(junctionBoxFactory, circuit, canvasListener);
    }

}
