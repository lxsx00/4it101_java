import java.util.HashMap;
import java.util.Map;

/**
 * The Room class represents a room within the game, containing its name, description, exits to other rooms,
 * items present in the room, and the player's inventory.
 * This class is part of a simple text-based game.
 *
 *  @author Lucie Suchomelová
 *  @version for the academic year 2023/2024
 *
 */

public class Room {
    private String name; // The name of the room.
    private String description; // The description of the room.

    private HashMap<String, Room> exits; // Mapping of exit directions to neighboring rooms.
    private Map<String, Item> items; // Mapping of item names to items present in the room.

    private boolean roomChanged; // Flag indicating whether the room has changed.

    private Inventory inventory; // The player's inventory.
    public Room currentRoom; // The current room.
    public Game game; // Reference to an instance of the Game class for game-related operations.

    /**
     * Constructs a new Room object with the specified name and description.
     */
    public Room(String name, String description) {
        this.name = name;
        this.description = description;
        this.inventory = new Inventory(3); // Initializes the player's inventory with a maximum capacity of 3.
        this.items = new HashMap<>(); // Initializes the map of items present in the room.
        exits = new HashMap<>(); // Initializes the map of exits to neighboring rooms.
    }

    /**
     * Displays the description of the current room if it has changed.
     * This method is used to inform the player about the current room's name and description when they move to a new room.
     */
    public void displayCurrentRoomDescription() {
        if (roomChanged) {
            System.out.println("Moving to the room: " + currentRoom.getName());
            System.out.println(currentRoom.getDescription());
        }
    }

    /**
     * Returns a string containing the description of the current room, including exits.
     */
    public String getDescriptionWithExitsAndItems() {
        String roomDescription = getDescription();
        String exitDirections = getExitDirections();
        String itemsInRoom = getItemsDescription();
        return roomDescription + "\n\n" + exitDirections;
    }

    /**
     * Generates a description of the items present in the room.
     * If there are no items, it indicates that there is nothing useful in the room.
     *
     * @return A string containing the description of items in the room.
     */
    public String getItemsDescription() {
        StringBuilder description = new StringBuilder("Items in the room: ");
        if (items.isEmpty()) {
            description.append("Nothing useful here, keep searching.");
        } else {
            for (Item item : items.values()) {
                description.append(item.getName()).append(", ");
            }
            // Removes the trailing comma
            description.delete(description.length() - 2, description.length());
        }
        return description.toString();
    }

    /**
     * Removes an item from the room.
     *
     * @return The removed item, if it exists; otherwise, null.
     */
    public Item removeItem(String itemName) {
        return items.remove(itemName);
    }

    /**
     * Adds an item to the room.
     */
    public void addItem(String itemName, Item item) {
        items.put(itemName, item);
    }

    /**
     * Retrieves an item from the room based on its name.
     */
    public Item getItem(String itemName) {
        return items.get(itemName);
    }

    /**
     * Sets an exit from the room to a neighboring room in a specified direction.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * Retrieves the neighboring room in the specified direction.
     *
     * @return The neighboring room in the specified direction, if it exists; otherwise, null.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * Retrieves a string containing directions to available exits from the room.
     *
     * @return A string containing directions to available exits.
     */
    public String getExitDirections() {
        return "Available exits: " + String.join(" | ", exits.keySet());
    }

    /**
     * Retrieves a string containing the name and description of the room.
     *
     * @return A string containing the name and description of the room.
     */
    public String getDescription() {
        return name + "\n" + description;
    }

    /**
     * Retrieves the name of the room.
     *
     * @return The name of the room.
     */
    public String getName() {
        return name;
    }
}