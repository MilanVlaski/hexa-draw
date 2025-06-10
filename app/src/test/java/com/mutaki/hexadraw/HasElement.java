package com.mutaki.hexadraw;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.mutaki.hexadraw.model.At;
import com.mutaki.hexadraw.model.Circuit;

public class HasElement extends TypeSafeDiagnosingMatcher<Circuit> {

    private final Class<?> elementType;
    private At at;

    public HasElement(Class<?> elementType, At position) {
	this.elementType = elementType;
	this.at = position;
    }

    @Override
    protected boolean matchesSafely(Circuit circuit, Description mismatchDescription) {
	if (circuit.has(elementType, at)) {
	    return true;
	}
	mismatchDescription.appendText("no matching element found");
	return false;
    }

    @Override
    public void describeTo(Description description) {
	description.appendText("a circuit with ")
	    .appendText(elementType.getSimpleName());
	if (at != null) {
	    description.appendText(" at " + at);
	}
    }

    public static HasElement hasElement(Class<?> elementType, At position) {
	return new HasElement(elementType, position);
    }
}
