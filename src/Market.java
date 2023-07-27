import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contenuto :Programma Gestione lista spesa.
 * Autore : Giacalone Riccardo.
 */
public class Market {
    private static List<String> productList = new ArrayList<>(); // Lista dei prodotti del supermercato

    public static void main(String[] args) {
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
                case 1:
                    System.out.println("Inserisci il nome del prodotto da aggiungere:");
                    String newProduct = scanner.nextLine(); // Legge il nome del prodotto da aggiungere
                    addProduct(newProduct);
                    break;
                case 2:
                    System.out.println("Inserisci il nome del prodotto da rimuovere:");
                    String productToRemove = scanner.nextLine(); // Legge il nome del prodotto da rimuovere
                    removeProduct(productToRemove);
                    break;
                case 3:
                    displayProductList();
                    break;
                case 4:
                    exit = true;
                    System.out.println("Grazie per aver utilizzato il programma. Arrivederci!");
                    break;
                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }

        scanner.close();
    }

    private static void addProduct(String product) {
        productList.add(product); // Aggiunge il prodotto alla lista
        System.out.println(product + " è stato aggiunto alla lista.");
    }

    private static void removeProduct(String product) {
        if (productList.remove(product)) {
            // Rimuove il prodotto dalla lista e notifica l'utente
            System.out.println(product + " è stato rimosso dalla lista.");
        } else {
            // Se il prodotto non è presente, notifica l'utente
            System.out.println(product + " non è presente nella lista.");
        }
    }

    private static void displayProductList() {
        if (productList.isEmpty()) {
            // Se la lista è vuota, notifica l'utente
            System.out.println("La lista è vuota.");
        } else {
            // Altrimenti, visualizza i prodotti presenti nella lista
            System.out.println("Lista prodotti:");
            for (String product : productList) {
                System.out.println("- " + product);
            }
        }
    }
}









