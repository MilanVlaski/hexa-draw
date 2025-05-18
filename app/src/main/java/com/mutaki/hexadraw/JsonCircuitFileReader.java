package com.mutaki.hexadraw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class JsonCircuitFileReader {

    private final Path circuitFilePath;
    private final Gson gson = new Gson();

    public JsonCircuitFileReader(Path circuitFilePath) {
	this.circuitFilePath = circuitFilePath;
    }

    public Circuit read() {
	try {
	    String json = Files.readString(circuitFilePath);
	    final var circuitFile = gson.fromJson(json, CircuitFileJson.class);
	    return circuitFile.toCircuit();
	} catch (IOException e) {
	    e.printStackTrace();
	    return null;
	}
    }
}