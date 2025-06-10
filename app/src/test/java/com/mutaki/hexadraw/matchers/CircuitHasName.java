package com.mutaki.hexadraw.matchers;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;

import com.mutaki.hexadraw.model.Circuit;

public class CircuitHasName extends TypeSafeMatcher<Circuit> {

    private final String circuitName;

    public CircuitHasName(String circuitName) {
	this.circuitName = circuitName;
    }

    @Override
    public void describeTo(Description description) {
	description.appendText("a circuit with name ").appendValue(circuitName);
    }

    @Override
    protected boolean matchesSafely(Circuit circuit) {
	return circuitName.equals(circuit.name());
    }

    public static CircuitHasName hasName(String name) {
	return new CircuitHasName(name);
    }
}
