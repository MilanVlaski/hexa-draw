package com.mutaki.hexadraw.model.document;

import java.util.List;

import com.mutaki.hexadraw.model.Circuit;

public class CircuitDocument implements Document<Circuit> {

    public String name;
    public List<? extends Document<?>> elements;

    CircuitDocument() {
    }

    public CircuitDocument(String name, List<? extends Document<?>> documents) {
	this.name = name;
	this.elements = documents;
    }

    @Override
    public Circuit toModel() {
	// TODO implement elements
	return new Circuit(name);
    }

}
