package com.mutaki.hexadraw.model;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import com.mutaki.hexadraw.canvas.OnHitListener;
import com.mutaki.hexadraw.model.document.CircuitDocument;

public class Circuit implements Documentable<CircuitDocument> {

    private final String name;
    private final List<Element> elements;

    public Circuit(String name) {
        this(name, new CopyOnWriteArrayList<>());
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

    public void hit(Point point, OnHitListener onHitListener) {
        elements.forEach(el -> el.hit(point, onHitListener));
    }
}
