package GroceryListApp.src;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListManager {
    private List<Product> productList;

    public ListManager() {
        this.productList = new ArrayList<>();
    }

    public void addProduct(Product newProduct) {
        productList.add(newProduct); // Aggiunge il prodotto alla lista
        System.out.println("Prodotto aggiunto alla lista.");
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
}
