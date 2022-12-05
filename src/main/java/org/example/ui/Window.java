package org.example.ui;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.utils.OrderManager;

import javax.swing.*;

public class Window extends JFrame {
    private JTabbedPane mainPane;

    public Window() {
        createComponents();
        setContentPane(mainPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setSize(600,400);
        setVisible(true);

        try {
            UIManager.setLookAndFeel(new FlatLightLaf());
        } catch (Exception ex) {
            System.err.println("Failed to initialize LaF");
        }

        addWindowListener(new java.awt.event.WindowAdapter() {
            @Override
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                OrderManager.getInstance().saveOrderData();
            }
        });
    }

    private void createComponents() {
        mainPane = new JTabbedPane();

        mainPane.addTab("Inventario", new Stock());
        mainPane.addTab("Compras", new Purchases());
        mainPane.addTab("Promociones", new Promotions());
        mainPane.addTab("Ventas", new Sales());
    }
}
