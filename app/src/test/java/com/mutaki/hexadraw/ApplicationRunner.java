package com.mutaki.hexadraw;

import java.nio.file.Path;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.FrameFixture;

public class ApplicationRunner {

    private FrameFixture window;
    private Robot robot;

    public void start() {
	// This must run before main is started!
	robot = BasicRobot.robotWithNewAwtHierarchy();

	executeMainMethodInNewThread();

	// Finds the Main Frame, by name, and enables testing
	window = WindowFinder.findFrame(ComponentNames.MAIN_FRAME).using(robot);
    }

    private void executeMainMethodInNewThread() {
	Thread thread = new Thread("Test Application") {
	    @Override
	    public void run() {
		try {
		    App.main(null);
		} catch (Exception e) {
		    e.printStackTrace();
		}
	    }
	};
	thread.setDaemon(true);
	thread.start();
    }

    public void addDiagram(String circuitName) {
	window.button(ComponentNames.ADD_DIAGRAM_BTN).click();
    }

    public void save() {
	window.button(ComponentNames.SAVE_BTN).click();
    }

    public void stop() {
	if (window != null) {
	    window.cleanUp();
	}
    }

    public void saveToLocation(Path path) {
	// TODO Auto-generated method stub

    }
}
