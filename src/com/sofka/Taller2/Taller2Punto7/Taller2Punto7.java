/*
 La Secretaría de Salud Municipal requiere de una aplicación que le permita calcular el IMC (Índice de masa corporal)
  y requiere los datos peso en kilogramos y
  estatura en metros Para cada persona encuestada adicional a los datos suministrados,
  debe mostrar el resultado para cada uno y establecer en qué rango se encuentra
  (bajo peso, normal, sobrepeso y obeso).
 */
package com.sofka.Taller2.Taller2Punto7;

import java.util.ArrayList;
import java.util.Scanner;

import static com.sofka.Main.showMainMenu;

public class Taller2Punto7 {

    private int selectedOption;
    private boolean showMenu;

    private Scanner input;
    private ArrayList<User> usersList;

    public void Taller2Punto7() {
        input = new Scanner(System.in);
        usersList = new ArrayList<>();
        showMenu = true;

        while (showMenu) {
            showMainMenu();
            selectedOption = getInputInt();
            input.nextLine();
            showMenu = evaluateOption(selectedOption);
        }
    }

    private boolean evaluateOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                User user = new User();
                recordPerson(user);
                showUserSummary(user);
                if (confirmUser()) {
                    calculateImc(user);
                    // insert the user to the list
                    usersList.add(user);
                }
                return true;
            case 2:
                // print all the users stored in the list
                printRecords();
                return true;
            case 0:
                return false;
        }
        return true;
    }

    private void printRecords() {
        for (int i = 0; i < usersList.size(); i++) {
            showUserSummary(usersList.get(i));
            System.out.println("Resultado del calculo IMC:");
            showUserResults(usersList.get(i));
        }

    }

    private void showUserResults(User user) {
        if (user.getUserImc() < 18.5) {
            System.out.println(user.getUserName() + " Presenta bajo peso");
        }
        if (user.getUserImc() >= 18.5 && user.getUserImc() < 24.9) {
            System.out.println(user.getUserName() + " Presenta un peso normal");
        }
        if (user.getUserImc() >= 25 && user.getUserImc() < 29.9) {
            System.out.println(user.getUserName() + " presenta sobrepeso");
        }
        if (user.getUserImc() >= 30.0) {
            System.out.println(user.getUserName() + " sufre de obesidad");
        }
        System.out.println("");
    }

    private void calculateImc (User user){
        float imc;
        imc = user.getUserWeight() / (user.getUserHeight() * user.getUserHeight());
        user.setUserImc(imc);
    }

    private void showMainMenu () {
        System.out.println("Aplicacion de calculo de IMC\n");
        System.out.println("Menu principal\n");
        System.out.println("Elija entre las siguientes opciones:");
        System.out.println("1. Ingresar persona");
        System.out.println("2. Ver registros");
        System.out.println("0. Finalizar aplicacion\n\n");
    }

    private User recordPerson (User user) {
        System.out.println("Menu de ingreso de datos de usuarios\n");
        System.out.println("Digite el nombre completo de la persona:");
        String name = input.nextLine();
        user.setUserName(name);
        System.out.println("");
        System.out.println("Estatura de la persona en metros:");
        float height = input.nextFloat();
        user.setUserHeight(height);
        input.nextLine();
        System.out.println("");
        System.out.println("Peso de la persona en kilogramos:");
        float weight = input.nextFloat();
        user.setUserWeight(weight);
        input.nextLine();
        return user;
    }

    private boolean confirmUser () {
        System.out.println("\nConfirmar? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "N":
            case "n":
            case "":
                System.out.println("Registro cancelado\n");
                return false;
            case "S":
            case "s":
                System.out.println("Persona agregada con exito\n");
                return true;
            default:
                System.out.println("Opcion incorrecta, orden cancelada\n");
                break;
        }
        return false;
    }

    private void showUserSummary (User user){
        System.out.println("Resumen del usuario, verifique la informacion:\n");
        System.out.println("Nombre:");
        System.out.println(user.getUserName());
        System.out.println("Peso:");
        System.out.println(user.getUserWeight());
        System.out.println("Estatura:");
        System.out.println(user.getUserHeight() + '\n');
    }

    private int getInputInt() {
        return input.nextInt();
    }
}
