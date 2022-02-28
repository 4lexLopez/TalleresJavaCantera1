package com.sofka.Taller2.Taller2Punto5;

import java.util.HashMap;

public class Order {
    private int orderId;
    private int orderValue;
    private HashMap<Integer, Integer> products;
    private int productId;
    private int amount;

    public Order(int orderId, HashMap<Integer, Integer> products) {
        this.orderId = orderId;
        this.products = products;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderValue() {
        return orderValue;
    }

    public void setOrderValue(int orderValue) {
        this.orderValue = orderValue;
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }
}
