/**
 * The CommandInventory class implements the inventory command for the game.
 * The inventory command displays the items currently in the player's inventory.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

class CommandInventory implements ICommand {
    private Game game;

    /**
     * Constructs a CommandInventory object with the specified game.
     */
    public CommandInventory(Game game) {
        this.game = game;
    }

    /**
     * Executes the inventory command, displaying the items in the player's inventory.
     */
    @Override
    public void execute(String[] args) {
        displayInventory();
    }

    /**
     * Displays the items currently in the player's inventory.
     */
    private void displayInventory() {
        Inventory playerInventory = game.getPlayerInventory();
        System.out.println("Inventory:");
        if (playerInventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
        } else {
            for (Item item : playerInventory.getItems()) {
                System.out.println("- " + item.getName());
            }
        }
    }
}
