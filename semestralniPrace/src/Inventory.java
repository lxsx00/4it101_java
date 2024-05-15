import java.util.ArrayList;
import java.util.List;

/**
 * The Inventory class represents a player's inventory in the game, containing the items
 * they possess and providing methods to interact with them.
 * This class is an essential component of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class Inventory {
    private List<Item> items; // Represents the list of items in the inventory.
    private final int maxCapacity; // Represents the maximum capacity of the inventory.

    /**
     * Constructor to initialize an Inventory object with a specified maximum capacity.
     */
    public Inventory(int maxCapacity) {
        this.maxCapacity = maxCapacity; // Set the maximum capacity of the inventory.
        this.items = new ArrayList<>(); // Initialize the list of items.
    }

    /**
     * Adds an item to the inventory if there is space available.
     *
     * @return True if the item was successfully added, false otherwise.
     */
    public boolean addItem(Item item) {
        if (items.size() < maxCapacity) {
            items.add(item); // Add the item to the inventory.
            return true;
        } else {
            System.out.println("Your inventory is full. You cannot carry more items.");
            return false;
        }
    }

    /**
     * Removes an item from the inventory.
     *
     * @return True if the item was successfully removed, false otherwise.
     */
    public boolean removeItem(Item itemToRemove) {
        if (items.contains(itemToRemove)) {
            items.remove(itemToRemove); // Remove the item from the inventory.
            return true; // Item successfully removed.
        } else {
            return false; // Item not found in the inventory.
        }
    }

    /**
     * Retrieves an item from the inventory by its name.
     *
     * @return The item with the specified name, or null if not found.
     */
    public Item getItemByName(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return item; // Return the item if found.
            }
        }
        return null; // Item not found.
    }

    /**
     * Checks if the inventory contains an item with the specified name.
     *
     * @return True if the inventory contains the item, false otherwise.
     */
    public boolean hasItem(String itemName) {
        for (Item item : items) {
            if (item.getName().equalsIgnoreCase(itemName)) {
                return true; // Item found in the inventory.
            }
        }
        return false; // Item not found.
    }

    /**
     * Checks if the inventory is empty.
     *
     * @return True if the inventory is empty, false otherwise.
     */
    public boolean isEmpty() {
        return items.isEmpty();
    }

    /**
     * Retrieves the list of items in the inventory.
     *
     * @return The list of items in the inventory.
     */
    public List<Item> getItems() {
        return items;
    }
}
