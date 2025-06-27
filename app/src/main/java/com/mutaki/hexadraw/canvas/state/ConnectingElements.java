package com.mutaki.hexadraw.canvas.state;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.events.ElementHitEvent;
import com.mutaki.hexadraw.model.Element;

import java.awt.*;

public class ConnectingElements implements CanvasState {
    private final Circuit circuit;
    private final CanvasPanel canvasPanel;
    private final com.mutaki.hexadraw.canvas.Canvas canvas;
    private final Element junctionPoint;

    public ConnectingElements(Element firstJunctionPoint, Circuit circuit, CanvasPanel canvasPanel, Canvas canvas) {
        this.circuit = circuit;
        this.canvasPanel = canvasPanel;
        this.canvas = canvas;
        this.junctionPoint = firstJunctionPoint;
    }

    @Override
    public void click(Point point) {

    }

    @Override
    public void hitSuccessful(ElementHitEvent elementHitEvent) {

    }
}
