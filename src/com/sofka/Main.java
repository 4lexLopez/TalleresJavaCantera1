package com.sofka;

import com.sofka.Taller1.Taller1Punto1.Taller1Punto1;
import com.sofka.Taller1.Taller1Punto3.Taller1Punto3;
import com.sofka.Taller1.Taller1Punto4.Taller1Punto4;
import com.sofka.Taller1.Taller1Punto5.Taller1Punto5;
import com.sofka.Taller1.Taller1Punto2.Taller1Punto2;
import com.sofka.Taller2.Taller2Punto1.Taller2Punto1;
import com.sofka.Taller2.Taller2Punto2.Taller2Punto2;
import com.sofka.Taller2.Taller2Punto3.Taller2Punto3;
import com.sofka.Taller2.Taller2Punto4.Taller2Punto4;
import com.sofka.Taller2.Taller2Punto5.Taller2Punto5;
import com.sofka.Taller2.Taller2Punto6.Taller2Punto6;
import com.sofka.Taller2.Taller2Punto7.Taller2Punto7;
import com.sofka.Taller3.Taller3Punto1.Taller3Punto1;
import com.sofka.Taller3.Taller3Punto2.Taller3Punto2;
import com.sofka.Taller3.Taller3Punto3.Taller3Punto3;
import com.sofka.Taller3.Taller3Punto4.Taller3Punto4;
import com.sofka.Taller3.Taller3Punto5.Taller3Punto5;
import com.sofka.Taller4.Taller4Punto1.Taller4Punto1;
import com.sofka.Taller4.Taller4Punto2.Taller4Punto2;
import com.sofka.Taller4.Taller4Punto3.Taller4Punto3;
import com.sofka.Taller4.Taller4Punto4.Taller4Punto4;

import java.util.Scanner;

public class Main {
    //Declaring class attributes
    private static boolean flag = true;
    private static String option;


    public static void main(String[] args) {
        do {
            showMainMenu();
            option = getOption();
            flag = evaluateOptionMainMenu();

        } while (flag == true);
    }

    public static String getOption() {
        Scanner input = new Scanner(System.in);
        return input.nextLine();
    }

    private static boolean evaluateOptionMainMenu() {
        switch (option) {
            case "1":
                showMenuTest1();
                option = getOption();
                evaluateOptionTest1();
                break;
            case "2":
                showMenuTest2();
                option = getOption();
                evaluateOptionTest2();
                break;
            case "3":
                showMenuTest3();
                option = getOption();
                evaluateOptionTest3();
                break;
            case "4":
                showMenuTest4();
                option = getOption();
                evaluateOptionTest4();
                break;
            case "0":
                System.out.println("Programa finalizado");
                return false;
            default:
                System.out.println("Opcion incorrecta");
                // add break line:
                System.out.println("");
        }
        return true;
    }

    private static boolean evaluateOptionTest1() {
        switch (option) {
            case "1":
                Taller1Punto1 t1p1 = new Taller1Punto1();
                t1p1.Taller1Punto1();
                return true;
            case "2":
                Taller1Punto2 t1p2 = new Taller1Punto2();
                t1p2.Taller1Punto2();
                return true;
            case "3":
                Taller1Punto3 t1p3 = new Taller1Punto3();
                t1p3.Taller1Punto3();
                return true;
            case "4":
                Taller1Punto4 t1p4= new Taller1Punto4();
                t1p4.Taller1Punto4();
                return true;
            case "5":
                Taller1Punto5 t1p5= new Taller1Punto5();
                t1p5.Taller1Punto5();
                return true;
            case "0":
                System.out.println("Programa finalizado.");
                return false;
            default:
                System.out.println("Opcion incorrecta");
                // add break line:
                System.out.println("");
        }
        return true;
    }

    private static boolean evaluateOptionTest2() {
        switch (option) {
            case "1":
                Taller2Punto1 t2p1 = new Taller2Punto1();
                t2p1.Taller2Punto1();
                return true;
            case "2":
                Taller2Punto2 t2p2 = new Taller2Punto2();
                t2p2.Taller2Punto2();
                return true;
            case "3":
                Taller2Punto3 t2p3 = new Taller2Punto3();
                t2p3.Taller2Punto3();
                return true;
            case "4":
                Taller2Punto4 t2p4= new Taller2Punto4();
                t2p4.Taller2Punto4();
                return true;
            case "5":
                Taller2Punto5 t2p5 = new Taller2Punto5();
                t2p5.Taller2Punto5();
                return true;
            case "6":
                Taller2Punto6 t1p6= new Taller2Punto6();
                t1p6.Taller2Punto6();
                return true;
            case "7":
                Taller2Punto7 t1p7= new Taller2Punto7();
                t1p7.Taller2Punto7();
                return true;
            case "0":
                System.out.println("Programa finalizado.");
                return false;
            default:
                System.out.println("Opcion incorrecta");
                // add break line:
                System.out.println("");
        }
        return true;
    }

    private static boolean evaluateOptionTest3() {
        switch (option) {
            case "1":
                Taller3Punto1 t3p1 = new Taller3Punto1();
                t3p1.Taller3Punto1();
                return true;
            case "2":
                Taller3Punto2 t3p2 = new Taller3Punto2();
                t3p2.Taller3Punto2();
                return true;
            case "3":
                Taller3Punto3 t3p3 = new Taller3Punto3();
                t3p3.Taller3Punto3();
                return true;
            case "4":
                Taller3Punto4 t3p4= new Taller3Punto4();
                t3p4.Taller3Punto4();
                return true;
            case "5":
                Taller3Punto5 t3p5 = new Taller3Punto5();
                t3p5.Taller3Punto5();
                return true;
            /*case "6":
                Taller3Punto6 t1p6= new Taller3Punto6();
                t1p6.Taller3Punto6();
                return true;
            case "7":
                Taller3Punto7 t1p7= new Taller3Punto7();
                t1p7.Taller3Punto7();
                return true;
            case "0":
                System.out.println("Programa finalizado.");
                return false;*/
            default:
                System.out.println("Opcion incorrecta");
                // add break line:
                System.out.println("");
        }
        return true;
    }

    private static boolean evaluateOptionTest4() {
        switch (option) {
            case "1":
                Taller4Punto1 t4p1 = new Taller4Punto1();
                t4p1.Taller4Punto1();
                return true;
            case "2":
                Taller4Punto2 t4p2 = new Taller4Punto2();
                t4p2.Taller4Punto2();
                return true;
            case "3":
                Taller4Punto3 t4p3 = new Taller4Punto3();
                t4p3.Taller4Punto3();
                return true;
            case "4":
                Taller4Punto4 t4p4= new Taller4Punto4();
                t4p4.Taller4Punto4();
                return true;
            /*case "5":
                Taller4Punto5 t4p5 = new Taller4Punto5();
                t4p5.Taller4Punto5();
                return true;
            case "6":
                Taller4Punto6 t1p6= new Taller4Punto6();
                t1p6.Taller4Punto6();
                return true;
            case "7":
                Taller4Punto7 t1p7= new Taller4Punto7();
                t1p7.Taller4Punto7();
                return true;
            case "0":
                System.out.println("Programa finalizado.");
                return false;*/
            default:
                System.out.println("Opcion incorrecta");
                // add break line:
                System.out.println("");
        }
        return true;
    }

    public static void showMenuTest1() {
        System.out.println("Taller de variables e impresion");
        System.out.println("");

        System.out.println("Seleccione el punto del taller que desea ver en ejecucion:\n");
        System.out.println("1. Punto #1.");
        System.out.println("2. Punto #2.");
        System.out.println("3. Punto #3.");
        System.out.println("4. Punto #4.");
        System.out.println("5. Punto #5.");
        System.out.println("0. Retornar al menu principal.");
    }
    public static void showMenuTest2() {
        System.out.println("Taller de Condicionales");
        System.out.println("");

        System.out.println("Seleccione el punto del taller que desea ver en ejecucion:");
        System.out.println("1. Punto #1.");
        System.out.println("2. Punto #2.");
        System.out.println("3. Punto #3.");
        System.out.println("4. Punto #4.");
        System.out.println("5. Punto #5.");
        System.out.println("6. Punto #6.");
        System.out.println("6. Punto #7.");
        System.out.println("0. Retornar al menu principal.");
    }

    public static void showMenuTest3() {
        System.out.println("Taller de ciclos");
        System.out.println("");

        System.out.println("Seleccione el punto del taller que desea ver en ejecucion:");
        System.out.println("1. Punto #1.");
        System.out.println("2. Punto #2.");
        System.out.println("3. Punto #3.");
        System.out.println("4. Punto #4.");
        System.out.println("5. Punto #5.");
        System.out.println("0. Retornar al menu principal.");
    }

    public static void showMenuTest4() {
        System.out.println("Taller de arreglos");
        System.out.println("");

        System.out.println("Seleccione el punto del taller que desea ver en ejecucion:");
        System.out.println("1. Punto #1.");
        System.out.println("2. Punto #2.");
        System.out.println("3. Punto #3.");
        System.out.println("4. Punto #4.");
        System.out.println("5. Punto #5.");
        System.out.println("0. Retornar al menu principal.");
    }

    public static void showMainMenu() {
        System.out.println("Menu principal de talleres Cantera 1");
        System.out.println("Seleccione el taller que desea ver en ejecucion:");
        System.out.println("1. Taller #1.");
        System.out.println("2. Taller #2.");
        System.out.println("3. Taller #3.");
        System.out.println("4. Taller #4.");
        System.out.println("0. Finalizar programa.");
    }
}
