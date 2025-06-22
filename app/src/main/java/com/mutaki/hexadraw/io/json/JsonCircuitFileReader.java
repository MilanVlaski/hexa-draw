package com.mutaki.hexadraw.io.json;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.document.CircuitDocument;

public class JsonCircuitFileReader {

    private final Path circuitDocumentPath;
    private final Gson gson = new Gson();

    private final ObjectMapper mapper = CustomObjectMapper.mapper();

    public JsonCircuitFileReader(Path circuitDocumentPath) {
        this.circuitDocumentPath = circuitDocumentPath;
    }

    public Circuit read() {
        try {
            String json = Files.readString(circuitDocumentPath);
            return mapper.readValue(json, CircuitDocument.class)
                .toModel();
        } catch (IOException e) {
            // TODO this can't be handled here. Rethrow as runtime?
            e.printStackTrace();
            return null;
        }
    }
}
