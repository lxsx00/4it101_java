/**
 * The Item class represents an item within the game.
 * It defines functionality related to the properties and behavior of items.
 * This class is an integral part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class Item {
    private String name; // Represents the name of the item.

    /**
     * Constructor to initialize an Item object with a specified name.
     */
    public Item(String name) {
        this.name = name; // Set the name of the item.
    }

    /**
     * Retrieves the name of the item.
     *
     * @return The name of the item.
     */
    public String getName() {
        return name; // Return the name of the item.
    }
}
