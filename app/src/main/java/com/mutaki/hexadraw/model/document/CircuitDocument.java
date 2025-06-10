package com.mutaki.hexadraw.model.document;

import java.util.List;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.Element;

public class CircuitDocument implements Document<Circuit> {

    public String name;
    public List<? extends Document<Element>> elements;

    CircuitDocument() {
    }

    public CircuitDocument(String name,
	    List<Element> elements) {
	this.name = name;
	this.elements = (List<? extends Document<Element>>) elements.stream()
	    .map(el -> el.toDocument())
	    .toList();
    }

    @Override
    public Circuit toModel() {
	var els = elements
	    .stream()
	    .map(el -> el.toModel())
	    .toList();
	return new Circuit(name, els);
    }

}
