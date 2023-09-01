package GroceryListApp.src;

import java.util.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import static GroceryListApp.src.ListManager.SortMethods.ALPHABETICAL;
import static GroceryListApp.src.ListManager.SortMethods.PRICE;


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
    
    public enum SortMethods {
        ALPHABETICAL,
        PRICE
        // Aggiungi altri criteri se necessario
    }
    
    
    public void displayProductList(SortMethods sortCriteria) {
        // Ordina la lista in base al criterio specificato
        if (sortCriteria.equals(ALPHABETICAL)) {
            productList.sort(Comparator.comparing(Product::getName));
        } else if (sortCriteria.equals(PRICE)) {
            productList.sort(Comparator.comparing(Product::getPrice));
            // Aggiungi altri criteri di ordinamento se necessario
        }
        
        if (productList.isEmpty()) {
            System.out.println("La lista è vuota.");
        } else {
            System.out.println("Lista prodotti:");
            int i = 1;
            for (Product product : productList) {
                String isCompleted = (product.isCompleted()) ? "✅" : "";
                System.out.println(i + "- " + product.getName() + " x" + product.getQuantity() + " (" +
                        currencySymbol +
                        product.getPrice() +
                        ")" + isCompleted);
                i++;
            }
        }
    }
    
    
    public float totalCalculationExpanse() {
        float totalExpanse = 0;
        for (Product product : productList) {
            totalExpanse += product.getQuantity() * product.getPrice();
        }
        return totalExpanse;
    }
    
    public void markProductAsCompleted(String productToComplete) {
        for (Product product : productList) {
            if (Objects.equals(product.getName(), productToComplete)) {
                product.setCompleted(); // Setta il prodotto come completo
                System.out.println("Prodotto segnato come completato.");
                return;
            }
        }
        System.out.println("Prodotto non trovato nella lista.");
    }
    
    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            int iterator = 1;
            for (Product product : productList) {
                writer.println(iterator + "- " + product.getName() + ", x" + product.getQuantity() + ", " + product.getPrice() + currencySymbol);
            }
            System.out.println("Lista salvata nel file: " + fileName);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }
}
