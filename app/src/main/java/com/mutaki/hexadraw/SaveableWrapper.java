package com.mutaki.hexadraw;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

import javax.swing.JFileChooser;

public class SaveableWrapper implements Saveable {

    private final Circuit circuit;
    private Optional<Path> saveDirectory;

    public SaveableWrapper(Circuit circuit, Optional<Path> saveDirectory) {
	this.circuit = circuit;
	this.saveDirectory = saveDirectory;
    }

    @Override
    public void save() {
	saveDirectory.ifPresentOrElse(
		dir -> new JsonCircuitFileWriter(circuit).write(dir),
		() -> {
		    JFileChooser fileChooser = new JFileChooser();
		    fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
		    fileChooser.setName(ComponentNames.CIRCUIT_LOCATION_FILE_CHOOSER);

		    int result = fileChooser.showSaveDialog(null);
		    if (result == JFileChooser.APPROVE_OPTION) {
			File selectedSaveDirectory = fileChooser.getSelectedFile();
			new JsonCircuitFileWriter(circuit)
			    .write(selectedSaveDirectory.toPath());
		    }
		});
    }

}
