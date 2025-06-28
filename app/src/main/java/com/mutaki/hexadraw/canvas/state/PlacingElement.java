package com.mutaki.hexadraw.canvas.state;

import java.awt.Point;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.events.ElementHitEvent;
import com.mutaki.hexadraw.model.JunctionBoxFactory;

public class PlacingElement implements CanvasState {

    private final JunctionBoxFactory junctionBoxFactory;
    private final Circuit circuit;
    private final CanvasPanel canvasPanel;
    private final Canvas canvas;

    // This JBox factory is probably an abstraction called SoloElementFactory or
    // ElementFactory. Shuld stay like this because I don't know if Placing only
    // applies to single elements, or single elements AND connectors.
    public PlacingElement(JunctionBoxFactory junctionBoxFactory, Circuit circuit,
                          CanvasPanel canvasPanel, Canvas canvas) {
        this.junctionBoxFactory = junctionBoxFactory;
        this.circuit = circuit;
        this.canvasPanel = canvasPanel;
        this.canvas = canvas;
    }

    @Override
    public void click(Point point) {
        // This assumes it's ok to place an element wherever you click.
        // Adding elements on top of each other is rarely an issue.
        // But could be troublesome in the future, for determining which one was  selected.
        var element = junctionBoxFactory.create(point);
        circuit.addElement(element);
        canvasPanel.pleaseRepaint();
        canvas.resetState();
    }

    @Override
    public void hitSuccessful(ElementHitEvent elementHitEvent) {

    }
}
