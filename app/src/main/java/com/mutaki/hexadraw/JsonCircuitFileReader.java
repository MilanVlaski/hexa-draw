package com.mutaki.hexadraw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class JsonCircuitFileReader {

    private final Path circuitDocumentPath;
    private final Gson gson = new Gson();

    public JsonCircuitFileReader(Path circuitDocumentPath) {
	this.circuitDocumentPath = circuitDocumentPath;
    }

    public Circuit read() {
	try {
	    String json = Files.readString(circuitDocumentPath);
	    final var circuitDocument = gson.fromJson(json, CircuitDocument.class);
	    return circuitDocument.toCircuit();
	} catch (IOException e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
