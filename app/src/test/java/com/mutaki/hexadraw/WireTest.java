package com.mutaki.hexadraw;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.awt.*;

public class WireTest {

    @Test
    void Wire_cant_connect_two_identical_elements() {
        var junctionPoint = new Element(new Point(5, 5));
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Wire(junctionPoint, junctionPoint);
        });
    }

    @Test
    void Wire_cant_connect_two_equal_elements() {
        Point point = new Point(5, 5);
        var junctionPoint1 = new Element(point);
        var junctionPoint2 = new Element(point);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Wire(junctionPoint1, junctionPoint2);
        });
    }

    @Test
    void Wire_cant_connect_two_different_junction_with_different_but_equal_locations() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Wire(new Element(new Point(5, 5)), new Element(new Point(5, 5)));
        });
    }
}
