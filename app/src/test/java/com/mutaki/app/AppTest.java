package com.mutaki.app;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

public class AppTest {

    ApplicationRunner runner = new ApplicationRunner();

    @Test
    void App_runs() {
	runner.start();
	runner.addDiagram();
	runner.saveButtonHasText("Save");
    }

    @AfterEach
    void stop() {
	runner.stop();
    }
}
