package com.mutaki.hexadraw;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.google.gson.Gson;

public class JsonCircuitFileWriter {

    private final Gson gson = new Gson();

    private Circuit circuit;

    public JsonCircuitFileWriter(Circuit circuit) {
	this.circuit = circuit;
    }

    public void write(Path directory) {
	var dto = circuit.circuitFile();
	String json = gson.toJson(dto);
	try {
	    System.out.println("Creating directories: " + directory.toString());
	    Files.createDirectories(directory);
	    var filePath = directory.resolve(circuit.name() + ".json");
	    System.out.println("Writing to file: " + filePath.toString());
	    Files.writeString(filePath, json);
	} catch (IOException e) {
	    e.printStackTrace();
	}
    }

    public static void main(String... args) {
	new JsonCircuitFileWriter(new Circuit("name"))
	    .write(Path.of("C:\\Users\\milan\\Desktop"));
    }
}
