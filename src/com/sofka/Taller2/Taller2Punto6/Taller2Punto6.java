/*
 El taller de motos "El Maquinista" recibe motocicletas de alto cilindraje
 para realizar las respectivas revisiones y requiere una aplicación
 que le permita registrar los servicios generados a sus clientes.
 Para cada motocicleta se debe tener registro del ingreso al taller y
 las observaciones por parte del cliente.
 También debe existir registro de salida del taller con las novedades y
 otra de arreglos hechos por el mecánico
 en caso de que se requiera inventariar cambios repuestos en la motocicleta al entregarla.
 */

package com.sofka.Taller2.Taller2Punto6;

import java.util.ArrayList;
import java.util.Scanner;

public class Taller2Punto6 {

    private String customerId;
    private String customerFirstName;
    private String customerLastName;
    private int selectedOption;
    private boolean showMenu, finishEntry, proceed;
    int entryNumber, totalOrder;

    private Scanner input;
    private ArrayList<Entry> entriesList;
    private ArrayList<Replacement> replacementList;

    public void Taller2Punto6() {
        input = new Scanner(System.in);
        replacementList = new ArrayList<>();
        entriesList = new ArrayList<>();
        showMenu = true;

        entryNumber = 0;
        totalOrder = 0;
        // hardcode all the product stock available in the workshop
        setReplacementsList();

        while (showMenu) {
            finishEntry = false;
            showMainMenu();
            selectedOption = getInputInt();
            input.nextLine();
            showMenu = evaluateOption(selectedOption);
        }
    }

    // Set all the replacement parts available in the workshop
    // including their stock, then, populate the ArrayList
    private void setReplacementsList() {
        Replacement replacement1 = new Replacement(1, "LLanta", 50);
        replacementList.add(replacement1);
        Replacement replacement2 = new Replacement(2, "Neumatico", 50);
        replacementList.add(replacement2);
        Replacement replacement3 = new Replacement(3, "Pastillas de freno", 250);
        replacementList.add(replacement3);
        Replacement replacement4 = new Replacement(4, "Bandas traseras", 100);
        replacementList.add(replacement4);
    }

    private boolean evaluateOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                entryWorkshop();
                return true;
            case 2:
                leaveWorkshop();
                return true;
            case 0:
                return false;
        }
        return true;
    }

    private void leaveWorkshop() {
        System.out.println("Menu de egreso del taller\n");
        System.out.println("Digite el numero de orden de ingreso a cerrar:");
        int entryNumber = input.nextInt();
        input.nextLine();

        proceed = validateEntry(entryNumber);
        if(proceed) {
            askForReplacements(entryNumber);
            askForFinalNotes(entryNumber);
            proceedCheckout(entryNumber);
        }
        else {
            System.out.println("Operacion cancelada\n");
        }
    }

    private void proceedCheckout(int entryNumber) {
        System.out.println("\nOrden finalizada");
        // update status to close the entry
        entriesList.get(entryNumber - 1).setInWorkshop(false);
    }

    private void askForFinalNotes(int entryNumber) {
        System.out.println("\nDigite las anotaciones del mecanico encargado del mantenimiento:");
        String updateNote = input.nextLine();
        entriesList.get(entryNumber - 1).setLeaveNote(updateNote);
    }

    private boolean validateEntry(int entryNumber) {
        if(entriesList.get(entryNumber - 1) != null) {
            if(entriesList.get(entryNumber - 1).isInWorkshop()) {
                System.out.println("Orden encontrada pendiente para retiro");
                return true;
            } else {
                System.out.println("La orden registra como cerrada.\n");
                return false;
            }
        } else {
            System.out.println("No se encuentra la orden.\n");
            return false;
        }
    }

    private void askForReplacements(int entryNumber) {

        System.out.println("Fueron utilizados repuestos en la orden? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "S":
            case "s":
                decreaseInventoryStock();
                break;
            case "N":
            case "n":
                break;
            case "":
            default:
                System.out.println("Opcion incorrecta, intente nuevamente\n");
        }
    }

    private void decreaseInventoryStock() {
        boolean addReplacement = true;
        while(addReplacement) {
            showReplacementStock();
            System.out.println("\nDigite el ID del repuesto utilizado:");
            int index = getInputInt();
            // Cleaning integer buffer reader
            input.nextLine();
            if(index > 0 && index <= replacementList.size()) {
                if(replacementList.get(index - 1).getAmount() > 0) {
                    System.out.println("\nDigite la cantidad de repuestos utilizados:");
                    int amount = getInputInt();
                    // Cleaning integer buffer reader
                    input.nextLine();
                    if (replacementList.get(index - 1).getAmount() >= amount) {
                        // reduce the current product stock based in the amount of the order
                        replacementList.get(index - 1).setAmount(replacementList.get(index - 1).getAmount() - amount);
                    } else {
                        System.out.println("cantidad no disponible, intente nuevamente");
                    }
                } else {
                    System.out.println("cantidad invalida, intente nuevamente");
                }
            } else {
                System.out.println("Indice no valido, intente nuevamente");
            }
            System.out.println("Fueron utilizados mas repuestos en la orden? (s/n)");
            String answer = input.nextLine();
            switch (answer) {
                case "S":
                case "s":
                    break;
                case "N":
                case "n":
                    addReplacement = false;
                    break;
                case "":
                default:
                    System.out.println("Opcion incorrecta, intente nuevamente\n");
            }
        }

    }

    private void showMainMenu() {
        System.out.println("Bienvenido a su Taller de motos El Maquinista\n");
        System.out.println("Menu principal\n");
        System.out.println("Elija entre las siguientes opciones:");
        System.out.println("1. Ingreso a taller");
        System.out.println("2. Salida de taller");
        System.out.println("0. Finalizar aplicacion\n\n");
    }

    private void entryWorkshop() {
        System.out.println("Menu de ingreso al taller\n");
        entryNumber++;
        // all the attributes for this object will be gathered in the loop below
        Entry entry = new Entry();

        System.out.println("Digite la placa de la moto:");
        String plate = input.nextLine();
        entry.setPlate(plate);
        System.out.println("Nombre del propietario:");
        String owner = input.nextLine();
        entry.setOwnerName(owner);
        System.out.println("Numero de contacto:");
        String number = input.nextLine();
        entry.setOwnerContactNumber(number);
        System.out.println("Motivo de ingreso al taller?:");
        String note = input.nextLine();
        entry.setEntryNote(note);

        showEntryHighlights(entry);

        addEntry(confirmEntry(), entryNumber, entry);
    }

    private void addEntry(boolean confirmEntry, int entryNumber, Entry entry) {
        if (confirmEntry) {
            entriesList.add(entry);
            System.out.println("Orden de ingreso confirmada # " + entryNumber);
        } else {
            System.out.println("Orden cancelada, intente nuevamente");
        }
    }

    private boolean confirmEntry() {
        System.out.println("\nConfirmar orden de ingreso? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "N":
            case "n":
            case "":
                System.out.println("Cancelada");
                return false;
            case "S":
            case "s":
                System.out.println("Confirmada");
                return true;
            default:
                System.out.println("Opcion incorrecta, orden cancelada\n");
                break;
        }
        return false;
    }

    private void showEntryHighlights(Entry entry) {
        System.out.println("Resumen del ingreso, verifique la informacion:\n");
        System.out.println("Placa de la moto:");
        System.out.println(entry.getPlate());
        System.out.println("Nombre del propietario:");
        System.out.println(entry.getOwnerName());
        System.out.println("Numero de contacto:");
        System.out.println(entry.getOwnerContactNumber());
        System.out.println("Motivo de ingreso al taller:");
        System.out.println(entry.getEntryNote());
    }

    private void showReplacementStock() {
        System.out.println("Listado de repuestos disponibles:\n");
        System.out.println("ID      Cantidad        Nombre");
        for (int i = 0; i < replacementList.size(); i++) {
            if (replacementList.get(i).getAmount() > 0) {
                System.out.println(replacementList.get(i).getId() + "\t\t"
                        + replacementList.get(i).getAmount() + "\t\t"
                        + replacementList.get(i).getName() + "\t\t");
            }
        }
        System.out.println("");
    }

    private int getInputInt() {
        return input.nextInt();
    }
}
