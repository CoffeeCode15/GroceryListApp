package GroceryListApp.src;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ProductSearchTest {
    private ProductSearch productSearch;


    public void setUp() {
        productSearch = new ProductSearch();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("prodotto1");
        productSearch.addProduct(product);

        Product retrievedProduct = productSearch.findProduct("Prodotto1");
        assertEquals(product, retrievedProduct);
    }

    @Test
    public void testFindProduct() {
        Product product = new Product("prodotto2");
        productSearch.addProduct(product);

        Product retrievedProduct = productSearch.findProduct("Prodotto2");
        assertEquals(product, retrievedProduct);
    }

    @Test
    public void testFindProductNotFound() {
        Product retrievedProduct = productSearch.findProduct("NonexistentProduct");
        assertNull(retrievedProduct);
    }

}