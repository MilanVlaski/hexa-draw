package com.mutaki.hexadraw;

import static com.mutaki.hexadraw.HasElement.hasElement;
import static com.mutaki.hexadraw.matchers.CircuitHasName.hasName;
import static org.hamcrest.MatcherAssert.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.mutaki.hexadraw.io.json.JsonCircuitFileReader;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBox;

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
    void Circuit_without_location_prompts_for_location_on_save() throws IOException {
	Path saveDirectory = Files.createTempDirectory("temp");
// The test maybe shouldn't know that we use json. It should be in configuration. but who cares
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

    @Test
    void Puts_a_junction_box_on_circuit_at_x_y() throws IOException {
	Path saveDirectory = Files.createTempDirectory("temp");
	Path circuitFilePath = saveDirectory.resolve(circuitName + ".json");

	runner.createCircuit();
	runner.nameCircuit(circuitName);
	runner.pickCircuitDirectory(saveDirectory);
	runner.confirm();

	runner.selectJunctionBox();
	runner.clickOnCanvas();

	runner.saveAll();

	final Circuit circuit = new JsonCircuitFileReader(circuitFilePath).read();
	assertThat(circuit, hasElement(JunctionBox.class));
    }
}
