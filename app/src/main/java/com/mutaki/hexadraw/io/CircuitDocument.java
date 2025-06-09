package com.mutaki.hexadraw.io;

import java.util.List;

import com.mutaki.hexadraw.Circuit;

// This thing should be serializable in some way!
public class CircuitDocument implements Document<Circuit> {

    public String name;
    public List<? extends Document<?>> elements;

    public CircuitDocument(String name, List<? extends Document<?>> documents) {
	this.name = name;
	this.elements = documents;
    }

    @Override
    public Circuit toModel() {
	return new Circuit(name);
    }

}
