package com.mutaki.hexadraw;

public class CircuitFileJson {

    public String name;

    public CircuitFileJson(String circuitName) {
	this.name = circuitName;
    }

    public Circuit toCircuit() {
	return new Circuit(name);
    }

}
