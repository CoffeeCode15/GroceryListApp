package GroceryListApp.src;

import java.util.List;

public class ProductStatistics {

    public static int totalNumberOfProducts(List<Product> products) {
        int total = 0;
        for (Product product : products) {
            total += product.getQuantity();
        }
        return total;
    }


    public static double totalCost(List<Product> products) {
        double total = 0.0;
        for (Product product : products) {
            total += product.getPrice() * product.getQuantity();
        }
        return total;
    }

    public static double averageCost(List<Product> products) {
        if (products.isEmpty()) {
            return 0.0;
        }

        int totalQuantity = totalNumberOfProducts(products);
        double totalCost = totalCost(products);

        return totalCost / totalQuantity;
    }


}
