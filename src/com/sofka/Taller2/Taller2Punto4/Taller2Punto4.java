/*
 La video tienda que presta sus servicios de alquiler de películas a los usuarios del barrio el Porvenir,
 requiere de una aplicación que permita registrar el alquiler de las películas que adquieren sus usuarios.
 Para cada usuario se debe permitir la opción de alquilar película,
 consultar películas disponibles y
 recibir película en la video tienda con la opción de realizar anotaciones sobre estas
 si se llegan a presentar daños u otra novedad sobre la película.
 */

package com.sofka.Taller2.Taller2Punto4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Taller2Punto4 {
    private String customerFirstName;
    private String customerLastName;
    private int selectedOption;
    private String customerId;
    private boolean showMenu;

    private Scanner input;
    private Movie[] moviesList;
    private HashMap<String, Customer> customersList;

    public void Taller2Punto4() {
        input = new Scanner(System.in);
        moviesList = new Movie[4];
        customersList = new HashMap<>();
        showMenu = true;
        // preset all the movies available in the store
        setMovieList();

        while (showMenu) {
            showMainMenu();
            selectedOption = getInputInt();
            showMenu = evaluateOption(selectedOption);
        }
    }

    private boolean evaluateOption(int selectedOption) {
        switch (selectedOption) {
            case 1:
                rentMovie();
                return true;
            case 2:
                getAvailableMovies();
                return true;
            case 3:
                returnMovie();
                return true;
            case 0:
                return false;
        }
        return true;
    }

    private void showMainMenu() {
        System.out.println("Bienvenido a su video-tienda del barrio El Povernir\n");
        System.out.println("Menu principal\n");
        System.out.println("Elija entre las siguientes opciones:");
        System.out.println("1. Alquilar película");
        System.out.println("2. Consultar películas disponibles");
        System.out.println("3. Retornar película");
        System.out.println("0. Finalizar aplicacion\n");
    }

    // Set all the movies available in the video-store
    // with no additional notes and full availability
    private void setMovieList() {
        moviesList[0] = new Movie();
        moviesList[0].setMovieId(1);
        moviesList[0].setMovieName("vertigo");
        moviesList[0].setMovieAvailable(true);
        moviesList[0].setMovieNotes("");
        moviesList[1] = new Movie();
        moviesList[1].setMovieId(2);
        moviesList[1].setMovieName("Jeepers Creepers");
        moviesList[1].setMovieAvailable(true);
        moviesList[1].setMovieNotes("");
        moviesList[2] = new Movie();
        moviesList[2].setMovieId(3);
        moviesList[2].setMovieName("Casablanca");
        moviesList[2].setMovieAvailable(true);
        moviesList[2].setMovieNotes("");
        moviesList[3] = new Movie();
        moviesList[3].setMovieId(4);
        moviesList[3].setMovieName("Citizen Kane");
        moviesList[3].setMovieAvailable(true);
        moviesList[3].setMovieNotes("");
    }

    private void rentMovie() {
        System.out.println("Digite el indice de la pelicula a prestar:");
        getAvailableMovies();
        int index = getInputInt();
        // Cleaning integer buffer reader
        // DONE: check it out if cleaning buffer function is affecting how movie id is caught in the variable
        input.nextLine();
        // making sure that indexes range match with those in moviesList
        if (index > 0 && index <= moviesList.length) {
            if (isMovieAvailable(index)) {
                askCustomerFirstName();
                customerFirstName = input.nextLine();
                askCustomerLastName();
                customerLastName = input.nextLine();
                askCustomerId();

                // Creating a customer
                customerId = input.nextLine();
                Customer customer = new Customer();
                customer.setCustomerId(customerId);
                customer.setCustomerFirstName(customerFirstName);
                customer.setCustomerLastName(customerLastName);

                // adding customer to the hashMap
                customersList.put(Integer.toString(index), customer);

                // switching availability state of the movie
                updateAvailableMovies(index);
                System.out.println("La pelicula " + moviesList[index - 1].getMovieName() + " ha sido registrada como prestada\n");
            } else {
                System.out.println("Indice de pelicula no disponible");
            }
        } else {
            System.out.println("Indice de pelicula incorrecto, intente nuevamente");
        }
    }

    private void returnMovie() {
        System.out.println("Digite el indice de la pelicula a retornar:");
        int index = getInputInt();
        // Cleaning integer buffer reader
        // DONE: check it out if cleaning buffer function is affecting how movie id is caught in the variable
        input.nextLine();
        // making sure that indexes range match with those in moviesList
        if (index > 0 && index <= moviesList.length) {
            if (!isMovieAvailable(index)) {
                addReturnNote(index);
                // remove the customers from pending to return movies
                customersList.remove(index);
                updateAvailableMovies(index);
                System.out.println("Pelicula " + moviesList[index - 1].getMovieName() + " ha sido retornada satisfactoriamente");
            } else {
                System.out.println("Indice de pelicula no se registra en prestamo");
            }
        } else {
            System.out.println("Indice de pelicula incorrecto, intente nuevamente");
        }
        System.out.println("");
    }

    private boolean isMovieAvailable(int index) {
        return (moviesList[index - 1].getMovieAvailable());
    }

    private void getAvailableMovies() {
        System.out.println("Listado de peliculas disponibles:\n");
        for (int i = 0; i < moviesList.length; i++) {
            if (moviesList[i].getMovieAvailable()) {
                System.out.println(moviesList[i].getMovieId() + ". " + moviesList[i].getMovieName() + "\n");
            }
        }
    }

    private void updateAvailableMovies(int index) {
        // set the availability status of the movie to the opposite of current state
        moviesList[index - 1].setMovieAvailable(!moviesList[index - 1].getMovieAvailable());
    }

    private void addReturnNote(int index) {
        String note = "";
        System.out.println("La pelicula retornada presenta alguna novedad?");
        note = input.nextLine();
        if (note.length() == 0) {
            moviesList[index - 1].setMovieNotes(moviesList[index - 1].getMovieNotes() + "Sin novedad\n---------------\n");
        } else {
            moviesList[index - 1].setMovieNotes(moviesList[index - 1].getMovieNotes() + note);
        }
    }

    private void askCustomerFirstName() {
        System.out.println("Nombre del Cliente");
    }

    private void askCustomerLastName() {
        System.out.println("Apellido del cliente");
    }

    private void askCustomerId() {
        System.out.println("Numero de identificacion del cliente");
    }

    private int getInputInt() {
        return input.nextInt();
    }
}
