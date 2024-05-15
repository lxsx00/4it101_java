/**
 * The Command enum contains all available commands in the game.
 * This enum is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public enum Command {
    GO, // Represents the command to move to another room.
    HELP, // Represents the command to display available commands and their usage.
    QUIT, // Represents the command to quit the game.
    FIGHT, // Represents the command to engage in combat with enemies.
    PICK, // Represents the command to pick up an item in the current room.
    REMOVE, // Represents the command to remove an item from the inventory.
    INVENTORY, // Represents the command to view the contents of the player's inventory.
    EXPLORE, // Represents the command to explore the current room for hidden items.
    RESTORE, // Represents the command to restore player's health or lives.
    LIVES, // Represents the command to view the player's remaining lives.
    GUIDELINE // Represents the command to display guidelines or hints for the game.
}
