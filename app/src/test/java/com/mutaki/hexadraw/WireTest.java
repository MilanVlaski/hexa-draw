package com.mutaki.hexadraw;

import com.mutaki.hexadraw.model.Wire;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class WireTest {

    @Test
    void Wire_cant_connect_two_identical_elements() {
        var junctionPoint = new JunctionPoint(new Point(5, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Wire(junctionPoint, junctionPoint);
        });
    }

    @Test
    void Wire_cant_connect_two_equal_elements() {
        Point point = new Point(5, 5);
        var junctionPoint1 = new JunctionPoint(point);
        var junctionPoint2 = new JunctionPoint(point);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Wire(junctionPoint1, junctionPoint2);
        });
    }

    @Test
    void Wire_cant_connect_two_different_junction_with_different_but_equal_locations() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Wire(new JunctionPoint(new Point(5, 5)), new JunctionPoint(new Point(5, 5)));
        });
    }
}
