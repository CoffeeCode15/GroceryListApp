package GroceryListApp.src;

import java.util.List;

public class ListManager {
    private List <String> productList;

    public ListManager(List<String> productList) {
        this.productList = productList;
    }

    public void addProduct(String product) {
        productList.add(product); // Aggiunge il prodotto alla lista
        System.out.println(product + " è stato aggiunto alla lista.");
    }

    public void removeProduct(String product) {
        if (productList.remove(product)) {
            // Rimuove il prodotto dalla lista e notifica l'utente
            System.out.println(product + " è stato rimosso dalla lista.");
        } else {
            // Se il prodotto non è presente, notifica l'utente
            System.out.println(product + " non è presente nella lista.");
        }
    }

    public void displayProductList() {
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
