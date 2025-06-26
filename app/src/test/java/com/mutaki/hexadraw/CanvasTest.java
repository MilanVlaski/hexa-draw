package com.mutaki.hexadraw;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.canvas.CanvasPanel;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBox;
import com.mutaki.hexadraw.model.JunctionBoxFactory;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.awt.*;

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
    @Disabled("To do.")
    void Connects_two_junction_boxes() {
        var jbox1Location = new Point(7, 7);
        var jbox2Location = new Point(57, 57);
        var jpoint1Location = new Point(17, 17);
        var jpoint2Location = new Point(67, 67);


        var jboxFactory = mock(JunctionBoxFactory.class);
        var canvasPanel = mock(CanvasPanel.class);
        var circuit = mock(Circuit.class);


        when(jboxFactory.create(jbox1Location)).thenReturn(
            new JunctionBox(jbox1Location, new JunctionPoint(jpoint1Location))
        );
        when(jboxFactory.create(jbox2Location)).thenReturn(
            new JunctionBox(jbox2Location, new JunctionPoint(jpoint2Location))
        );

        Canvas canvas = new Canvas(circuit);

        canvas.addCanvasPanel(canvasPanel);

        canvas.startPlacing(jboxFactory);
        canvas.clicked(jbox1Location);

        canvas.startPlacing(jboxFactory);
        canvas.clicked(jbox2Location);

        canvas.clicked(jpoint1Location);
        canvas.clicked(jpoint2Location);

        verify(circuit).addElement(any(Wire.class));
    }

}
