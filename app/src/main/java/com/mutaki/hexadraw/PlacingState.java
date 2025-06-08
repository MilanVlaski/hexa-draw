package com.mutaki.hexadraw;

import java.awt.Point;

public class PlacingState implements State {

    private JunctionBoxFactory junctionBoxFactory;
    private Circuit circuit;
    private CanvasListener canvasListener;

    public PlacingState(JunctionBoxFactory junctionBoxFactory, Circuit circuit,
	    CanvasListener canvasListener) {
	this.junctionBoxFactory = junctionBoxFactory;
	this.circuit = circuit;
	this.canvasListener = canvasListener;
    }

    @Override
    public void click(Point point) {
	var element = junctionBoxFactory.create(point);
	circuit.addElement(element);
	canvasListener.placeDrawingOf(element);
    }

}
