 /*Realizar la siguiente figura por medio del ciclo Para

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

package com.sofka.Taller3.Taller3Punto1;

public class Taller3Punto1 {
    String asterisks = "";
    public void Taller3Punto1() {
        for (int i = 0; i < 10; i++) {
            // concatenate an additional asterisk per cycle 10 times, then, print them all
            asterisks += "*";
            System.out.println(asterisks);
        }
        System.out.println("\n");
    }
}
