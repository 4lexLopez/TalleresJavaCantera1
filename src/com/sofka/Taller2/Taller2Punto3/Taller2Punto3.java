/*
 Realizar un programa en el cual se solicite el nombre, apellidos y edad de la persona.
 Si la persona es mayor o igual a 18 años, entonce se deberá imprimir en pantalla
 [Nombre completo] usted es mayor de edad, por lo tanto puede entrar a la fiesta.
 Si la edad de la persona es menor que 18 años, entonces, deberá imprimirse el siguiente mensaje:
 [Nombre completo] usted es menor de edad, por lo tanto, no puede entrar a la fiesta, por favor devuélvase a su casa.
 */

package com.sofka.Taller2.Taller2Punto3;

import java.util.Scanner;

public class Taller2Punto3 {

    private String firstName;
    private String lastName;
    private int age;

    private Scanner input;

    public void Taller2Punto3() {

        input = new Scanner(System.in);
        askFirstName();
        firstName = getInputString();

        askLastName();
        lastName = getInputString();

        askUserAge();
        age = getInputInt();
        askUserAge();
        age = getInputInt();
        checkAge(age);

        System.out.println("Ejecucion finalizada\n");

    }
    private void askFirstName() {
        System.out.println("Por favor, Digite su nombre");
    }

    private void askLastName() {
        System.out.println("Por favor, Digite su apellido");
    }

    private void askUserAge() {
        System.out.println("Por favor, digite su edad");
    }

    private String getInputString() {
        return input.nextLine();
    }

    private int getInputInt() {
        return input.nextInt();
    }

    private void checkAge(int arg1) {
        System.out.print(firstName + " " + lastName);
        if (arg1 < 18) {
            System.out.println(" usted es menor de edad, por lo tanto, no puede entrar a la fiesta, por favor devuélvase a su casa.");
        } else {
            System.out.println(" usted es mayor de edad, por lo tanto puede entrar a la fiesta.");
        }
    }
}
