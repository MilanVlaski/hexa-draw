package com.mutaki.hexadraw;

import static com.mutaki.hexadraw.matchers.CircuitHasName.hasName;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.file.Files;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mutaki.hexadraw.JsonCircuitFileReader;

public class AppTest {

    ApplicationRunner runner = new ApplicationRunner();

    String circuitName = "Circuit_1";

    @BeforeEach
    void start() {
	runner.start();
    }

    @AfterEach
    void stop() {
	runner.stop();
    }

    @Test
    void Window_has_clickable_add_diagram_button() {
	runner.createCircuit(circuitName);
    }

    @Test
    void Creates_diagram_then_saves_it() throws IOException {
	var tempdir = Files.createTempDirectory("temp");
	var circuitFilePath = tempdir.resolve(circuitName + ".json");

	runner.createCircuit(circuitName);
	// first save leads to a prompt for location
	runner.save();
	runner.saveToLocation(tempdir);

	final var circuit = new JsonCircuitFileReader(circuitFilePath).read();
	assertThat(circuit, hasName(circuitName));
    }

}
