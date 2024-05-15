/**
 * The CommandRestore class implements the restore command for the game.
 * The restore command allows the player to restore their lives by drinking from a magical spring.
 * in the room 'Forgotten Spring'. Restoring is always to maximum.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

class CommandRestore implements ICommand {
    private Game game;

    /**
     * Constructs a CommandRestore object with the specified game.
     */
    public CommandRestore(Game game) {
        this.game = game;
    }

    /**
     * Executes the restore command to restore the player's lives by drinking from a magical spring.
     */
    @Override
    public void execute(String[] args) {
        restoreLives();
    }

    /**
     * Restores the player's lives by drinking from a magical spring if the player is in the correct room.
     */
    private void restoreLives() {
        Room currentRoom = game.getCurrentRoom();
        Player player = game.getPlayer();

        if (currentRoom.getName().equals("Forgotten Spring")) {
            if (player.getCurrentLives() < 3) {
                player.increaseLife(); // Increase the player's lives to 3 if they are not already at the maximum value
                System.out.println("You drank from the magical spring and restored your lives.");
                System.out.println("Current lives: " + player.getCurrentLives() + " out of 3.");
            } else {
                System.out.println("Your lives are already at maximum.");
            }
        } else {
            System.out.println("You cannot restore lives here.");
        }
    }
}
