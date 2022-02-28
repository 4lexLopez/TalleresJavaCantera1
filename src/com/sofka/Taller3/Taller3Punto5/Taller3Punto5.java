/*
 Utilizando el ciclo que usted desee,
 crear un menú de ejecución infinita hasta que el usuario desee terminar dicho ciclo.
 
 	 Menu de usuario
	 1. Captura nombre
	 2. Saluda usuario
	 3. Salir del sistema.
	
 */
package com.sofka.Taller3.Taller3Punto5;

import java.util.Scanner;

public class Taller3Punto5 {
    private Scanner input;
    private int option;
    private String userName;
    private boolean finish;
    public void Taller3Punto5() {
        input = new Scanner(System.in);
        userName = "Usuario";
        finish = false;
        System.out.println("Aplicacion continua de menu");

        while (!finish) {
            System.out.println("Menu de usuario\n");
            System.out.println("1. Captura nombre");
            System.out.println("2. Saluda usuario");
            System.out.println("3. Salir del sistema.\n");

            option = input.nextInt();
            input.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Digite su nombre:");
                    userName = input.nextLine();
                    System.out.println("Nombre guardado");
                    break;
                case 2:
                    System.out.println("Hola " + userName);
                    break;
                case 3:
                    finish = true;
                    break;
                default:
                    System.out.println("Opcion invalida, intente nuevamente");
            }
            System.out.println("");
        }

    }
}
