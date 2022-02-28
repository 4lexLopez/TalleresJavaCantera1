/*
 Realizar un programa en el cual se solicite la edad de una persona.
 Si la persona es menor a 18 años, deberá mostrar en pantalla: Usted aún es un niño(a).
 */
package com.sofka.Taller2.Taller2Punto2;

import java.util.Scanner;

public class Taller2Punto2 {
    private int age;

    private Scanner input;

    public void Taller2Punto2() {

        input = new Scanner(System.in);
        askUserAge();
        age = getInputInt();
        checkAge(age);

        System.out.println("Ejecucion finalizada\n");

    }

    private void askUserAge() {
        System.out.println("Por favor, digite su edad");
    }

    private int getInputInt() {
        return input.nextInt();
    }

    private void checkAge(int arg1) {
        if (arg1 < 18) {
            System.out.println("Usted aún es un niño(a).");
        }
    }
}
