/*
Realizar un programa el cual solicite su nombre y apellidos,
también debe capturar nombre y apellidos de su padre y madre.
Al finalizar debe imprimir en pantalla el siguiente mensaje
"Yo [Nombre Completo], soy hijo de [Nombre de la Madre] y [Nombre del Padre].
 */
package com.sofka.Taller1.Taller1Punto3;

import java.util.Scanner;

public class Taller1Punto3 {

    private String userFirstName;
    private String userLastName;
    private String momFirstName;
    private String momLastName;
    private String dadFirstName;
    private String dadLastName;
    private int age;
    private double height;

    private Scanner input;
    
    public void Taller1Punto3() {
        input = new Scanner(System.in);

        askUserFirstName();
        userFirstName = getInputString();

        askUserLastName();
        userLastName = getInputString();

        askUserAge();
        age = getInputInt();

        askUserHeight();
        height = getInputDouble();
        // adding an enter-character to input data,
        input.nextLine();

        askMomFirstName();
        momFirstName = getInputString();

        askMomLastName();
        momLastName = getInputString();

        askDadFirstName();
        dadFirstName = getInputString();

        askDadLastName();
        dadLastName = getInputString();

        System.out.println("Informacion almacenada exitosamente\n");

        printMessage(userFirstName, userLastName, momFirstName, momLastName, dadFirstName, dadLastName);
    }

    private void askUserFirstName() {
        System.out.println("Por favor, Digite su nombre");
    }

    private void askUserLastName() {
        System.out.println("Por favor, Digite su apellido");
    }

    private void askUserAge() {
        System.out.println("Por favor, Digite su edad");
    }

    private void askUserHeight() {
        System.out.println("Por favor, Digite su estatura en metros");
    }

    private void askMomFirstName() {
        System.out.println("Por favor, Digite el nombre de su madre");
    }

    private void askMomLastName() {
        System.out.println("Por favor, Digite el apellido de su madre");
    }

    private void askDadFirstName() {
        System.out.println("Por favor, Digite el nombre de su padre");
    }

    private void askDadLastName() {
        System.out.println("Por favor, Digite el apellido de su padre");
    }

    private String getInputString() {
        return input.nextLine();
    }

    private int getInputInt() {
        return input.nextInt();
    }

    private double getInputDouble() {
        return input.nextDouble();
    }

    private void printMessage(String str1, String str2, String str3, String str4, String str5, String str6) {
        System.out.println("Yo, " + str1 + " " + str2 + " , soy hijo de " + str3 + " " + str4 + " y " + str5 + " " + str6);
    }
}
