package com.mutaki.hexadraw.canvas;

import java.awt.Graphics;
import java.awt.Point;

import com.mutaki.hexadraw.JunctionPoint;
import com.mutaki.hexadraw.canvas.state.CanvasState;
import com.mutaki.hexadraw.canvas.state.ConnectingElements;
import com.mutaki.hexadraw.canvas.state.DefaultState;
import com.mutaki.hexadraw.canvas.state.PlacingElement;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.events.ElementHitEvent;
import com.mutaki.hexadraw.model.JunctionBoxFactory;
import com.mutaki.hexadraw.model.Element;

public class Canvas implements OnHitListener {

    private final Circuit circuit;
    private CanvasPanel canvasPanel;
    private CanvasState state;

    public Canvas(Circuit circuit) {
        this.circuit = circuit;
        this.state = new DefaultState(circuit, this);
    }

    public void clicked(Point point) {
        state.click(point);
    }

    public void addCanvasPanel(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;
    }

    public void startPlacing(JunctionBoxFactory junctionBoxFactory) {
        this.state = new PlacingElement(junctionBoxFactory, circuit, canvasPanel, this);
    }

    public void resetState() {
        state = new DefaultState(circuit, this);
    }

    public void paint(Graphics g) {
        circuit.paint(g);
    }

    @Override
    public void hitSuccessful(ElementHitEvent elementHitEvent) {
        state.hitSuccessful(elementHitEvent);
    }

    public void startConnecting(JunctionPoint junctionPoint) {
        this.state = new ConnectingElements(junctionPoint, circuit, canvasPanel, this);
    }
}
