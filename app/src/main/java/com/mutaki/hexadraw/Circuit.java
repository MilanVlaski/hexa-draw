package com.mutaki.hexadraw;

import com.mutaki.hexadraw.io.CircuitDocument;

public class Circuit {

    private final String name;

    public Circuit(String name) {
	this.name = name;
    }

    public String name() {
	return name;
    }

    public CircuitDocument toDocument() {
	return new CircuitDocument(name);
    }

}
