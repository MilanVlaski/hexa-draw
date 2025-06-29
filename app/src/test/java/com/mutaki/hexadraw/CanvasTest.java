package com.mutaki.hexadraw;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBox;
import com.mutaki.hexadraw.model.JunctionBoxFactory;
import com.mutaki.hexadraw.model.Wire;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.Set;

import static org.mockito.Mockito.*;

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

    @Test
    void Connects_two_junction_boxes() {
        var jbox1Location = new Point(7, 7);
        var jbox2Location = new Point(57, 57);
        var jpoint1Location = new Point(17, 17);
        var jpoint2Location = new Point(67, 67);


        var jboxFactory = mock(JunctionBoxFactory.class);
        var canvasPanel = mock(CanvasPanel.class);

        Circuit circuit = new Circuit("New Circuit");
        var circuitSpy = spy(circuit);
        // Spy will tell us if a Wire was added.
        Canvas canvas = new Canvas(circuitSpy);
        canvas.addCanvasPanel(canvasPanel);

        when(jboxFactory.create(jbox1Location)).thenReturn(
            new JunctionBox(jbox1Location, Set.of(new JunctionPoint(jpoint1Location)))
        );
        when(jboxFactory.create(jbox2Location)).thenReturn(
            new JunctionBox(jbox2Location, Set.of(new JunctionPoint(jpoint2Location)))
        );

        canvas.startPlacing(jboxFactory);
        canvas.clicked(jbox1Location);

        canvas.startPlacing(jboxFactory);
        canvas.clicked(jbox2Location);

        canvas.clicked(jpoint1Location);
        canvas.clicked(jpoint2Location);

        verify(circuitSpy).addElement(any(Wire.class));
    }

}
