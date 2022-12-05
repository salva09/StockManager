package org.example.ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Stock extends JPanel {
    private JLabel buttonLabel;
    private JButton button;
    private JPanel content;
    private JScrollPane scrollableList;

    public Stock() {
        createComponents();
    }

    private void createComponents() {
        setLayout(new GridBagLayout());
        content = new JPanel();
        scrollableList = new JScrollPane();
        content.setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        constraints.gridy = 0;
        constraints.gridx = 0;

        for (int i = 0; i < 10; i++) {
            content.add(new JLabel("Hello"), constraints);
            constraints.gridy++;
        }

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.weighty = 1;
        constraints.weightx = 1;
        scrollableList.setViewportView(content);
        add(scrollableList, constraints);
    }
}
