package com.mutaki.hexadraw.model.events;

import com.mutaki.hexadraw.model.Element;

public class ElementHitEvent {
    public final ElementType elementType;
    public final Element junctionPoint;

    public ElementHitEvent(ElementType elementType, Element junctionPoint) {
        this.elementType = elementType;
        this.junctionPoint = junctionPoint;
    }
}
