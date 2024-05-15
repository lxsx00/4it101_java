/**
 * The CommandPick class implements the pick command for the game.
 * The pick command allows the player to pick up items from the current room.
 * The player can only carry up to 3 items at a time.
 * Some special items, like keys, may have specific conditions for picking them up.
 * Some items are not possible to pick.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandPick implements ICommand {
    private Game game;

    /**
     * Constructs a CommandPick object with the specified game.
     */
    public CommandPick(Game game) {
        this.game = game;
    }

    /**
     * Executes the pick command, allowing the player to pick up items from the current room.
     */
    @Override
    public void execute(String[] parts) {
        if (parts.length > 1) {
            String itemName = parts[1];
            Room currentRoom = game.getCurrentRoom();
            String formattedItemName = itemName.toLowerCase().replace(" ", "");

            if (!game.hasBeatGoblinsArmy() && currentRoom.equals(game.getGoblinCave())) {
                System.out.println("You need to defeat the goblin army guarding the key. Initiate battle with the 'fight' command.");
                return;
            }

            if (game.getPlayerInventory().getItems().size() >= 3) {
                System.out.println("Your inventory is full. You cannot carry more items.");
                return;
            }

            String formattedKey = formattedItemName + "key";
            Item keyItem = currentRoom.getItem(formattedKey);
            if (keyItem != null) {
                game.getPlayerInventory().addItem(keyItem);
                System.out.println("You picked up " + keyItem.getName() + ".");
                currentRoom.removeItem(formattedKey);
                game.checkKeys();
            } else {
                Item item = currentRoom.getItem(formattedItemName);
                if (item != null) {
                    if (item.getName().equals("toaster")) {
                        System.out.println("Why would you need a toaster? If you're hungry, go get something to eat and start focusing on important things :-).");
                    } else {
                        game.getPlayerInventory().addItem(item);
                        System.out.println("You picked up " + item.getName() + ".");
                        currentRoom.removeItem(formattedItemName);
                        game.checkKeys();
                    }
                } else {
                    System.out.println("There is no such item in this room.");
                }
            }
        } else {
            System.out.println("Please specify an item to pick up.");
        }
    }
}
