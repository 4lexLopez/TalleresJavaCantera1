/*
 Crear un arreglo de números enteros de 20 posiciones, el cual,
 debe ser llenado con números aleatorios entre 1 y 100;
 después de haber llenado dicho arreglo,
 se debe volver a recorrer utilizando un ciclo diferente al que se usó para llenarse
 e imprimir los números pares e impares. Ejemplo

 Números pares: 2, 4, 6, 8, 10
 Números impares: 1, 3, 5, 7, 9
 */

package com.sofka.Taller4.Taller4Punto2;

import java.util.Random;

public class Taller4Punto2 {
    private int[] randomArray;
    private String even, odd;
    private Random random;
    public void Taller4Punto2() {
        even = "";
        odd = "";
        System.out.println("Numeros pares e impares aleatorios");
        random = new Random();
        randomArray = new int[20];
        // populate the randomArray with random integers
        for (int i = 0; i < randomArray.length; i++) {
            // bound not included in random range
            randomArray[i] = random.nextInt(10) + 1;
        }
        // using a different loop to group both even and odd numbers
        int i = randomArray.length;
        while (i > 0) {
            if(randomArray[i - 1] % 2 == 0) {
                even += (randomArray[i - 1]) + ", ";
            } else {
                odd += (randomArray[i - 1]) + ", ";
            }
            i--;
        }

        // printing both arrays:
        System.out.println("\nNumeros pares: " + even.substring(0, even.length() - 2));
        System.out.println("\nNumeros impares: " + odd.substring(0, odd.length() - 2));
        System.out.println("");

    }
}
