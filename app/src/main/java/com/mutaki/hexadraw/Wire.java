package com.mutaki.hexadraw;

public class Wire {
    private final JunctionPoint junctionPoint1;
    private final JunctionPoint junctionPoint2;

    public Wire(JunctionPoint junctionPoint1, JunctionPoint junctionPoint2) {
        if(junctionPoint1.equals(junctionPoint2)) {
            throw new IllegalArgumentException("JunctionPoints must not be equal");
        }
        this.junctionPoint1 = junctionPoint1;
        this.junctionPoint2 = junctionPoint2;
    }
}
