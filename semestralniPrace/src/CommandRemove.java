/**
 * The CommandRemove class implements the remove command for the game.
 * The remove command allows the player to remove an item from their inventory.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandRemove implements ICommand {
    private Game game;

    /**
     * Constructs a CommandRemove object with the specified game.
     */
    public CommandRemove(Game game) {
        this.game = game;
    }

    /**
     * Executes the remove command to remove an item from the player's inventory.
     */
    @Override
    public void execute(String[] parts) {
        if (parts.length > 1) {
            String itemName = parts[1];
            System.out.println("Item name: " + itemName); // Print the item name for diagnostics

            Inventory playerInventory = game.getPlayerInventory();

            // Remove the item from the player's inventory
            Item itemToRemove = playerInventory.getItemByName(itemName);
            boolean removed = playerInventory.removeItem(itemToRemove);
            if (removed) {
                System.out.println("You removed " + itemName + " from your inventory.");
            } else {
                System.out.println("You don't have " + itemName + " in your inventory.");
            }
        } else {
            System.out.println("Please specify an item to remove from your inventory.");
        }
    }
}
