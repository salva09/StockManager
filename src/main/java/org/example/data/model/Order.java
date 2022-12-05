package org.example.data.model;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private int id;
    private String name;
    private int quantity;
    private Date date;

    public Order(int id, String name, int quantity, Date date) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
