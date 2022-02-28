/*
 Crear un vector de tipo Entero con 5 posiciones,
 llenarlo con información solicitada al usuario.
 Después de recoger toda la información,
 se requiere imprimir el índice de cada posición en el arreglo con su valor de la siguiente manera:
 [0] = 55
 [1] = 99
 [2] = 11
 [3] = 56
 [4] = 69
 */

package com.sofka.Taller4.Taller4Punto1;

import java.util.Scanner;

public class Taller4Punto1 {
    private Scanner input;
    private int[] myArray;
    public void Taller4Punto1() {
        input = new Scanner(System.in);
        myArray = new int[5];
        int number;

        System.out.println("Punto 1: ingresar enteros en un arreglo\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("Digite un numero: ");
            number = input.nextInt();
            myArray[i] = number;
            input.nextLine();
        }

        System.out.println("Los numeros almacenados fueron:\n");
        for (int i = 0; i < 5; i++) {
            System.out.println("[" + i + "]" + " = " + myArray[i]);
        }
        System.out.println("");
    }
}
