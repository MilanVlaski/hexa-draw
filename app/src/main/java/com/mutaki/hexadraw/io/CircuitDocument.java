package com.mutaki.hexadraw.io;

import com.mutaki.hexadraw.Circuit;

// This thing should be serializable in some way!
public class CircuitDocument {

    public String name;

    public CircuitDocument(String circuitName) {
	this.name = circuitName;
    }

    public Circuit toCircuit() {
	return new Circuit(name);
    }

}
