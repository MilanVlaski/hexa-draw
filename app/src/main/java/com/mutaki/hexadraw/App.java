package com.mutaki.hexadraw;

import static com.mutaki.hexadraw.views.ComponentNames.CREATE_CIRCUIT_BTN;
import static com.mutaki.hexadraw.views.ComponentNames.JUNCTION_BOX_BUTTON;
import static com.mutaki.hexadraw.views.ComponentNames.SAVE_BTN;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import com.mutaki.hexadraw.canvas.Canvas;
import com.mutaki.hexadraw.io.SaveableWrapper;
import com.mutaki.hexadraw.io.Saveables;
import com.mutaki.hexadraw.model.Circuit;
import com.mutaki.hexadraw.model.JunctionBoxFactory;
import com.mutaki.hexadraw.views.CanvasPanel;
import com.mutaki.hexadraw.views.ComponentNames;
import com.mutaki.hexadraw.views.CreateCircuitDialog;
import com.mutaki.hexadraw.views.DialogResult;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new App());
    }

    private final JFrame frame;

    // Both Canvas and CanvasPanel are here.
    private Canvas canvas;
    private Saveables saveables = new Saveables();

    public App() {
        frame = new JFrame("Hexa-Draw");
        frame.setName(ComponentNames.MAIN_FRAME);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);

        JButton createCircuitBtn = new JButton("Create Circuit");
        createCircuitBtn.setName(CREATE_CIRCUIT_BTN);
        createCircuitBtn.addActionListener(this::createCircuit);

        JButton saveBtn = new JButton("Save");
        saveBtn.setName(SAVE_BTN);
        saveBtn.addActionListener(e -> saveables.save());

        JButton junctBoxButton = new JButton("Junction Box");
        junctBoxButton.setName(JUNCTION_BOX_BUTTON);
        // canvas might be a Listener for state changes
        junctBoxButton.addActionListener(e -> {
            canvas.toPlacingState((new JunctionBoxFactory()));
        });

        JPanel topPanel = new JPanel();
        topPanel.add(createCircuitBtn);
        topPanel.add(saveBtn);
        topPanel.add(junctBoxButton);

        frame.add(topPanel, BorderLayout.NORTH);

        frame.setVisible(true);
    }

    private void createCircuit(ActionEvent e) {

        DialogResult dialogResult = CreateCircuitDialog.showDialog(frame);
        final var circuit = new Circuit(dialogResult.name);

        saveables.add(new SaveableWrapper(circuit, dialogResult.location));
        final var canvas = new Canvas(circuit);
        var drawPanel = new CanvasPanel(canvas);
        canvas.addCanvasListener(drawPanel);
        this.canvas = canvas;

        frame.add(drawPanel, BorderLayout.CENTER);
        frame.revalidate();
    }
}
