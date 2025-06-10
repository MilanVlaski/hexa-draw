package com.mutaki.hexadraw.canvas;

import java.awt.Point;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBox;
import com.mutaki.hexadraw.model.JunctionBoxFactory;

public class PlacingState implements State {

    private JunctionBoxFactory junctionBoxFactory;
    private Circuit circuit;
    private CanvasListener canvasListener;
    private Canvas canvas;

    public PlacingState(JunctionBoxFactory junctionBoxFactory, Circuit circuit,
	    CanvasListener canvasListener, Canvas canvas) {
	this.junctionBoxFactory = junctionBoxFactory;
	this.circuit = circuit;
	this.canvasListener = canvasListener;
	this.canvas = canvas;
    }

    @Override
    public void click(Point point) {
	var element = junctionBoxFactory.create(point);
	circuit.addElement(element);
	canvasListener.pleaseRepaint();
	canvas.resetState();
    }

}
