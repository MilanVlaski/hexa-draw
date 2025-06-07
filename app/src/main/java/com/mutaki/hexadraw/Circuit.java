package com.mutaki.hexadraw;

import java.nio.file.Path;

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

    public void save(Path saveDirectory) {
	new JsonCircuitFileWriter(this).write(saveDirectory);
    }

}
