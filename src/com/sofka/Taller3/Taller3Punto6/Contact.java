package com.sofka.Taller3.Taller3Punto6;

public class Contact {
    private String firstName;
    private String lastName;
    private String org;

    public Contact(String firstName, String lastName, String org) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.org = org;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getOrg() {
        return org;
    }

    public void setOrg(String org) {
        this.org = org;
    }
}
