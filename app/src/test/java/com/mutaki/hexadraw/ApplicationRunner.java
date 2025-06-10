package com.mutaki.hexadraw;

import java.awt.Point;
import java.nio.file.Path;

import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.finder.WindowFinder;
import org.assertj.swing.fixture.DialogFixture;
import org.assertj.swing.fixture.FrameFixture;

import com.mutaki.hexadraw.views.ComponentNames;

public class ApplicationRunner {

    private FrameFixture window;
    private Robot robot;

    public void createCircuit() {
	window.button(ComponentNames.CREATE_CIRCUIT_BTN).click();
    }

    public void nameCircuit(String circuitName) {
	DialogFixture dialog = window.dialog(ComponentNames.CIRCUIT_NAME_DIALOG);
	dialog.textBox(ComponentNames.CIRCUIT_NAME_TEXT_BOX).setText(circuitName);
    }

    public void saveAll() {
	window.button(ComponentNames.SAVE_BTN).click();
    }

    public void saveToLocation(Path path) {
	var fileChooser = window.fileChooser();
	fileChooser.setCurrentDirectory(path.toFile());
	fileChooser.approve();
    }

    public void confirm() {
	window.dialog(ComponentNames.CIRCUIT_NAME_DIALOG).button(ComponentNames.OK_BUTTON)
	    .click();
    }

    public void pickCircuitDirectory(Path directory) {
	window.button(ComponentNames.SAVE_LOCATION_CHOOSER_BUTTON).click();
	var fileChooser = window.fileChooser();
	fileChooser.setCurrentDirectory(directory.toFile());
	fileChooser.approve();
    }

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

    public void stop() {
	if (window != null) {
	    window.cleanUp();
	}
    }

    public void selectJunctionBox() {
	window.button(ComponentNames.JUNCTION_BOX_BUTTON).click();
    }

    public void clickOnCanvasAt(Point point) {
	window.panel(ComponentNames.DIAGRAM_PANEL).click();
    }

}
