package com.mutaki.hexadraw.io;

import com.mutaki.hexadraw.Circuit;

// This thing should be serializable in some way!
public class CircuitDocument implements Reconstructible<Circuit> {

    public final String name;

    public CircuitDocument(String name) {
	this.name = name;
    }

    @Override
    public Circuit toModel() {
	return new Circuit(name);
    }

}
