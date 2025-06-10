package com.mutaki.hexadraw.io.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.google.gson.Gson;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.document.CircuitDocument;
import com.mutaki.hexadraw.model.document.Document;
import com.mutaki.hexadraw.model.document.JunctionBoxDocument;

public class JsonCircuitFileWriter {

    private Circuit circuit;
    private final Gson gson = new Gson();
    private final String FILE_EXTENSION = ".json";

    // Jackson suports polymorphism better than Gson!
    private final ObjectMapper mapper = new ObjectMapper()
	.enable(SerializationFeature.INDENT_OUTPUT);

    public JsonCircuitFileWriter(Circuit circuit) {
	this.circuit = circuit;
	mapper.registerSubtypes(
		new NamedType(JunctionBoxDocument.class, "junctionBox"),
		new NamedType(CircuitDocument.class, "circuit"));

	mapper.addMixIn(Document.class, DocumentSerializationMixin.class);
    }

    public void write(Path directory) {
	try {
	    CircuitDocument document = circuit.toDocument();
	    String json = mapper.writeValueAsString(document);
	    Files.createDirectories(directory);
	    Files.write(directory.resolve(fileName()), json.getBytes());
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

//    public void write(Path directory) {
//	var document = circuit.toDocument();
//	String json = gson.toJson(document);
//	try {
//	    Files.createDirectories(directory);
//	    var filePath = directory.resolve(fileName());
//	    Files.writeString(filePath, json);
//	} catch (IOException e) {
//	    e.printStackTrace();
//	}
//    }

    private String fileName() {
	return circuit.name() + FILE_EXTENSION;
    }

    public static void main(String... args) throws IOException {
	new JsonCircuitFileWriter(new Circuit("name"))
	    .write(Path.of("C:\\Users\\milan\\Desktop"));
    }
}
