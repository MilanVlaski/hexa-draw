package com.mutaki.hexadraw;

import static com.mutaki.hexadraw.matchers.CircuitHasName.hasName;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

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
    void Window_has_clickable_create_circuit_button() {
	runner.createCircuit();
    }

    @Test
    void Circuit_without_location_prompts_for_location_on_save() throws IOException {
	Path saveDirectory = Files.createTempDirectory("temp");
	Path circuitFilePath = saveDirectory.resolve(circuitName + ".json");

	runner.createCircuit();
	runner.nameCircuit(circuitName);
	runner.confirm();
	// first save leads to a prompt for location
	runner.saveAll();
	runner.saveToLocation(saveDirectory);

	final Circuit circuit = new JsonCircuitFileReader(circuitFilePath).read();
	assertThat(circuit, hasName(circuitName));
    }

    @Test
//    @Disabled("TODO")
    void Creates_circuit_with_location_then_saves_it_there() throws IOException {
	Path saveDirectory = Files.createTempDirectory("temp");
	Path circuitFilePath = saveDirectory.resolve(circuitName + ".json");

	runner.createCircuit();
	runner.nameCircuit(circuitName);
	runner.pickCircuitDirectory(saveDirectory);
	runner.confirm();

	runner.saveAll();

	final Circuit circuit = new JsonCircuitFileReader(circuitFilePath).read();
	assertThat(circuit, hasName(circuitName));
    }

}