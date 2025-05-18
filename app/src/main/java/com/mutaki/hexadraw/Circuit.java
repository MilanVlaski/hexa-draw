package com.mutaki.hexadraw;

public class Circuit {

    private final String circuitName;

    public Circuit(String circuitName) {
	this.circuitName = circuitName;
    }

    public String name() {
	return circuitName;
    }

    public CircuitFileJson circuitFile() {
	return new CircuitFileJson(circuitName);
    }

}
