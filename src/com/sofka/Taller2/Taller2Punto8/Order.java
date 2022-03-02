package com.sofka.Taller2.Taller2Punto8;

import java.util.ArrayList;

public class Order {
    private int orderId;
    private int orderValue;
    private ArrayList<Cake> cakes;

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

    public ArrayList<Cake> getCakes() {
        return cakes;
    }

    public void setCakes(ArrayList<Cake> cakes) {
            this.cakes = cakes;
        }

}
