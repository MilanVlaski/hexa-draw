package com.mutaki.hexadraw;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBoxFactory;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.inOrder;

public class CanvasTest {

    @Test
    void Canvas_draws_junction_box_at_click_point() {
        var point = new java.awt.Point(5, 5);
        var canvasPanel = mock(CanvasPanel.class);
        var jboxFactory = mock(JunctionBoxFactory.class);

        Circuit circuit = new Circuit("New Circuit");
        Canvas canvas = new Canvas(circuit);
        canvas.addCanvasPanel(canvasPanel);

        canvas.startPlacing(jboxFactory);
        canvas.clicked(point);

        var inOrder = inOrder(jboxFactory, canvasPanel);
        inOrder.verify(jboxFactory).create(point);
        inOrder.verify(canvasPanel).pleaseRepaint();
    }

}
