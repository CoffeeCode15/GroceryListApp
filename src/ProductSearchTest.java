package GroceryListApp.src;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductSearchTest {

    private ProductSearch productSearch;

@Test
    public void setUp() {
        c = new ProductSearch();
    }


    @Test
    public void testAddProduct() {
    setUp();
        Product product0 = new Product("Product0");
       productSearch.addProduct(product0);
        assertEquals(product0, productSearch.findProduct("Product0"));
    }


    @Test
    public void testFindProduct() {
    setUp();
        Product product = new Product("Product1");
        productSearch.addProduct(product);
        assertEquals(product, productSearch.findProduct("Product1"));

    }

    @Test
    public void testFindProductNonExistent() {
        ProductSearch productSearch = new ProductSearch();

        assertNull(productSearch.findProduct("NonexistentProduct"));
    }
}
