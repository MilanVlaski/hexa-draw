package com.mutaki.hexadraw.views;

import java.awt.BorderLayout;
import java.awt.Frame;
import java.nio.file.Path;
import java.util.Optional;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateCircuitDialog extends JDialog {

    private static final long serialVersionUID = 5729688182479031521L;
    private final JTextField nameField = new JTextField(20);
    private final JTextField directoryField = new JTextField(20);

    private DialogResult result = null;

    private CreateCircuitDialog(Frame owner) {
        super(owner, "New Circuit", true);
        setName(ComponentNames.CIRCUIT_NAME_DIALOG);

        setLayout(new BorderLayout());

        directoryField.setName("directoryField");
        nameField.setName(ComponentNames.CIRCUIT_NAME_TEXT_BOX);

        var fields = new JPanel();
        fields.setLayout(new BoxLayout(fields, BoxLayout.Y_AXIS));
        fields.add(new JLabel("Name:"));
        fields.add(nameField);
        fields.add(new JLabel("Directory:"));
        fields.add(directoryField);
        add(fields, BorderLayout.CENTER);

        JButton ok = new JButton("OK");
        ok.setName(ComponentNames.OK_BUTTON);
        ok.addActionListener(e -> {
            // Java is bad at this, compared to Kotlin :)
            final var optionalPath = Optional.ofNullable(directoryField.getText())
                .filter(s -> !s.isEmpty())
                .map(Path::of);
            result = new DialogResult(nameField.getText(),
                optionalPath);
            dispose();
        });

        JButton cancel = new JButton("Cancel");
        cancel.setName("cancelButton");
        cancel.addActionListener(e -> {
            result = null;
            dispose();
        });

        JButton fileChooserButton = new JButton("Select Location");
        fileChooserButton.setName(ComponentNames.SAVE_LOCATION_CHOOSER_BUTTON);
        fileChooserButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                directoryField.setText(chooser.getSelectedFile().getAbsolutePath());
            }
        });

        JPanel buttons = new JPanel();
        buttons.add(ok);
        buttons.add(cancel);
        buttons.add(fileChooserButton);
        add(buttons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    public static DialogResult showDialog(Frame owner) {
        CreateCircuitDialog dialog = new CreateCircuitDialog(owner);
        dialog.setVisible(true);
        return dialog.result;
    }

}
