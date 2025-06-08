package com.mutaki.hexadraw;

import java.util.ArrayList;
import java.util.List;

import com.mutaki.hexadraw.io.CircuitDocument;

public class Circuit {

    private final String name;
    private final List<Element> elements = new ArrayList<>();

    public Circuit(String name) {
	this.name = name;
    }

    /**
     * Can have spaces. May be different from the filename.
     */
    public String name() {
	return name;
    }

    public CircuitDocument toDocument() {
	return new CircuitDocument(name);
    }

    public boolean has(Class<?> elementType, At at) {
	for (Element el : elements) {
	    if (el.getClass().equals(elementType) && el.isAt(at.point)) {
		return true;
	    }
	}
	return false;
    }

}
