/*
 Enunciado punto 4:
 Realizar un programa el cual solicite el nombre de una ciudad capital y el país.
 Al finalizar debe imprimir en pantalla el siguiente mensaje
 "La ciudad [Nombre de la Ciudad], es la capital del país [Nombre del País]
 */
package com.sofka.Taller1.Taller1Punto4;

import java.util.Scanner;

public class Taller1Punto4 {
    private String capitalCity;
    private String country;

    private Scanner input;

    public void Taller1Punto4() {

        input = new Scanner(System.in);

        askCapitalCity();
        capitalCity = getInputString();

        askCountryName();
        country = getInputString();

        printMessage(capitalCity, country);
    }

    private void askCapitalCity() {
        System.out.println("Por favor, Digite la ciudad capital");
    }

    private void askCountryName() {
        System.out.println("Por favor, Digite el nombre del pais");
    }

    private String getInputString() {
        return input.nextLine();
    }

    private void printMessage(String str1, String str2) {
        System.out.println("La ciudad " + str1 + ", es la capital del país " + str2);
    }
}
