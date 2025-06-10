package com.mutaki.hexadraw.views;

import java.nio.file.Path;
import java.util.Optional;

public class DialogResult {

    public final String name;
    public final Optional<Path> location;

    DialogResult(String name, Optional<Path> location) {
	this.name = name;
	this.location = location;
    }

}
