/**
 * The CommandFight class implements the fight command for the game.
 * The fight command allows the player to engage in combat with enemies in certain rooms.
 * If the player successfully defeats the enemy, they may pick items such as keys.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandFight implements ICommand {
    private Game game;

    /**
     * Constructs a CommandFight object with the specified game.
     */
    public CommandFight(Game game) {
        this.game = game;
    }

    /**
     * Executes the fight command, allowing the player to engage in combat with enemies.
     * This method checks if the player has a sword to fight goblins in the goblin cave.
     * If successful, the player can pick item such as keys.
     * If the player does not have a sword, they lose a life.
     */
    @Override
    public void execute(String[] args) {
        fight();
    }

    /**
     * Initiates a fight sequence based on the player's current location.
     * The player can fight goblins in the goblin cave if they possess a sword.
     * If successful, the player can pick item such as keys.
     */
    private void fight() {
        if (game.getCurrentRoom().equals(game.getGoblinCave())) {
            if (game.hasBeatGoblinsArmy()) {
                // If the player has already defeated the goblin army, no need to fight again
                System.out.println("You've already defeated the goblin army. There's no need to fight again.");
            } else {
                if (game.getPlayerInventory().hasItem("sword")) {
                    System.out.println("You successfully defeated the goblins!");
                    // Set the flag to true after defeating the goblin army
                    game.setHasBeatGoblinsArmy(true);
                    // If successful in battle, allow the player to pick up the green key
                    System.out.println("You can now pick up the green key.");
                } else {
                    // Decrease player's life if they don't have a sword
                    game.getPlayer().decreaseLife();
                    System.out.println("You need a sword to fight the goblins.");
                    System.out.println("You lost 1 life in the battle.");
                    if (game.getPlayer().getCurrentLives() == 0) {
                        // Player has lost all lives, game over
                        System.out.println("You lost all your lives.");
                        game.setGameOver(true);
                    }
                }
            }
        } else {
            System.out.println("There is nothing to fight here.");
        }
    }
}
