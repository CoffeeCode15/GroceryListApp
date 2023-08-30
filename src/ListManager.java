package GroceryListApp.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class ListManager {
    private List<Product> productList;
    private String currencySymbol;
    
    public ListManager() {
        this.productList = new ArrayList<>();
        this.currencySymbol = "€";
    }
    
    public void addProduct(Product newProduct) {
        productList.add(newProduct); // Aggiunge il prodotto alla lista
        System.out.println("Prodotto aggiunto alla lista.");
    }
    
    public void setCurrencySymbol(String symbol) {
        currencySymbol = symbol;
    }
    
    public String getCurrencySymbol() {
        return currencySymbol;
    }
    
    public void removeProduct(String productToDelete) {
        for (Product product : productList) {
            if (Objects.equals(product.getName(), productToDelete)) {
                // Rimuove il prodotto dalla lista e notifica l'utente
                productList.remove(product);
                System.out.println("Prodotto rimosso dalla lista.");
            } else {
                // Se il prodotto non è presente, notifica l'utente
                System.out.println("Prodotto non presente nella lista.");
            }
        }
    }
    
    public void displayProductList() {
        if (productList.isEmpty()) {
            // Se la lista è vuota, notifica l'utente
            System.out.println("La lista è vuota.");
        } else {
            // Altrimenti, visualizza i prodotti presenti nella lista
            System.out.println("Lista prodotti:");
            int i = 1;
            for (Product product : productList) {
                System.out.println(i + "- " + product.getName() + " x" + product.getQuantity() + " (€" + product.getPrice() + ")");
                i++;
            }
        }
    }
    
    public double totalCalculationExpanse() {
        double totalExpanse = 0;
        for (Product product : productList) {
            totalExpanse += product.getQuantity() * product.getPrice();
        }
        return totalExpanse;
    }
    
    public void markProductAsCompleted(String productToComplete) {
        for (Product product : productList) {
            if (Objects.equals(product.getName(), productToComplete)) {
                product.setCompleted(true); // Aggiungi un nuovo attributo booleano "completed" alla classe Product
                System.out.println("Prodotto segnato come completato.");
                return;
            }
        }
        System.out.println("Prodotto non trovato nella lista.");
    }
    
    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Product product : productList) {
                writer.println(product.getName() + "," + product.getQuantity() + "," + product.getPrice());
            }
            System.out.println("Lista salvata nel file: " + fileName);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }
}
