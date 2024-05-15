/**
 * The CommandHelp class implements the help command for the game.
 * The help command displays a list of available commands and their descriptions to assist the player.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandHelp implements ICommand {
    private Game game;

    /**
     * Constructs a CommandHelp object with the specified game.
     */
    public CommandHelp(Game game) {
        this.game = game;
    }

    /**
     * Executes the help command, displaying a list of available commands and their descriptions.
     */
    @Override
    public void execute(String[] args) {
        displayHelp();
    }

    /**
     * Displays a list of available commands and their descriptions to the player.
     */
    private void displayHelp() {
        System.out.println("Available commands:");
        System.out.println("- go [direction]: Move to the specified direction with specified exit.");
        System.out.println("- help: Display available commands.");
        System.out.println("- quit: Quit the game.");
        System.out.println("- pick [item]: Pick up the specified item in the current room.");
        System.out.println("- remove [item]: Remove the item from your inventory. Be careful, it is an irreversible process!");
        System.out.println("- inventory: Display the items in your inventory. You can only have 3 items");
        System.out.println("- explore: Discover magical items in the current room.");
        System.out.println("- lives: Display the current number of lives.");
        System.out.println("- fight: Attempt to defeat the goblin army.");
        System.out.println("- restore: Use the magical spring to restore your lives.");
        System.out.println("- guideline: Displays the description of the entire game and basic gameplay principles.");
    }
}
