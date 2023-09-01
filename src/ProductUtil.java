package GroceryListApp.src;

import java.util.Scanner;

public class ProductUtil {
    public static int readQuantity(Scanner scanner) {
        int quantity;
        do {
            System.out.println("Quantità da acquistare:");
            quantity = (scanner.nextInt()); //Legge la quantità di prodotto da acquistare
            if (quantity <= 0) {
                System.out.println("Inserisci una quantità pari almeno a 1");
            }
        } while (quantity <= 0);
        return quantity;
    }
    
    public static float readPrice(Scanner scanner) {
        float price;
        do {
            System.out.println("Prezzo stimato:");
            price = (scanner.nextFloat()); //Legge il prezzo stimato del prodotto
            if (price <= 0) {
                System.out.println("Inserisci un prezzo maggiore di 0");
            }
        } while (price <= 0);
        return price;
    }
}
