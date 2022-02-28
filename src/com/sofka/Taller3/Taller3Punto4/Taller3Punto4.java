package com.sofka.Taller3.Taller3Punto4;

import java.util.Scanner;

public class Taller3Punto4 {
    private Scanner input;
    public void Taller3Punto4() {
        input = new Scanner(System.in);
        System.out.println("Aplicacion tablas de multiplicar:\n");
        System.out.println("Digite el numero que desea ver en una tabla de multiplicacion del 1 al 10:");
        int number = input.nextInt();
        input.nextLine();

        for (int i = 1; i <= 10; i++) {
            System.out.println(number + " x " + i + " = " + number * i);
        }
        System.out.println("");
    }
}
