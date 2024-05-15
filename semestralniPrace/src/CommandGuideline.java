/**
 * The CommandGuideline class implements the guideline command for the game.
 * The guideline command provides players with a brief overview of the game's objectives,
 * rules, and available commands.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandGuideline implements ICommand {
    // Text containing the game guidelines
    private static final String GUIDELINE_TEXT = "Welcome to the Labyrinth game!\n" +
            "The goal of the game is to find three keys (each of them with a different color: green, red, and blue)\n" +
            "and open the Labyrinth Gate.\n" +
            "These keys are hidden in various rooms of the labyrinth.\n\n" +

            "Use all available commands from 'help', some can only be used in specific rooms.\n" +
            "Try to explore each room to find all 3 keys. You also have 3 lives, losing them results in 'Game Over'.\n" +
            "You can regain lives in one room, so be vigilant.\n\n" +

            "You can collect any items in a room, but remember, you can only carry 3 items at a time.\n" +
            "If you want to discard an item, you can do so, but it will disappear from the game forever, so think carefully.\n\n" +

            "You can end the game at any time using the 'quit' command.\n\n" +

            "You should be able to play the game with a standard keyboard.\n" +
            "Also, avoid using capital letters, special characters, or digits.\n\n" +

            "I wish you enjoy the game, and most importantly... escape from the garden labyrinth.\n" +

            "LXSX\n";

    private final Game game;

    /**
     * Constructs a CommandGuideline object with the specified game.
     */
    public CommandGuideline(Game game) {
        this.game = game;
    }

    /**
     * Executes the guideline command, displaying the game guidelines to the player.
     */
    @Override
    public void execute(String[] args) {
        displayGuideline();
    }

    /**
     * Displays the game guidelines to the player.
     */
    private void displayGuideline() {
        System.out.println(GUIDELINE_TEXT);
    }
}
