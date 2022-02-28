/*
  Realizar la siguiente figura por medio del ciclo Repetir - Hasta Que
	 triangulo de base 21 asteriscos centrados, seguido de
	 2 filas de 3 asteriscos c/, seguido de
	 1 fila de 5 asteriscos, seguido de
	 fila final de 7 asteriscos
 */

package com.sofka.Taller3.Taller3Punto3;

public class Taller3Punto3 {
    private String asterisks;
    private String emptySpaces;
    private int i;
    public void Taller3Punto3() {
        System.out.println("Aplicacion figura de saeta:\n");
        asterisks = "";
        // initialize emptySpaces with 9 empty spaces
        // moving the initial asterisk 9 spaces further to the right
        emptySpaces = "          ";
        i = 10;
        // first section of the figure
        do {
            asterisks = printAsterisks(i, asterisks);
            i--;
        } while (i > 0);

        // half section of the figure
        printAsterisks(9, "*");

        // final section of the figure
        asterisks = "*";
        i = 9;
        do {
            asterisks = printAsterisks(i, asterisks);
            i -= 1;
        } while (i > 6);
        System.out.println("");
    }
    private String printAsterisks(int i, String asterisks) {
        System.out.print(emptySpaces.substring(0, i - 1));
        System.out.print(asterisks);
        System.out.print("*");
        System.out.print(asterisks);
        System.out.println(emptySpaces.substring(0, i - 1));
        asterisks += "*";
        return asterisks;
    }
}
