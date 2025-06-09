package com.mutaki.hexadraw;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import com.mutaki.hexadraw.io.CircuitDocument;

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
	var documents = elements.stream().map(el -> el.toDocument()).toList();
	return new CircuitDocument(name, documents);
    }

    public boolean has(Class<?> elementType, At at) {
	for (Element el : elements) {
	    if (el.getClass().equals(elementType) && el.isAt(at.point)) {
		return true;
	    }
	}
	return false;
    }

    public void addElement(JunctionBox element) {
	elements.add(element);
    }

    public void paint(Graphics g) {
	elements.forEach(el -> el.paint(g));
    }

}
