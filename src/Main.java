package GroceryListApp.src;

import java.util.Scanner;

/**
 * Contenuto: Programma Gestione lista spesa.
 *
 * @author Riccardo Giacalone, Emanuele Conte.
 */
public class Main {
    public static void main(String[] args) {
        ListManager productList = new ListManager(); // Lista dei prodotti del supermercato
        
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        
        while (!exit) {
            // Mostra le opzioni del menu
            System.out.println("Seleziona un'opzione:");
            System.out.println("1. Aggiungi prodotto.");
            System.out.println("2. Rimuovi prodotto.");
            System.out.println("3. Visualizza lista prodotti.");
            System.out.println("4. Segna prodotto come completato.");
            System.out.println("5. Imposta valuta principale.");
            System.out.println("6. Salva su file.");
            System.out.println("7. Esci.");
            
            int choice = scanner.nextInt(); // Legge l'input dell'utente come intero
            scanner.nextLine(); // Consuma il carattere newline dopo la lettura dell'intero
            
            switch (choice) {
                case 1 -> {
                    System.out.println("Inserisci il nome del prodotto da aggiungere:");
                    String name = ProductUtil.readLine(scanner);
                    Product newProduct = new Product(name); // Legge il nome del prodotto da aggiungere
                    
                    int quantity = ProductUtil.readQuantity(scanner);
                    newProduct.setQuantity(quantity);
                    
                    float price = ProductUtil.readPrice(scanner);
                    newProduct.setPrice(price);
                    
                    productList.addProduct(newProduct);
                }
                case 2 -> {
                    System.out.println("Inserisci il nome del prodotto da rimuovere:");
                    String productToRemove = ProductUtil.readLine(scanner);
                    productList.removeProduct(productToRemove);
                }
                case 3 -> {
                    productList.displayProductList();
                    double totalExpanse = productList.totalCalculationExpanse();
                    System.out.println("Totale spesa stimato: " + productList.getCurrencySymbol() + totalExpanse);
                }
                case 4 -> {
                    System.out.println("Inserisci il nome del prodotto da segnare come completato:");
                    String productToComplete = ProductUtil.readLine(scanner);
                    productList.markProductAsCompleted(productToComplete);
                }
                case 5 -> {
                    System.out.println("Inserisci il simbolo della valuta desiderata:");
                    String newCurrencySymbol = scanner.nextLine();
                    productList.setCurrencySymbol(newCurrencySymbol);
                    System.out.println("Simbolo della valuta impostato su " + newCurrencySymbol);
                }
                case 6 -> {
                    System.out.println("Inserisci il nome del file in cui salvare la lista:");
                    String fileName = scanner.nextLine();
                    productList.saveToFile(fileName);
                }
                case 7 -> {
                    exit = true;
                    System.out.println("Grazie per aver utilizzato il programma. Arrivederci!");
                }
                default -> System.out.println("Opzione non valida. Riprova.");
            }
        }
        
        scanner.close();
    }
}









