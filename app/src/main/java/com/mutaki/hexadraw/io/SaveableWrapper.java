package com.mutaki.hexadraw.io;

import java.io.File;
import java.nio.file.Path;
import java.util.Optional;

import javax.swing.JFileChooser;

import com.mutaki.hexadraw.io.json.JsonCircuitFileWriter;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.views.ComponentNames;

/**
 * TODO move JsonCircuitFileWriter to Circuit.save(), then call it here.
 * Make Circuit implement Saveable.
 * The make the Circuit field, of type Saveable.
 */
public class SaveableWrapper implements Saveable {

    private final Circuit circuit;
    private final Optional<Path> saveDirectory;

    public SaveableWrapper(Circuit circuit, Optional<Path> saveDirectory) {
        this.circuit = circuit;
        this.saveDirectory = saveDirectory;
    }

    @Override
    public void save() {
        saveDirectory.ifPresentOrElse(
            dir -> new JsonCircuitFileWriter(circuit).write(dir),
            // TOOO extract this to a lambda.
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
