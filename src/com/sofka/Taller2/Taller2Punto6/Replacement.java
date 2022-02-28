package com.sofka.Taller2.Taller2Punto6;

public class Replacement {
    private int Id;
    private String name;
    private int amount;

    public Replacement(int id, String name, int amount) {
        Id = id;
        this.name = name;
        this.amount = amount;
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
