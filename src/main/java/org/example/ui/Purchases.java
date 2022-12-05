package org.example.ui;

import org.example.data.model.Order;
import org.example.utils.OrderManager;
import org.jdatepicker.JDatePicker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Purchases extends JPanel {
    private JLabel title;
    private JButton generateOrder;
    private JPanel content;
    private JScrollPane scrollableList;

    public Purchases() {
        createComponents();

        generateOrder.addActionListener(e -> {
            JTextField field1 = new JTextField();
            JTextField field2 = new JTextField();
            JDatePicker field3 = new JDatePicker();
            JPanel panel = new JPanel(new GridLayout(0, 1));

            panel.add(new JLabel("Nombre:"));
            panel.add(field1);
            panel.add(new JLabel("Cantidad:"));
            panel.add(field2);
            panel.add(new JLabel("Fecha:"));
            panel.add(field3);

            int result = JOptionPane.showConfirmDialog(this, panel, "Test",
                    JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
            if (result == JOptionPane.OK_OPTION) {
                int day, month, year;
                day = field3.getModel().getDay();
                month = field3.getModel().getMonth();
                year = field3.getModel().getYear();
                var df = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    OrderManager
                            .getInstance()
                            .saveOrder(new Order(
                                    OrderManager.getInstance().getOrders().size() + 1,
                                    field1.getText(),
                                    Integer.parseInt(field2.getText()),
                                    df.parse(day + "/" + month + "/" + year)));
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }
            } else {
                System.out.println("Cancelled");
            }
        });
    }

    private void createComponents() {
        setLayout(new GridBagLayout());
        var constraints = new GridBagConstraints();

        title = new JLabel();
        title.setText("Compras");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 18));
        constraints.gridx = 0;
        constraints.gridy = 0;
        add(title, constraints);

        generateOrder = new JButton();
        generateOrder.setText("Generar Orden");
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 100, 0, 0);
        add(generateOrder, constraints);

        content = new JPanel();
        scrollableList = new JScrollPane();
        content.setLayout(new GridBagLayout());

        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.gridy = 0;
        constraints.gridx = 0;
        constraints.gridwidth = 3;

        var orders = OrderManager.getInstance().getOrders();
        for (int i = 0; i < orders.size(); i++) {
            content.add(new JLabel(orders.get(i).getName()), constraints);
            constraints.gridy++;
        }

        constraints.fill = GridBagConstraints.BOTH;
        constraints.gridy = 1;
        constraints.gridx = 0;
        constraints.weighty = 1;
        constraints.weightx = 1;
        constraints.gridwidth = 3;
        scrollableList.setViewportView(content);
        add(scrollableList, constraints);
    }
}
