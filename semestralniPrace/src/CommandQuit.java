/**
 * The CommandQuit class implements the quit command for the game.
 * The quit command allows the player to exit the game any time followed by 'game over'.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

class CommandQuit implements ICommand {
    private Game game;

    /**
     * Constructs a CommandQuit object with the specified game.
     */
    public CommandQuit(Game game) {
        this.game = game;
    }

    /**
     * Executes the quit command, allowing the player to exit the game.
     */
    @Override
    public void execute(String[] args) {
        System.out.println("Quitting the game...");
        game.setGameOver(true);
    }
}
