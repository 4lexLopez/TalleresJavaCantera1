/*
 Realizar un programa el cual solicite
 el nombre de su mascota, edad de la mascota, el tipo de mascota y su nombre completo.
 Al finalizar el sistema debe e imprimir en pantalla el siguiente mensaje:
 [Nombre de Mascota] es un(a) [Tipo de Mascota], el cual, tiene [Edad de la Mascota] años de edad y [Nombre Completo] es actualmente su dueño(a).
 */
package com.sofka.Taller1.Taller1Punto5;

import java.util.Scanner;

public class Taller1Punto5 {
    private String firstName;
    private String lastName;
    private String petName;
    private String petType;
    private Integer petAge;

    private Scanner input;

    public void Taller1Punto5() {

        input = new Scanner(System.in);

        askPetName();
        petName = getInputString();

        askPetAge();
        petAge = getInputInt();
        input.nextLine();

        askPetType();
        petType = getInputString();

        askFirstName();
        firstName = getInputString();

        askLastName();
        lastName = getInputString();

        printMessage(petName, petType, petAge.toString(), firstName, lastName);
    }

    private void askPetAge() {
        System.out.println("Por favor, Digite la edad de su mascota");
    }

    private void askPetName() {
        System.out.println("Por favor, Digite el nombre de su mascota");
    }

    private void askFirstName() {
        System.out.println("Por favor, Digite su nombre");
    }

    private void askLastName() {
        System.out.println("Por favor, Digite su apellido");
    }

    private void askPetType() {
        System.out.println("Por favor, Digite el tipo de su mascota");
    }

    private String getInputString() {
        return input.nextLine();
    }

    private int getInputInt() {
        return input.nextInt();
    }

    private void printMessage(String str1, String str2, String str3, String str4, String str5) {
        System.out.println(str1 + " es un(a) " + str2 + ", el cual, tiene " + str3 + " años de edad y " + str4 + " " + str5 + " es actualmente su dueño(a).");
    }
}
