/*
 Enunciado punto 2
 Realizar un programa en el cual se solicite la edad de una persona.
 Si la persona es menor a 18 años, deberá mostrar en pantalla: Usted aún es un niño(a).
 */
package com.sofka.Taller1.Taller1Punto2;

import java.util.Scanner;


public class Taller1Punto2 {
    private String firstName;
    private String lastName;
    private int age;
    private double height;

    private Scanner input;

    public void Taller1Punto2() {

        input = new Scanner(System.in);

        askFirstName();
        firstName = getInputString();

        askLastName();
        lastName = getInputString();

        askAge();
        age = getInputInt();

        askHeight();
        height = getInputHeight();

        System.out.println("Informacion almacenada exitosamente\n");
    }

    private void askFirstName() {
        System.out.println("Por favor, Digite su nombre");
    }

    private void askLastName() {
        System.out.println("Por favor, Digite su apellido");
    }

    private void askAge() {
        System.out.println("Por favor, Digite su edad");
    }

    private void askHeight() {
        System.out.println("Por favor, Digite su estatura en metros");
    }

    private String getInputString() {
        return input.nextLine();
    }

    private int getInputInt() {
        return input.nextInt();
    }

    private double getInputHeight() {
        return input.nextDouble();
    }
}
