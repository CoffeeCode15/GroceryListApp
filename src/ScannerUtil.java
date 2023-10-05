package GroceryListApp.src;

import java.util.Scanner;

public class ScannerUtil {
    public static String readLine(Scanner scanner) {
        String name;
        do {
            while (!scanner.hasNext()) {
                System.out.println("Inserisci un nome valido.");
                scanner.next();
            }
            name = scanner.nextLine().trim();
        } while (name.isEmpty());
        return name;
    }
    
    public static int readQuantity(Scanner scanner) {
        while (true) {
            System.out.println("Quantità da acquistare:");
            if (scanner.hasNextInt()) {
                int quantity = scanner.nextInt();
                if (quantity > 0) {
                    return quantity;
                } else {
                    System.out.println("Inserisci una quantità maggiore di zero.");
                }
            } else {
                System.out.println("Inserisci un numero valido per la quantità. (intero e maggiore di zero)");
                scanner.next(); // Consuma l'input non valido per evitare il blocco
            }
        }
    }
    
    public static float readPrice(Scanner scanner) {
        while (true) {
            System.out.println("Prezzo stimato:");
            if (scanner.hasNextFloat()) {
                float price = scanner.nextFloat();
                if (price > 0) {
                    return price;
                } else {
                    System.out.println("Inserisci un prezzo maggiore di zero.");
                }
            } else {
                System.out.println("Inserisci un numero valido per il prezzo. (decimale e maggiore di zero");
                scanner.next(); // Consuma l'input non valido per evitare il blocco
            }
        }
    }
    
    public static int readSortMethod(Scanner scanner) {
        int sort;
        System.out.println("Seleziona il criterio di ordinamento:");
        System.out.println("1. Ordine Alfabetico");
        System.out.println("2. Ordine di Prezzo");
        do {
            while (!scanner.hasNextInt()) {
                System.out.println("Inserisci un numero valido.");
                scanner.next(); // Consuma l'input type errato per evitare il crush del programma
            }
            sort = scanner.nextInt(); //Legge il metodo di sorting (1 o 2)
            if (sort < 1 || sort > 2) {
                System.out.println("Inserisci un numero valido.");
            }
        } while (sort < 1 || sort > 2);
        
        return sort;
    }
}
