package com.mutaki.hexadraw.canvas;

import java.awt.Point;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBoxFactory;

class PlacingElement implements CanvasState {

    private final JunctionBoxFactory junctionBoxFactory;
    private final Circuit circuit;
    private final CanvasPanel canvasPanel;
    private final Canvas canvas;

    PlacingElement(JunctionBoxFactory junctionBoxFactory, Circuit circuit,
                   CanvasPanel canvasPanel, Canvas canvas) {
        this.junctionBoxFactory = junctionBoxFactory;
        this.circuit = circuit;
        this.canvasPanel = canvasPanel;
        this.canvas = canvas;
    }

    @Override
    public void click(Point point) {
        var element = junctionBoxFactory.create(point);
        circuit.addElement(element);
        canvasPanel.pleaseRepaint();
        canvas.resetState();
    }

}
