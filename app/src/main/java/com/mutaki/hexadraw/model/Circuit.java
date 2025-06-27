package com.mutaki.hexadraw.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import com.mutaki.hexadraw.canvas.OnHitCallback;
import com.mutaki.hexadraw.model.document.CircuitDocument;

public class Circuit implements Documentable<CircuitDocument> {

    private final String name;
    private final List<Element> elements;

    public Circuit(String name) {
        this(name, new ArrayList<>());
    }

    public Circuit(String name, List<Element> elements) {
        this.name = name;
        this.elements = elements;
    }

    /**
     * Can have spaces. May be different from the filename.
     */
    public String name() {
        return name;
    }

    @Override
    public CircuitDocument toDocument() {
        return new CircuitDocument(name, elements);
    }

    public boolean has(Class<?> elementType) {
        for (Element el : elements) {
            if (el.getClass().equals(elementType)) {
                return true;
            }
        }
        return false;
    }

    public void addElement(Element element) {
        elements.add(element);
    }

    public void paint(Graphics g) {
        elements.forEach(el -> el.paint(g));
    }

    // TODO extract to interface, called
    public void hit(Point point, OnHitCallback onHitCallback) {
        elements.forEach(el -> el.hit(point, onHitCallback));
    }
}
