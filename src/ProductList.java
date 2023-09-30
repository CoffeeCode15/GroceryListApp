package GroceryListApp.src;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;


public class ProductList {
    protected List<Product> productList;
    protected String currencySymbol;
    
    public ProductList() {
        this.productList = new ArrayList<>();
        this.currencySymbol = "€";
    }
    
    public boolean addProduct(Product newProduct) {
        System.out.println("Prodotto aggiunto alla lista.");
        return productList.add(newProduct); // Aggiunge il prodotto alla lista
    }
    
    public void setCurrencySymbol(String symbol) {
        currencySymbol = symbol;
    }
    
    public String getCurrencySymbol() {
        return currencySymbol;
    }
    
    public boolean removeProduct(String productToDelete) {
        for (Product product : productList) {
            if (Objects.equals(product.getName(), productToDelete)) {
                // Rimuove il prodotto dalla lista e notifica l'utente
                System.out.println("Prodotto rimosso dalla lista.");
                return productList.remove(product);
            } else {
                // Se il prodotto non è presente, notifica l'utente
                System.out.println("Prodotto non presente nella lista.");
            }
        }
        return false;
    }
    
    public enum SortMethods {
        ALPHABETICAL,
        PRICE
        // Aggiungi altri criteri se necessario
    }
    
    
    public void displayProductList(SortMethods sortCriteria) {
        Comparator<Product> comparator = null;
        // Specifica del metodo di ordinamento
        if (sortCriteria == SortMethods.ALPHABETICAL) {
            comparator = Comparator.comparing(Product::getName);
        } else if (sortCriteria == SortMethods.PRICE) {
            comparator = Comparator.comparing(Product::getPrice);
        }
        
        if (comparator != null) {
            AtomicInteger i = new AtomicInteger(1); // AtomicInteger serve a inizializzare iteratori da utilizzare in lamba espression come il forEach
            productList.stream()
                    .sorted(comparator)
                    .forEach(product -> {
                        String isCompleted = (product.isCompleted()) ? "✅" : "";
                        System.out.println(i.getAndIncrement() + "- " + product.getName() + " x" + product.getQuantity() + " (" +
                                currencySymbol + product.getPrice() + ")" + isCompleted);
                    });
        } else {
            // Gestione dell'ordinamento non specificato o non valido
            System.out.println("Criterio di ordinamento non valido.");
        }
    }
    
    public float totalCalculationExpanse() {
        return productList.stream()
                .map(product -> product.getQuantity() * product.getPrice())
                .reduce(0f, Float::sum);
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
    
    // Questo metodo dovrebbe salvare la lista in un file
    public void saveToFile(String fileName) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
            for (Product product : productList) {
                writer.println(product.getName() + ", x" + product.getQuantity() + ", " + product.getPrice() + currencySymbol);
            }
            System.out.println("Lista salvata nel file: " + fileName);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio del file: " + e.getMessage());
        }
    }
    
    // Questo metodo dovrebbe importare la lista da un file
    public void importFromFile(String fileName) {
        try (Stream<String> reader = Files.lines(Paths.get(fileName))) {
            reader.forEach(line -> {
                // Analizza ogni riga e aggiungi un nuovo prodotto alla lista productList
                String[] parts = line.split(",");
                String name = parts[0];
                String[] quantitySplit = parts[1].split("x");
                int quantity = Integer.parseInt(quantitySplit[1]);
                float price = Float.parseFloat(parts[2].substring(1, parts[2].length() - 1));
                productList.add(new Product(name, quantity, price));
            });
            System.out.println("Lista importata dal file: " + fileName);
        } catch (IOException e) {
            System.out.println("Errore durante l'importazione del file: " + e.getMessage());
        }
    }
    
    public void findProduct (String productName) {
        for (Product product : productList) {
            if (Objects.equals(product.getName(), productName)) {
                System.out.println(product.getName() + ", " + product.getQuantity() + ", " + product.getPrice());
                return;
            } else {
                System.out.println("Prodotto non trovato.");
            }
        }
    }
}
