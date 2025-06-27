package com.mutaki.hexadraw.model;

public class ElementHitEvent {
    public final ElementType elementType;
    public final Element junctionPoint;

    public ElementHitEvent(ElementType elementType, Element junctionPoint) {
        this.elementType = elementType;
        this.junctionPoint = junctionPoint;
    }
}
