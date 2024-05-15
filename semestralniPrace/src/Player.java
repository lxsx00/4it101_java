/**
 * The Player class represents a character within the game, focusing on managing their lives.
 * This class enables tracking and manipulation of the player's lives, allowing for decreasing
 * and increasing the number of lives as well as retrieving information about the player's
 * current and maximum lives.
 *
 * This class is part of a simple text-based game.
 *
 * @author     Lucie Suchomelová
 * @version    for the academic year 2023/2024
 */

public class Player {
    private int currentLives; // Represents the current number of lives the player has.
    private final int maxLives; // Represents the maximum number of lives the player can have.

    /**
     * Constructor to initialize a Player object with a specified maximum number of lives.
     *
     * (specified in class Game).
     */
    public Player(int maxLives) {
        this.maxLives = maxLives; // Set the maximum number of lives.
        this.currentLives = maxLives; // Set the current number of lives to the maximum initially.
    }

    /**
     * Decreases the current number of lives by one if the player has at least one life remaining.
     */
    public void decreaseLife() {
        if (currentLives > 0) {
            currentLives--; // Decrease the current number of lives by one.
        }
    }

    /**
     * Increases the current number of lives to the maximum if it is less than the maximum.
     */
    public void increaseLife() {
        if (currentLives < maxLives) {
            currentLives = maxLives; // Set the current number of lives to the maximum.
        }
    }

    /**
     * Retrieves the current number of lives the player has.
     *
     * @return The current number of lives.
     */
    public int getCurrentLives() {
        return currentLives; // Return the current number of lives.
    }

    /**
     * Retrieves the maximum number of lives the player can have.
     *
     * @return The maximum number of lives.
     */
    public int getMaxLives() {
        return maxLives; // Return the maximum number of lives.
    }
}
