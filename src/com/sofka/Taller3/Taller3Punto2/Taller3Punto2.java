 /*Realizar la siguiente figura por medio del ciclo Mientras - Hacer:

          *
         **
        ***
       ****
      *****
     ******
    *******
   ********
  *********
 **********

 */
package com.sofka.Taller3.Taller3Punto2;

public class Taller3Punto2 {
    private String asterisks;
    private String emptySpaces;
    private int i;
    public void Taller3Punto2() {
        asterisks = "";
        // initialize emptySpaces with 9 empty spaces
        // moving the initial asterisk 9 spaces further to the right
        emptySpaces = "         ";
        i = 9;
        while(i >= 0) {
            asterisks += "*";
            System.out.print(emptySpaces.substring(0, i));
            System.out.println(asterisks);
            i--;
        }
        System.out.println("\n");
    }
}
