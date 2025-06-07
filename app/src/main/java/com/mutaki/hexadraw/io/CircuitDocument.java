package com.mutaki.hexadraw.io;

import com.mutaki.hexadraw.Circuit;

public class CircuitDocument {

    public String name;

    public CircuitDocument(String circuitName) {
	this.name = circuitName;
    }

    public Circuit toCircuit() {
	return new Circuit(name);
    }

}
