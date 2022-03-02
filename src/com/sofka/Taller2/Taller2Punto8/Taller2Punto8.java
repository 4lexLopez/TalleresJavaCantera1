/*
 El pastelero Don Carlos es el mejor pastelero de la ciudad y requiere
  una aplicación que le permita registrar los pedidos de los clientes en cuanto a las tortas que realiza.
  Cada torta tiene unas características propias como sabor, cantidad (porciones) y decoraciones).
  Se requiere que la aplicación permita registrar los pedidos,
  las tortas disponibles y las ventas que se registren diariamente.
 */

package com.sofka.Taller2.Taller2Punto8;

import java.util.ArrayList;
import java.util.Scanner;

public class Taller2Punto8 {
    private ArrayList<Cake> cakeList;
    private ArrayList<Cake> orderedCakes;
    private ArrayList<Order> orderList;
    private Scanner input;
    private boolean showMenu;
    private int selectedOption;
    private int orderNumber;
    private boolean readyToPay;

    public void Taller2Punto8() {

        cakeList = new ArrayList<>();
        orderList = new ArrayList<>();
        orderedCakes = new ArrayList<>();
        input = new Scanner(System.in);
        orderNumber = 0;

        showMenu = true;
        // preset all the movies available in the store
        setCakesList();

        while (showMenu) {
            showMainMenu();
            selectedOption = getInputInt();
            showMenu = evaluateOption(selectedOption);
        }
    }

    private boolean evaluateOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                readyToPay = false;
                // clear the ordered cakes list every time a new order is just setting up:
                orderedCakes.clear();
                System.out.println("Registrar orden\n");
                sellCake();
                return true;
            case 2:
                getAvailableCakes();
                return true;
            case 3:
                getDailySales();
                return true;
            default:
                System.out.println("Opcion incorrecta, intente nuevamente");
                return true;
            case 0:
                return false;
        }
    }

    private void getDailySales() {
        int total = 0;
        for (int i = 0; i < orderList.size(); i++) {
            total += orderList.get(i).getOrderValue();
        }
        System.out.println("El total del ventas del dia es: $" + total);
    }

    private void sellCake() {
        System.out.println("Facturacion:\n");
        // order number will be a self-increased number starting from 1
        orderNumber++;
        // create a new order object
        Order order = new Order();
        order.setOrderId(orderNumber);
        orderList.add(order);
        setupOrder(orderNumber);
    }


    private void setupOrder(int orderNumber) {
        int index;
        int amount;
        int total;
        boolean addCakes = true;
        while (addCakes) {
            index = askForCakeId();
            amount = decreaseCakesStock(index);
            addCakes = askForCakes();
            if(amount > 0) {
                modifyOrderedCakesList(amount, index);
            }

        }
        total = finishOrder();
        showOrderSummary(total);
    }

    private void showOrderSummary(int total) {
        System.out.println("Resumen del pedido:\n");
        System.out.println("ID      Cantidad        Nombre      Precio Unitario");
        for (int i = 0; i < orderedCakes.size(); i++) {
            if (orderedCakes.get(i).getAmount() > 0) {
                System.out.println(orderedCakes.get(i).getId() + "\t\t"
                        + orderedCakes.get(i).getAmount() + "\t\t"
                        + orderedCakes.get(i).getName() + "\t\t"
                        + "$" + orderedCakes.get(i).getPrice() + "\t\t");
            }
        }
        System.out.println("");
        System.out.println("TOTAL: $ " + total);

    }

    private int finishOrder() {
        int total = 0;
        for (int i = 0; i < orderedCakes.size(); i++) {
            total += orderedCakes.get(i).getPrice() * orderedCakes.get(i).getAmount();
        }
        orderList.get(orderList.size() - 1).setOrderValue(total);
        return total;
    }

    private int askForCakeId() {
        getAvailableCakes();
        System.out.println("Digite el indice de la torta a facturar:");
        int index = getInputInt();
        // Cleaning integer buffer reader
        input.nextLine();
        return index;
    }

    private boolean askForCakes() {
        System.out.println("Desea agregar mas tortas a la orden? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "S":
            case "s":
                return true;
            case "N":
            case "n":
                return false;
            case "":
            default:
                System.out.println("Opcion incorrecta, intente nuevamente\n");
        }
        return true;
    }

    private int decreaseCakesStock(int index) {
        int amount = 0;
        // check if the number is in between cakesList indexes
        if(index > 0 && index <= cakeList.size()) {
            if(cakeList.get(index - 1).getAmount() > 0) {
                System.out.println("\nDigite la cantidad de tortas a facturar:");
                amount = getInputInt();
                // Cleaning integer buffer reader
                input.nextLine();
                if (cakeList.get(index - 1).getAmount() >= amount) {
                    // reduce the current cakes stock based in the amount of the order
                    cakeList.get(index - 1).setAmount((cakeList.get(index - 1).getAmount()) - amount);
                    System.out.println("cantidad no disponible, intente nuevamente");
                    return 0;
                }
            } else {
                System.out.println("cantidad invalida, intente nuevamente");
            }
        } else {
            System.out.println("Indice no valido, intente nuevamente");
        }
        return amount;
    }

    // orderNumber: self-increased integer for order number
    // amount: amount of cakes of ID: index required for the order
    // index: cake ID
    private void modifyOrderedCakesList(int amount, int index) {
        // retrieving all the attributes from the target cake object:
        int id = cakeList.get(index - 1).getId();
        String name = cakeList.get(index - 1).getName();
        int price = cakeList.get(index - 1).getPrice();
        int portions = cakeList.get(index - 1).getPortions();
        String decoration = cakeList.get(index - 1).getDecoration();
        Cake cake = new Cake(id, name, price, portions, decoration, amount);
        orderedCakes.add(cake);
    }

    private void getAvailableCakes() {
        System.out.println("Listado de tortas disponibles:\n");
        System.out.println("ID      Cantidad        Nombre      Precio Unitario");
        for (int i = 0; i < cakeList.size(); i++) {
            if (cakeList.get(i).getAmount() > 0) {
                System.out.println(cakeList.get(i).getId() + "\t\t"
                        + cakeList.get(i).getAmount() + "\t\t"
                        + cakeList.get(i).getName() + "\t\t"
                        + "$" + cakeList.get(i).getPrice() + "\t\t");
            }
        }
        System.out.println("");
    }

    private void showMainMenu() {
        System.out.println("Bienvenido a Pasteleria de Don Carlos\n");
        System.out.println("Menu principal\n");
        System.out.println("Elija entre las siguientes opciones:");
        System.out.println("1. Registrar pedido");
        System.out.println("2. Consultar tortas disponibles");
        System.out.println("3. Registro de ventas");
        System.out.println("0. Finalizar aplicacion\n");
    }

    // Set all the cakes available in the bakery
    private void setCakesList() {
        Cake cake1 = new Cake(1,"Torta de vainilla", 35000, 10, "Foto de cumpleaños", 10);
        Cake cake2 = new Cake(2, "Torta de chocolate", 40000,  15, "Cubierta de caramelo", 10);
        Cake cake3 = new Cake(3, "Torta envinada", 16000,  8, "Cubierta de nueces", 10);
        cakeList.add(cake1);
        cakeList.add(cake2);
        cakeList.add(cake3);
    }

    private int getInputInt() {
        return input.nextInt();
    }

}
