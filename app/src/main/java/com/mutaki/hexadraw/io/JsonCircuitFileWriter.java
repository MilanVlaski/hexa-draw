package com.mutaki.hexadraw.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;
import com.mutaki.hexadraw.Circuit;

public class JsonCircuitFileWriter {

    private Circuit circuit;
    private final Gson gson = new Gson();
    private final String FILE_EXTENSION = ".json";

    public JsonCircuitFileWriter(Circuit circuit) {
	this.circuit = circuit;
    }

    public void write(Path directory) {
	var dto = new CircuitDocument(circuit.name());
	String json = gson.toJson(dto);
	try {
	    Files.createDirectories(directory);
	    var filePath = directory.resolve(fileName());
	    Files.writeString(filePath, json);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    private String fileName() {
	return circuit.name() + FILE_EXTENSION;
    }

    public static void main(String... args) {
	new JsonCircuitFileWriter(new Circuit("name"))
	    .write(Path.of("C:\\Users\\milan\\Desktop"));
    }
}
