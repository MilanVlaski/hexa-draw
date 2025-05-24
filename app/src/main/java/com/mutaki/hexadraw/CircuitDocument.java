package com.mutaki.hexadraw;

public class CircuitDocument {

    public String name;

    public CircuitDocument(String circuitName) {
	this.name = circuitName;
    }

    public Circuit toCircuit() {
	return new Circuit(name);
    }

}
