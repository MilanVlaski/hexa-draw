package com.mutaki.hexadraw.canvas.state;

import com.mutaki.hexadraw.JunctionPoint;
import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.Wire;
import com.mutaki.hexadraw.model.events.ElementHitEvent;
import com.mutaki.hexadraw.model.Element;

import java.awt.*;

public class ConnectingElements implements CanvasState {
    private final Circuit circuit;
    private final CanvasPanel canvasPanel;
    private final com.mutaki.hexadraw.canvas.Canvas canvas;
    private final JunctionPoint junctionPoint;

    public ConnectingElements(JunctionPoint firstJunctionPoint, Circuit circuit, CanvasPanel canvasPanel, Canvas canvas) {
        this.circuit = circuit;
        this.canvasPanel = canvasPanel;
        this.canvas = canvas;
        this.junctionPoint = firstJunctionPoint;
    }

    @Override
    public void click(Point point) {
        circuit.hit(point, canvas);
    }

    @Override
    public void hitSuccessful(ElementHitEvent event) {
        // What happens when we hit a JunctionBox? Maybe connect to
        // one of its JunctionPoints?
        switch (event.elementType) {
            case Node -> {
                circuit.addElement(new Wire(junctionPoint, event.junctionPoint));
                canvasPanel.pleaseRepaint();
                canvas.resetState();
            }
        }
    }
}
