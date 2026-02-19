package com.cleanroommc.relauncher.gui;

import javax.swing.*;
import java.awt.*;

public class LoadingGUI {

    private final JFrame frame;
    private final JLabel statusLabel;
    private final JProgressBar progressBar;

    public LoadingGUI() {
        frame = new JFrame("Cleanroom Relauncher Progess");
        frame.setUndecorated(true);
        frame.setSize(400, 100);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(2, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        panel.setBackground(Color.WHITE);
        panel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        statusLabel = new JLabel("Initializing..");
        statusLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));

        progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setForeground(new Color(34, 139, 34));

        panel.add(statusLabel);
        panel.add(progressBar);

        frame.add(panel, BorderLayout.CENTER);
    }

    public void show() {
        SwingUtilities.invokeLater(() -> frame.setVisible(true));
    }
    public void enableProgress() {
        if (progressBar.isIndeterminate()) {
            progressBar.setIndeterminate(false);
            progressBar.setStringPainted(true);
        }
    }
    public void disableProgress() {
        if (!progressBar.isIndeterminate()) {
            progressBar.setIndeterminate(true);
            progressBar.setStringPainted(false);
        }
    }

    public void setProgress(int percent) {
        SwingUtilities.invokeLater(() -> {
            progressBar.setValue(percent);
        });
    }

    public void updateStatus(String status) {
        SwingUtilities.invokeLater(() -> statusLabel.setText(status));
    }

    public void close() {
        SwingUtilities.invokeLater(() -> {
            frame.setVisible(false);
            frame.dispose();
        });
    }
}
