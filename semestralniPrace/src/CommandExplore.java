/**
 * The CommandExplore class implements the explore command for the game.
 * When executed, this command allows the player to search the current room for hidden items
 * as all available items will be listed.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandExplore implements ICommand {
    private Game game;

    /**
     * Constructs a CommandExplore object with the specified game.
     */
    public CommandExplore(Game game) {
        this.game = game;
    }

    /**
     * Executes the explore command, displaying the items present in the current room.
     */
    @Override
    public void execute(String[] parts) {
        System.out.println(game.getCurrentRoom().getItemsDescription());
    }
}
