package com.mutaki.hexadraw;

import org.hamcrest.Description;
import org.hamcrest.TypeSafeDiagnosingMatcher;

import com.mutaki.hexadraw.model.Circuit;

public class HasElement extends TypeSafeDiagnosingMatcher<Circuit> {
    private final Class<?> elementType;

    public HasElement(Class<?> elementType) {
	this.elementType = elementType;
    }

    @Override
    protected boolean matchesSafely(Circuit circuit, Description mismatchDescription) {
	if (circuit.has(elementType)) {
	    return true;
	}
	mismatchDescription.appendText(
		"no element of type " + elementType.getSimpleName() + " found");
	return false;
    }

    @Override
    public void describeTo(Description description) {
	description.appendText("a circuit with a")
	    .appendText(elementType.getSimpleName());
    }

    public static HasElement hasElement(Class<?> elementType) {
	return new HasElement(elementType);
    }

//    public static HasElement hasElement(Class<?> elementType, At position) {
//	return new HasElement(elementType, position);
//    }

}
