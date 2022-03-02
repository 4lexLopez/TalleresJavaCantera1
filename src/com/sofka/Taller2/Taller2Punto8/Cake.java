package com.sofka.Taller2.Taller2Punto8;

public class Cake {
    private int id;
    private String Name;
    private int price;
    private int portions;
    private String decoration;
    private int amount;

    public Cake(int id, String Name, int price, int portions, String decoration, int amount) {
        this.id = id;
        this.Name = Name;
        this.price = price;
        this.portions = portions;
        this.decoration = decoration;
        this.amount = amount;
    }

    public Cake(int id, int amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public int getPortions() {
        return portions;
    }

    public void setPortions(int portions) {
        this.portions = portions;
    }

    public String getDecoration() {
        return decoration;
    }

    public void setDecoration(String decoration) {
        this.decoration = decoration;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
