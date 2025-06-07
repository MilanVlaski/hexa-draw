package com.mutaki.hexadraw;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateCircuitDialog extends JDialog {

    private JTextField nameField = new JTextField(20);
    private JTextField directoryField = new JTextField(20);

    private String result = null;

    public CreateCircuitDialog(Frame owner) {
	super(owner, "New Circuit", true);
	setName(ComponentNames.CIRCUIT_NAME_DIALOG);

	setLayout(new BorderLayout());

	directoryField.setName("directoryField");
	nameField.setName(ComponentNames.CIRCUIT_NAME_TEXT_BOX);
	add(directoryField, BorderLayout.CENTER);
	add(nameField, BorderLayout.CENTER);

        JButton ok = new JButton("OK");
	ok.setName(ComponentNames.OK_BUTTON);
        ok.addActionListener(e -> {
	    result = nameField.getText();
            dispose();
        });

        JButton cancel = new JButton("Cancel");
        cancel.setName("cancelButton");
        cancel.addActionListener(e -> {
	    result = null;
	    dispose();
	});

	JButton fileChooserButton = new JButton("Select Location");
        fileChooserButton.setName("fileChooserButton");
        fileChooserButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int result = chooser.showOpenDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
		nameField.setText(chooser.getSelectedFile().getAbsolutePath());
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

    public static String showDialog(Frame owner) {
	CreateCircuitDialog dialog = new CreateCircuitDialog(owner);
        dialog.setVisible(true);
	return dialog.result;
    }
}
