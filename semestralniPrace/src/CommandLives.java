/**
 * The CommandLives class implements the lives command for the game.
 * The lives command displays the current number of lives the player has.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandLives implements ICommand {
    private Game game;
    private Player player;

    /**
     * Constructs a CommandLives object with the specified game.
     */
    public CommandLives(Game game) {
        this.game = game;
        this.player = game.getPlayer();
    }

    /**
     * Executes the lives command, displaying the current number of lives the player has.
     */
    @Override
    public void execute(String[] args) {
        displayLives();
    }

    /**
     * Displays the current number of lives the player has out of maximum.
     */
    private void displayLives() {
        int currentLives = player.getCurrentLives();
        int maxLives = player.getMaxLives();
        System.out.println("Current lives: " + currentLives + " out of " + maxLives + ".");
    }
}
