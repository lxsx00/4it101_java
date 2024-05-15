/**
 * The CommandGo class implements the go command for the game.
 * The go command allows the player to move between rooms in different directions.
 * If the player reaches the Labyrinth Gate, they have the option to open it if they have collected all three keys.
 * If the player steps onto the Falling Bridge, they lose a life.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class CommandGo implements ICommand {
    private Game game;

    /**
     * Constructs a CommandGo object with the specified game.
     */
    public CommandGo(Game game) {
        this.game = game;
    }

    /**
     * Executes the go command, allowing the player to move between rooms.
     * If the player reaches the Labyrinth Gate or the Falling Bridge, special events occur.
     * If the player attempts to go in an invalid direction, a message is displayed.
     */
    @Override
    public void execute(String[] parts) {
        if (parts.length > 1) {
            go(parts[1]);
        } else {
            System.out.println("Please specify a direction.");
        }
    }

    /**
     * Moves the player to the next room based on the specified direction.
     * Handles special events such as reaching the Labyrinth Gate or the Falling Bridge.
     * @param direction The direction in which the player wants to move.
     */
    private void go(String direction) {
        Room nextRoom = game.getCurrentRoom().getExit(direction);
        if (nextRoom != null) {
            if (nextRoom.equals(game.getFinish())) {
                System.out.println("You have reached the Labyrinth Gate. Do you want to open the gate?");
                System.out.println("Type 'yes' to open the gate or 'no' to reconsider your choice.");
                String response = game.getScanner().nextLine().toLowerCase();
                if (response.equals("yes")) {
                    if (game.getPlayerInventory().hasItem("green key") && game.getPlayerInventory().hasItem("red key") && game.getPlayerInventory().hasItem("blue key")) {
                        game.setHasWon(true);
                        game.openLabyrinthGate();
                    } else {
                        System.out.println("To open the Labyrinth Gate, you need to find all three keys: Green, Red, and Blue.");
                    }
                } else if (response.equals("no")) {
                    System.out.println("You decide to stay cautious and explore other options.");
                } else {
                    System.out.println("Invalid response. Please type 'yes' or 'no'.");
                }
                return;
            } else {
                if (nextRoom.equals(game.getFallingBridge())) {
                    game.getPlayer().decreaseLife();
                    System.out.println("You stepped onto the Falling Bridge and lost a life.");
                    System.out.println("Remaining lives: " + game.getPlayer().getCurrentLives() + " out of 3.");
                    if (game.getPlayer().getCurrentLives() == 0) {
                        System.out.println("You lost all your lives. Game over!");
                        game.setGameOver(true);
                        return;
                    }
                    return;
                }
                System.out.println("Moving to the room: " + nextRoom.getName());
                game.setCurrentRoom(nextRoom);
                game.setRoomChanged(true);
            }
        } else {
            System.out.println("Cannot go in that direction.");
        }
    }
}
