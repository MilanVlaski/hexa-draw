package com.mutaki.hexadraw.canvas.state;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.events.ElementHitEvent;

import java.awt.Point;

public class DefaultState implements CanvasState {

    private final Circuit circuit;
    private final Canvas canvas;

    public DefaultState(Circuit circuit, Canvas canvas) {
        this.circuit = circuit;
        this.canvas = canvas;
    }

    @Override
    public void click(Point point) {
        circuit.hit(point, canvas);
    }

    @Override
    public void hitSuccessful(ElementHitEvent elementHitEvent) {
        switch (elementHitEvent.elementType) {
            case Connectee -> {
                // Junction point is our one and only connectee for now :)
                canvas.startConnecting(elementHitEvent.junctionPoint);
            }
        }
    }
}
