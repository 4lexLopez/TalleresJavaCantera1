/*
  se debe imprimir el cuadro de las tablas de multiplicar de 1x1 hasta 10x10
	 El usuario deberá insertar la fila y columna de la cual desea ver el resultado, 
	 el resultado de cada celda debe estar previamente calculado 
	 en una matriz bidimensional la cual cada resultado obedecerá a la fila y columna insertada por el usuario.
 */

package com.sofka.Taller4.Taller4Punto5;

import java.util.Scanner;

public class Taller4Punto5 {
    private int[][] multiplyChart;
    private Scanner input;
    public void Taller4Punto5() {
        input = new Scanner(System.in);
        multiplyChart = new int[10][10];
        System.out.println("Tablas de multiplicar:\n");
        int n1, n2;

        System.out.print("      ");
         // Calculate and store all the results required
        for (int i = 1; i <= 10; i++) {
            System.out.print((i - 1) + "       ");
            for (int j = 1; j <= 10; j++) {
                multiplyChart[i - 1][j - 1] = i * j;
            }
        }
        System.out.println("");

        // printing the multiply tables;
        for (int i = 1; i <= 10; i++) {
            System.out.print(i - 1 + "  ");
            for (int j = 1; j <= 10; j++) {
                System.out.print(i + " x " + j + "	");
            }
            System.out.println("");
        }
        System.out.println("");

        System.out.println("Digite el numero de la fila que desea ver el resultado:");
        n1 = input.nextInt();
        input.nextLine();
        System.out.println("Digite el numero de la columna que desea ver el resultado:");
        n2 = input.nextInt();
        input.nextLine();
        System.out.println((n1 + 1) + " x " + (n2 + 1) + " = " + multiplyChart[n1][n2] + "\n");
    }
}
