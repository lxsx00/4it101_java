import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ShoppingCart {
    private List<Item> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (Item item : items) {
            totalPrice += item.getPricePerUnit() * item.getQuantity();
        }
        return totalPrice;
    }

    public double getTotalPriceWithDiscount(double discount) {
        double totalPrice = getTotalPrice();
        return totalPrice - (totalPrice * (discount / 100));
    }

    public void add(Item item) {
        items.add(item);
    }

    public Set<String> getItemNames() {
        Set<String> itemNames = new HashSet<>();
        for (Item item : items) {
            itemNames.add(item.getName());
        }
        return itemNames;
    }


    //something extra
    public double getAveragePrice() {
        if (items.isEmpty()) {
            return 0;
        }
        double totalPrice = 0;
        int totalQuantity = 0;
        for (Item item : items) {
            totalPrice += item.getPricePerUnit() * item.getQuantity();
            totalQuantity += item.getQuantity();
        }
        return totalPrice / totalQuantity;
    }

}

/* note for my future me
*
* ArrayList provides us with an ordered list of items with their quantities,
* while HashSet provides us with unique item names without duplicates.
* In our specific example, this division makes sense for representing
* the shopping cart.
*
 */
