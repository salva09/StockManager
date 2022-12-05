package org.example;

import com.formdev.flatlaf.FlatLightLaf;
import org.example.ui.Window;
import org.example.utils.OrderManager;

public class Main {
    public static void main(String[] args) {
        FlatLightLaf.setup();

        OrderManager.getInstance().retireveOrderData();

        var app = new Window();
    }
}
