package com.mutaki.hexadraw.canvas;

import java.awt.Point;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBoxFactory;

class PlacingState implements State {

    private final JunctionBoxFactory junctionBoxFactory;
    private final Circuit circuit;
    private final CanvasListener canvasListener;
    private final Canvas canvas;

    PlacingState(JunctionBoxFactory junctionBoxFactory, Circuit circuit,
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
