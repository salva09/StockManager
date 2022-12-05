package org.example.utils;

import org.example.data.model.Order;

import java.util.ArrayList;
import java.util.Comparator;

public class OrderManager {
    private static OrderManager instance;
    private final FileManager<Order> fileManager;
    private final String filepath = "orders.txt";
    private ArrayList<Order> items = null;

    private OrderManager() {
        fileManager = new FileManager<>(filepath);
        items = new ArrayList<>();
    }

    public static OrderManager getInstance() {
        if (instance == null)
            instance = new OrderManager();

        return instance;
    }

    public void saveOrder(Order order) {
        items.add(order);
    }

    public void saveOrderData() {
        fileManager.saveToFile(items);
    }

    public void retireveOrderData() {
        var data = fileManager.readFile();

        if (data == null)
            return;

        items.addAll(data);

        items.sort(Comparator.comparingInt(Order::getId));
    }

    public ArrayList<Order> getOrders() {
        return items;
    }
}
