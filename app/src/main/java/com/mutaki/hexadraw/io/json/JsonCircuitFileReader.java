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

public class JsonCircuitFileReader {

    private final Path circuitDocumentPath;
    private final Gson gson = new Gson();

    private final ObjectMapper mapper = new ObjectMapper()
	    .enable(SerializationFeature.INDENT_OUTPUT);

    public JsonCircuitFileReader(Path circuitDocumentPath) {
	this.circuitDocumentPath = circuitDocumentPath;

	mapper.registerSubtypes(
		new NamedType(JunctionBoxDocument.class, "junctionBox"),
		new NamedType(CircuitDocument.class, "circuit"));

	mapper.addMixIn(Document.class, DocumentSerializationMixin.class);
    }

    public Circuit read() {
	try {
	    String json = Files.readString(circuitDocumentPath);
	    return mapper.readValue(json, CircuitDocument.class)
		.toModel();

//	    String json = Files.readString(circuitDocumentPath);
//	    final var circuitDocument = gson.fromJson(json, CircuitDocument.class);
//	    return circuitDocument.toModel();
	} catch (IOException e) {
	    e.printStackTrace();
	    return null;
	}
    }
}
