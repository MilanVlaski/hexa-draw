package com.mutaki.hexadraw.io.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.mutaki.hexadraw.model.document.CircuitDocument;
import com.mutaki.hexadraw.model.document.Document;
import com.mutaki.hexadraw.model.document.JunctionBoxDocument;

public class CustomObjectMapper {

    public static ObjectMapper mapper() {
	var mapper = new ObjectMapper()
	    .enable(SerializationFeature.INDENT_OUTPUT);
	mapper.registerSubtypes(
		new NamedType(JunctionBoxDocument.class, "junctionBox"),
		new NamedType(CircuitDocument.class, "circuit"));

	mapper.addMixIn(Document.class, DocumentSerializationMixin.class);

	return mapper;
    }
}
