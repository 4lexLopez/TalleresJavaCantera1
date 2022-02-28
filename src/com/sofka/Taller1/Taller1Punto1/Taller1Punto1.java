/*
Enunciado punto 1:
Realizar un programa el cual solicite su nombre y apellidos.
 */
package com.sofka.Taller1.Taller1Punto1;

import java.util.Scanner;

public class Taller1Punto1 {
    private String nombre;
    private String apellido;

    private Scanner input;


    public void Taller1Punto1() {

        input = new Scanner(System.in);
        solicitarNombre();
        nombre = capturarDato();

        solicitarApellido();
        apellido = capturarDato();

        System.out.println("Informacion almacenada exitosamente\n");
    }

    private void solicitarNombre() {
        System.out.println("Por favor, Digite su nombre");
    }

    private void solicitarApellido() {
        System.out.println("Por favor, Digite su apellido");
    }

    private String capturarDato() {
        return input.nextLine();
    }
}
