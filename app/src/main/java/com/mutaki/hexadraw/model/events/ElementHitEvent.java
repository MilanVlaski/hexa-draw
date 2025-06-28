package com.mutaki.hexadraw.model.events;

import com.mutaki.hexadraw.JunctionPoint;

public class ElementHitEvent {
    public final ElementType elementType;
    public final JunctionPoint junctionPoint;

    public ElementHitEvent(ElementType elementType, JunctionPoint junctionPoint) {
        this.elementType = elementType;
        this.junctionPoint = junctionPoint;
    }
}
