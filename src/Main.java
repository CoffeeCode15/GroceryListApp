package GroceryListApp.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contenuto: Programma Gestione lista spesa.
 *
 * @author Giacalone Riccardo, Emanuele Conte, Devy Cantalupo.
 */
public class Main {
    public static void main(String[] args) {
        ListManager productList = new ListManager(); // Lista dei prodotti del supermercato

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            // Mostra le opzioni del menu
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Aggiungi prodotto");
            System.out.println("2. Rimuovi prodotto");
            System.out.println("3. Visualizza lista prodotti");
            System.out.println("4. Esci");

            int choice = scanner.nextInt(); // Legge l'input dell'utente come intero
            scanner.nextLine(); // Consuma il carattere newline dopo la lettura dell'intero

            switch (choice) {
                case 1 -> {
                    System.out.println("Inserisci il nome del prodotto da aggiungere:");
                    Product newProduct = new Product(scanner.nextLine()); // Legge il nome del prodotto da aggiungere
                    productList.addProduct(newProduct);
                }
                case 2 -> {
                    System.out.println("Inserisci il nome del prodotto da rimuovere:");
                    String productToRemove = scanner.nextLine(); // Legge il nome del prodotto da rimuovere
                    productList.removeProduct(productToRemove);
                }
                case 3 -> productList.displayProductList();
                case 4 -> {
                    exit = true;
                    System.out.println("Grazie per aver utilizzato il programma. Arrivederci!");
                }
                default -> System.out.println("Opzione non valida. Riprova.");
            }
        }

        scanner.close();
    }
}









