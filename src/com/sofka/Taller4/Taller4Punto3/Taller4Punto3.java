/*
 Imprimir los números primos del 1 al 1000, el resultado debe ser buscado de forma matemática.
 */
package com.sofka.Taller4.Taller4Punto3;

import java.util.Random;

public class Taller4Punto3 {
    private int[] testArray;
    public void Taller4Punto3() {
        System.out.println("Numeros primos");
        testArray = new int[1000];

        // populate the array with random numbers using a for loop:
        for (int i = 0; i < testArray.length; i++) {
            testArray[i] = i + 1;
        }

        System.out.println("Los numeros primos del 1 al 1000 son:");
        for (int i = 0; i < testArray.length; i++) {
            if(testArray[i] % 2 != 0 && testArray[i] % 3 != 0 && testArray[i] % 5 != 0) {
                System.out.println(testArray[i]);
            }
        }
        System.out.println("");
    }
}
