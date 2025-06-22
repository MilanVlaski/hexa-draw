package com.mutaki.hexadraw.io.json;

import java.nio.file.Files;
import java.nio.file.Path;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.document.CircuitDocument;

public class JsonCircuitFileWriter {

    private final Circuit circuit;
    private final String FILE_EXTENSION = ".json";

    private final ObjectMapper mapper = CustomObjectMapper.mapper();

    public JsonCircuitFileWriter(Circuit circuit) {
        this.circuit = circuit;
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

    private String fileName() {
        return circuit.name() + FILE_EXTENSION;
    }

}
