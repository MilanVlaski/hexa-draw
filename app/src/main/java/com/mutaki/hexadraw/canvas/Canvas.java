package com.mutaki.hexadraw.canvas;

import java.awt.Graphics;
import java.awt.Point;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.ElementHitEvent;
import com.mutaki.hexadraw.model.JunctionBoxFactory;
import com.mutaki.hexadraw.model.Element;

public class Canvas implements OnHitCallback {

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

    void resetState() {
        state = new DefaultState(circuit, this);
    }

    public void paint(Graphics g) {
        circuit.paint(g);
    }

    @Override
    public void hitSuccessful(ElementHitEvent elementHitEvent) {
        state.hitSuccessful(elementHitEvent);
    }

    public void startConnecting(Element junctionPoint) {
        this.state = new ConnectingElements(junctionPoint, circuit, canvasPanel, this);
    }
}
