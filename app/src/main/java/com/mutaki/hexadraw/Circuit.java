package com.mutaki.hexadraw;

import java.nio.file.Path;

public class Circuit {

    private final String circuitName;

    public Circuit(String circuitName) {
	this.circuitName = circuitName;
    }

    public String name() {
	return circuitName;
    }

    public CircuitDocument toDocument() {
	return new CircuitDocument(circuitName);
    }

    public void save(Path saveDirectory) {
	new JsonCircuitFileWriter(this).write(saveDirectory);
    }

}
