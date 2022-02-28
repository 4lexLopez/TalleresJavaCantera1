/*
 La Droguería Mi Salud presta sus servicios en la localidad de Suba y
 requiere una aplicación para poder facturar los productos que vende a sus clientes y
 para ello, los productos tienen unas características que deben indicársele al cliente
 para que pueda escoger el producto a comprar. Para cada cliente,
 se tienen las opciones de compra de producto,
 consulta de precios por producto y
 devoluciones en caso de que se presenten.
 */

package com.sofka.Taller2.Taller2Punto5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Taller2Punto5 {
    private int selectedOption;
    private boolean showMenu, readyToPay;
    int orderNumber, totalOrder;

    private Scanner input;
    private ArrayList<Product> productsList;
    private ArrayList<Order> ordersList;

    public void Taller2Punto5() {

        input = new Scanner(System.in);
        productsList = new ArrayList<>();
        ordersList = new ArrayList<>();
        showMenu = true;

        orderNumber = 0;
        totalOrder = 0;
        // hardcode all the product stock available in the pharmacy
        setProductsList();

        while (showMenu) {
            readyToPay = false;
            showMainMenu();
            selectedOption = getInputInt();
            showMenu = evaluateOption(selectedOption);
        }
    }

    private boolean evaluateOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                sellProduct();
                return true;
            case 2:
                checkProductPrices();
                return true;
            case 3:
                returnProduct();
                return true;
            case 0:
                return false;
        }
        return true;
    }

    private void showMainMenu() {
        System.out.println("Bienvenido a su Drogueria Mi Salud\n");
        System.out.println("Menu principal\n");
        System.out.println("Elija entre las siguientes opciones:");
        System.out.println("1. Facturar");
        System.out.println("2. Consultar precios de productos");
        System.out.println("3. Retornar productos");
        System.out.println("0. Finalizar aplicacion\n");
    }

    // Set all the products available in the pharmacy
    // including their stock
    private void setProductsList() {
        Product product1 = new Product();
        product1.setProductId(1);
        product1.setProductName("Aspirina");
        product1.setProductStock(800);
        product1.setProductPrice(500);
        productsList.add(product1);
        Product product2 = new Product();
        product2.setProductId(2);
        product2.setProductName("Acetaminofen");
        product2.setProductStock(900);
        product2.setProductPrice(200);
        productsList.add(product2);
        Product product3 = new Product();
        product3.setProductId(3);
        product3.setProductName("Bloqueador solar");
        product3.setProductStock(100);
        product3.setProductPrice(45000);
        productsList.add(product3);
        Product product4 = new Product();
        product4.setProductId(4);
        product4.setProductName("Cepillo de dientes");
        product4.setProductStock(100);
        product4.setProductPrice(7000);
        productsList.add(product4);
    }

    private void sellProduct() {
        System.out.println("Facturacion:\n");
        // order number will be a self-increased number starting from 1
        orderNumber ++;
        HashMap<Integer, Integer> map = new HashMap<>();
        Order order;
        int amount;
        while(!readyToPay) {
            getAvailableProducts();
            System.out.println("Digite el indice del producto a facturar:");
            int index = getInputInt();
            // Cleaning integer buffer reader
            input.nextLine();
            // making sure that indexes range matches with those in productsList
            if (index > 0 && index <= productsList.size()) {
                if (productsList.get(index - 1).getProductStock() > 0) {
                    // adding the products to the order
                    amount = addProductsToOrder(index);
                    map.put(index, amount);
                } else {
                    System.out.println("Producto sin stock");
                }
            } else {
                System.out.println("Indice de producto incorrecto, intente nuevamente");
            }
            readyToPay = askForMoreProducts();
        }
        // after getting all the items in the order, proceed to generate it
        order = new Order(orderNumber, map);
        // calculate the order value based on hashes inside the map
        totalOrder = getTotal(map);
        order.setOrderValue(totalOrder);
        // adding the order to the order list
        ordersList.add(order);
        // printing order details:
        showOrderDetails(orderNumber);
        System.out.println("Total de la compra: $" + totalOrder);
    }


    private boolean askForMoreProducts() {
        System.out.println("Desea agregar mas productos al pedido? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "N":
            case "n":
            case "":
                return true;
            case "S":
            case "s":
                return false;
            default:
                System.out.println("Opcion incorrecta, intente nuevamente");
                break;
        }
        return false;
    }

    private boolean askForRefund() {
        System.out.println("Factura encontrada, desea retornar los productos? (s/n)");
        String answer = input.nextLine();
        switch (answer) {
            case "N":
            case "n":
            case "":
                return false;
            case "S":
            case "s":
                return true;
            default:
                System.out.println("Opcion incorrecta, intente nuevamente");
                break;
        }
        return false;
    }

    private int addProductsToOrder(int index) {
        System.out.println("Digite la cantidad de unidades a facturar");
        int amount = getInputInt();
        // Cleaning integer buffer reader
        // DONE: check it out if cleaning buffer function is affecting how movie id is caught in the variable
        input.nextLine();
        if(productsList.get(index - 1).getProductStock() >= amount) {
            // reduce the current product stock based in the amount of the order
            reduceProductStock(index, amount);
            return amount;
        } else {
            System.out.println("Stock no disponible, intente nuevamente");
        }
        return 0;
    }

    private void reduceProductStock(int index, int amount) {
        if(amount > 0) {
            productsList.get(index - 1).setProductStock(productsList.get(index - 1).getProductStock() - amount);
        } else {
            System.out.println("cantidad invalida, intente nuevamente");
        }
    }

    private void increaseProductStock(int index, int amount) {
        if(amount > 0) {
            productsList.get(index - 1).setProductStock(productsList.get(index - 1).getProductStock() + amount);
        } else {
            System.out.println("Error en el sistema");
        }
    }

    private void checkProductPrices() {
        System.out.println("Consultar Precios:\n");
        System.out.println("Digite el indice del producto a consultar:");
        int index = getInputInt();
        // Cleaning integer buffer reader
        input.nextLine();
        // making sure that indexes range matches with those in productsList
        if (index > 0 && index <= productsList.size()) {
            System.out.println("ID      Cantidad        Nombre      Precio Unitario");
            System.out.println(productsList.get(index - 1).getProductId() + "\t\t"
                    + productsList.get(index - 1).getProductStock() + "\t\t"
                    + productsList.get(index - 1).getProductName() + "\t\t"
                    + "$" + productsList.get(index - 1).getProductPrice() + "\t\t");

        } else {
            System.out.println("Indice de producto incorrecto, intente nuevamente\n\n");
        }
    }

    private void returnProduct() {
        HashMap<Integer, Integer> map;
        System.out.println("Devoluciones:\n");
        System.out.println("Digite el numero de factura a consultar:");
        int index = getInputInt();
        // Cleaning integer buffer reader
        input.nextLine();
        for (int i = 0; i < ordersList.size(); i++) {
            if(ordersList.get(i).getOrderId() == orderNumber) {
                if(askForRefund()) {
                    showRefundDetails(orderNumber);
                } else {
                    System.out.println("Devolucion cancelada");
                    break;
                }
            }
        }
    }


    private void getAvailableProducts() {
        System.out.println("Listado de productos disponibles:\n");
        System.out.println("ID      Cantidad        Nombre      Precio Unitario");
        for (int i = 0; i < productsList.size(); i++) {
            if (productsList.get(i).getProductStock() > 0) {
                System.out.println(productsList.get(i).getProductId() + "\t\t"
                        + productsList.get(i).getProductStock() + "\t\t"
                        + productsList.get(i).getProductName() + "\t\t"
                        + "$" + productsList.get(i).getProductPrice() + "\t\t");
            }
        }
        System.out.println("");
    }

    private void showOrderDetails(int orderNumber) {
        HashMap<Integer, Integer> map;
        System.out.println("Detalle de la factura:");
        System.out.println("ID      Cantidad        Nombre      Precio Unitario");
        for (int i = 0; i < ordersList.size(); i++) {
            if(ordersList.get(i).getOrderId() == orderNumber) {
                map = ordersList.get(i)
                        .getProducts();
                for (Object j : map.keySet()) {
                    // product ID:
                    System.out.print(j + "\t\t");
                    // product amount
                    System.out.print((int)map.get(j) + "\t\t");
                    // product name
                    System.out.print(productsList.get((int)j - 1).getProductName() + "\t\t");
                    // product unit price
                    System.out.print(productsList.get((int)j - 1).getProductPrice() + "\t\t\n");
                }
            }
        }

    }

    private void showRefundDetails(int orderNumber) {
        HashMap<Integer, Integer> map;
        System.out.println("Detalle de la devolucion:");
        System.out.println("ID      Cantidad        Nombre      Precio Unitario");
        for (int i = 0; i < ordersList.size(); i++) {
            if(ordersList.get(i).getOrderId() == orderNumber) {
                map = ordersList.get(i)
                        .getProducts();
                for (Object j : map.keySet()) {
                    // product ID:
                    System.out.print(j + "\t\t");
                    // product amount
                    System.out.print((int)map.get(j) + "\t\t");
                    // product name
                    System.out.print(productsList.get((int)j - 1).getProductName() + "\t\t");
                    // product unit price
                    System.out.print(productsList.get((int)j - 1).getProductPrice() + "\t\t\n");
                    // return each amount of a single product
                    increaseProductStock((int)j, map.get(j));
                    // remove the order from the list
                    ordersList.remove(i);
                    System.out.println("Devolucion exitosa");
                }
            }
        }

    }

    private int getTotal(HashMap map) {
        int totalOrder = 0;
        for (Object i : map.keySet()) {
            // search for the price in product list times the unit price of the product
            // sum this up for each group of products in the order, then return this value
            totalOrder += productsList.get((int)i - 1).getProductPrice() * (int)map.get(i);
        }
        return totalOrder;
    }

    private int getInputInt() {
        return input.nextInt();
    }
}
