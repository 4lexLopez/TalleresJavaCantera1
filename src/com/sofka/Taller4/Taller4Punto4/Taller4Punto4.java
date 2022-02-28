/*
  Dada la siguiente matriz bidimensional, el cual debe de quemar en el código

	 01 02 03 04 05
	 06 07 08 09 10
	 11 12 13 14 15
	 16 17 18 19 20

	 Utilizando el conocimiento adquirido, a excepción de hacerlo de forma manual, 
	 imprima la siguiente matriz bidimensional.

	 01 02 03 04 05
	 10 09 08 07 06
	 11 12 13 14 15
	 20 19 18 17 16
 */

package com.sofka.Taller4.Taller4Punto4;

public class Taller4Punto4 {
    private String[][] testArray;
    private boolean fullRow;
    int contador = 0;

    public void Taller4Punto4() {
        System.out.println("Organizando la matriz\n");
        testArray = new String[4][5];
        // fill the matrix as suggested above
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                contador++;
                if (contador < 10) {
                    testArray[i][j] = "0" + contador;
                } else {
                    testArray[i][j] = Integer.toString(contador);
                }
            }
        }

        // sort the matrix as suggested above:
        for (int i = 0; i < 3; i++) {
            // print the column-index in descendant order when odd:
            if (i % 2 != 0) {
                for (int j = 4; j > 0; j--) {
                    System.out.print(testArray[i][j] + "    ");
                }
                System.out.println("");
            } else {
                for (int j = 0; j < 4; j++) {
                    System.out.print(testArray[i][j] + "    ");
                }
                System.out.println("");
            }
        }
        System.out.println("");
    }
}
