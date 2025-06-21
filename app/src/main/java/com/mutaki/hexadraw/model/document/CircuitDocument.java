package com.mutaki.hexadraw.model.document;

import java.util.List;

import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.Element;

public class CircuitDocument implements Document<Circuit> {

    public String name;
    public List<Document<Element>> elements;

    CircuitDocument() {
    }

    @SuppressWarnings("unchecked")
    public CircuitDocument(String name,
	    List<Element> elements) {
	this.name = name;
	this.elements = elements.stream()
	    .map(el -> (Document<Element>) el.toDocument())
	    .toList();
    }

    @Override
    public Circuit toModel() {
	var els = elements
	    .stream()
	    .map(Document::toModel)
	    .toList();
	return new Circuit(name, els);
    }

}
