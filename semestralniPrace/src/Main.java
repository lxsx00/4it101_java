import java.util.Scanner;

/**
 *  The Main class implements the starting point for the game.
 *  This class is the entry point for starting the game.
 *  It sets up the Game instance, creates a Scanner object for user input, and initiates the game loop.
 *  During each iteration of the loop, it displays the current room description and prompts the user for a command.
 *  It then processes the command using the Game object's processCommand method.
 *
 *  This class is part of a simple text-based game.
 *
 * @author Lucie Suchomelová
 * @version for the academic year 2023/2024
 */

public class Main {
    public static void main(String[] args) {
        Game game = new Game(); // Creates a new instance of the Game class
        Scanner scanner = new Scanner(System.in); // Creates a Scanner object for user input

        System.out.println("Welcome to the Labyrinth!");

        // Game loop
        while (!game.isGameFinished()) {
            Room currentRoom = game.getCurrentRoom();
            System.out.println(currentRoom.getDescriptionWithExitsAndItems()); // Displays the current room description
            System.out.println("Available commands: go | help | quit");

            String command = scanner.nextLine(); // Reads user input
            game.processCommand(command); // Processes the user command

            // Checks if the game is over
            if (game.isGameOver()) {
                System.out.println("Game over!");
                break; // Exits the loop if the game is over
            }
        }

        System.out.println("Thanks for playing!");
    }
}
