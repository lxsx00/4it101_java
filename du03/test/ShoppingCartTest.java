import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
/*
* his import allows us to use the static method assertTrue(),
* which verifies if a certain condition is true. If the condition
* is not true, the test fails.
 */

public class ShoppingCartTest {

    @Test
    public void testGetTotalPrice() {
        Item item1 = new Item("Tričko", 250.00, 4);
        Item item2 = new Item("Boty", 1999.90, 1);

        ShoppingCart cart = new ShoppingCart();
        cart.add(item1);
        cart.add(item2);

        assertEquals(2999.90, cart.getTotalPrice());
    }

    @Test
    public void testGetTotalPriceWithDiscount() {
        Item item1 = new Item("Kraťasy", 749.80, 2);
        Item item2 = new Item("Boty", 2500.00, 1);

        ShoppingCart cart = new ShoppingCart();
        cart.add(item1);
        cart.add(item2);

        assertEquals(3599.64, cart.getTotalPriceWithDiscount(10));
    }

    @Test
    public void testGetItemNames() {
        Item item1 = new Item("Tričko", 250.00, 2);
        Item item2 = new Item("Boty", 1999.90, 1);
        Item item3 = new Item("Tričko", 250.00, 1);

        ShoppingCart cart = new ShoppingCart();
        cart.add(item1);
        cart.add(item2);
        cart.add(item3);

        Set<String> itemNames = cart.getItemNames();
        assertEquals(2, itemNames.size());
        assertTrue(itemNames.contains("Tričko"));
        assertTrue(itemNames.contains("Boty"));
    }

    //test for extra method
    @Test
    public void testGetAveragePrice() {
        Item item1 = new Item("Tričko", 100.00, 4);
        Item item2 = new Item("Boty", 1999.90, 1);
        Item item3 = new Item("Kraťasy", 749.50, 2);

        ShoppingCart cart = new ShoppingCart();
        cart.add(item1);
        cart.add(item2);
        cart.add(item3);

        // Expected average price = (100*4 + 1999.90*1 + 750.50*2) / 7 = 3898.90 / 7 = 556.985 (so 556.99)
        double expectedAveragePrice = 556.99;
        double actualAveragePrice = cart.getAveragePrice();

        // use of assertEquals for double values with delta for precision
        assertEquals(expectedAveragePrice, actualAveragePrice, 0.01);
    }

    @Test
    public void testGetAveragePriceWhenEmpty() {
        ShoppingCart emptyCart = new ShoppingCart();

        // Expected average price for empty cart should be 0
        double expectedAveragePrice = 0;
        double actualAveragePrice = emptyCart.getAveragePrice();

        // use of assertEquals for double values with delta for precision
        assertEquals(expectedAveragePrice, actualAveragePrice, 0.01);
    }
}

