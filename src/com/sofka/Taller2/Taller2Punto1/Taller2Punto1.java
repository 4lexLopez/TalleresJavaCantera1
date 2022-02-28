/*
 Realizar un programa en el cual se solicite la edad de una persona.
 Si la persona es mayor o igual a 18 años, deberá mostrar en pantalla: Usted es mayor de edad.
 */
package com.sofka.Taller2.Taller2Punto1;

import java.util.Scanner;

public class Taller2Punto1 {
    private int age;

    private Scanner input;

    public void Taller2Punto1() {

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
        if (arg1 >= 18) {
            System.out.println("Usted es mayor de edad.");
        }
    }
}
