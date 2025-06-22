package com.mutaki.hexadraw;

import com.mutaki.hexadraw.io.json.JsonCircuitFileReader;
import com.mutaki.hexadraw.io.json.JsonCircuitFileWriter;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBox;
import org.junit.jupiter.api.Test;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class SerializationTest {

    String name = "CIRCUIT_ONE";
    Point point = new Point(5, 5);

    @Test
    void Object_from_model_to_document_back_to_model() throws IOException {
        // Use Path.of(""); if debugging
        Path saveDirectory =  Files.createTempDirectory("temp");
        var circuit = new Circuit(name, List.of(new JunctionBox(point)));
        new JsonCircuitFileWriter(circuit).write(saveDirectory);

        Path circuitFilePath = saveDirectory.resolve(name + ".json");
        var writeCircuit = new JsonCircuitFileReader(circuitFilePath).read();
        assertTrue(writeCircuit.has(JunctionBox.class));
    }
}
