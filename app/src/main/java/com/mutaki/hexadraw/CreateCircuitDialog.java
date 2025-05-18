package com.mutaki.hexadraw;

import java.awt.BorderLayout;
import java.awt.Frame;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateCircuitDialog extends JDialog {
    private JTextField textField = new JTextField(20);
    private String input = null;

    public CreateCircuitDialog(Frame owner) {
	super(owner, "New Circuit", true);
	setName(ComponentNames.CIRCUIT_NAME_DIALOG);

        setLayout(new BorderLayout());

	textField.setName(ComponentNames.CIRCUIT_NAME_TEXT_BOX);
        add(textField, BorderLayout.CENTER);

        JButton ok = new JButton("OK");
	ok.setName(ComponentNames.OK_BUTTON);
        ok.addActionListener(e -> {
            input = textField.getText();
            dispose();
        });

        JButton cancel = new JButton("Cancel");
        cancel.setName("cancelButton");
        cancel.addActionListener(e -> {
            input = null;
            dispose();
        });

	JPanel buttons = new JPanel();
        buttons.add(ok);
        buttons.add(cancel);
        add(buttons, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(owner);
    }

    public static String showDialog(Frame owner) {
	CreateCircuitDialog dialog = new CreateCircuitDialog(owner);
        dialog.setVisible(true);
        return dialog.input;
    }
}
