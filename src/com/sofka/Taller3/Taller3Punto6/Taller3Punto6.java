/*
 Se está creando una aplicación que va a estar conectada con un prototipo
  que permita almacenar contactos telefónicos en el dispositivo.
  Para ello cada contacto debe contener nombre completo, teléfono y organización.
  Se requiere que la aplicación permita
  añadir 3 contactos verificando que el número no esté almacenado,
  buscar contactos almacenados y eliminar contactos si el usuario lo requiere.
  Recuerde que el sistema debe terminar cuando el usuario así lo indique.
 */

package com.sofka.Taller3.Taller3Punto6;

import java.util.*;

public class Taller3Punto6 {
    private Scanner input;
    private HashMap<String, Contact> contactList;
    private HashMap<String, Contact> foundContacts;
    private int selectedOption;
    private boolean showMenu;

    public void Taller3Punto6() {
        showMenu = true;
        contactList = new HashMap<>();
        foundContacts = new HashMap<>();
        input = new Scanner(System.in);

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
                addContact();
                return true;
            case 2:
                searchContact();
                return true;
            case 3:
                removeContact();
                return true;
            default:
                System.out.println("Opcion incorrecta, intente nuevamente");
                return true;
            case 0:
                return false;
        }
    }

    private boolean confirmDelete() {
        System.out.println("\nConfirma eliminar contacto? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "N":
            case "n":
            case "":
                System.out.println("Cancelado");
                return false;
            case "S":
            case "s":
                System.out.println("Contacto eliminado");
                return true;
            default:
                System.out.println("Opcion incorrecta, borrado cancelado\n");
                break;
        }
        return false;
    }

    private void removeContact() {
        int index;
        boolean delete = false;
        System.out.println("Eliminar contacto\n");
        System.out.println("Digite el indice de contacto a eliminar: \n");
        showContactsList();
        index = input.nextInt();
        input.nextLine();
        delete = confirmDelete();
        if (delete) {
            flushContact(index);
        } else {
            System.out.println("Operación cancelada, el contacto no fue eliminado.");
        }
    }

    private void flushContact(int index) {
        Map copy = new LinkedHashMap(contactList);

        
    }

    private void showContactsList() {
        int index = 1;
        System.out.println("ID      Telefono      Nombre        Apellido      Organizacion");
        for (String i : contactList.keySet()) {

            System.out.println(index + "\t\t" + i + "\t\t"
                    + contactList.get(i).getFirstName() + "\t\t"
                    + contactList.get(i).getLastName() + "\t\t"
                    + contactList.get(i).getOrg() + "\t\t");
        }
        System.out.println("");
    }

    private void searchContact() {
        if(contactList.size() == 0) {
            System.out.println("Lista de contatos vacia.\n");
        } else {
            foundContacts.clear();
            String stringToCheck;
            stringToCheck = validateInput();

            lookInTelnumber(stringToCheck);
            lookInFirstName(stringToCheck);
            lookInLastName(stringToCheck);
            lookInOrg(stringToCheck);

            if(foundContacts.size() > 0) {
                System.out.println("Texto encontrado:\n");
                showContactSummary(foundContacts);
            } else {
                System.out.println("Contacto no encontrado");
            }
        }
    }

    private void showContactSummary(HashMap<String, Contact> listToCheck) {
        System.out.println("Telefono      Nombre        Apellido      Organizacion");
        for (String i : listToCheck.keySet()) {
            System.out.println(i + "\t\t"
                    + listToCheck.get(i).getFirstName() + "\t\t"
                    + listToCheck.get(i).getLastName() + "\t\t"
                    + listToCheck.get(i).getOrg() + "\t\t");
        }
        System.out.println("");
    }

    private void lookInOrg(String stringToCheck) {
        for (String i : contactList.keySet()) {
            if(stringToCheck.equals(contactList.get(i).getOrg())) {
                foundContacts.put(i, contactList.get(i));
            }
        }
    }

    private void lookInLastName(String stringToCheck) {
        for (String i : contactList.keySet()) {
            if(stringToCheck.equals(contactList.get(i).getLastName())) {
                foundContacts.put(i, contactList.get(i));
            }
        }
    }

    private void lookInFirstName(String stringToCheck) {
        for (String i : contactList.keySet()) {
            if(stringToCheck.equals(contactList.get(i).getFirstName())) {
                foundContacts.put(i, contactList.get(i));
            }
        }
    }

    private void lookInTelnumber(String stringToCheck) {
        for (String i : contactList.keySet()) {
            if(stringToCheck.equals(i)) {
                foundContacts.put(i, contactList.get(i));
            }
        }
    }

    private String validateInput() {
        boolean invalidInput = true;
        String toLookFor = "";
        while(invalidInput) {
            System.out.println("Digite el texto a buscar en la lista de contactos");
            toLookFor = input.nextLine();
            if(toLookFor.length() == 0) {
                System.out.println("El campo no puede estar vacio, intente nuevamente");
            } else {
                invalidInput = false;
            }
        }
        return toLookFor;
    }

    private void addContact() {
        boolean numberExists;
        String number;
        String contactFirstName = "";
        String contactLastName = "";
        String orgName = "";
        System.out.println("Nuevo Contacto\n");
        number = requestNumber();
        numberExists = checkNumber(number);
        if(!numberExists) {
            contactFirstName = getContactFirstName();
            contactLastName = getContactLastName();
            orgName = getOrgName();
            createContact(number, contactFirstName, contactLastName, orgName);
        } else {
            System.out.println("El numero de contacto ya existe, intente nuevamente");
        }
    }

    private void createContact(String number, String contactFirstName, String contactLastName, String orgName) {
        Contact contact = new Contact(contactFirstName, contactLastName, orgName);
        contactList.put(number, contact);
    }

    private String getOrgName() {
        System.out.println("Digite el nombre de la organizacion del nuevo contacto");
        return input.nextLine();
    }

    private String getContactFirstName() {
        String firstName = "";
        System.out.println("Digite el nombre del nuevo contacto");
        firstName = input.nextLine();
        return firstName;
    }

    private String getContactLastName() {
        String lastName = "";
        System.out.println("Digite el nombre del nuevo contacto");
        lastName = input.nextLine();
        return lastName;
    }

    private String requestNumber() {
        String number;
        System.out.println("Digite el numero del nuevo contacto");
        number = input.nextLine();
        while(number.length() == 0) {
            System.out.println("Debe digitar el numero para continuar");
            number = input.nextLine();
        }
        return number;
    }

    private boolean checkNumber(String number) {
        return contactList.containsKey(number);
    }

    private void showMainMenu() {
        System.out.println("Agenda de contactos\n");
        System.out.println("Menu principal\n");
        System.out.println("Elija entre las siguientes opciones:");
        System.out.println("1. Crear nuevo contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Borrar contacto");
        System.out.println("0. Salir\n");
    }


    private int getInputInt() {
        return input.nextInt();
    }

}
