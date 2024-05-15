import java.util.Scanner;

/**
 *  The Game class implements the main game methods and manages the game state.
 *  It handles player actions, processes commands, and interacts with different parts of the game world.
 *  Responsibilities:
 *  - Initialize game state and objects.
 *  - Process player commands and execute corresponding actions.
 *  - Manage game progression and state changes.
 *  - Handle interactions between game elements (rooms, items, player).
 *  - Control the game flow and loop until the game is finished.
 *
 *  This class is the heart of a simple text-based game.
 *
 *  @author Lucie Suchomelová
 *  @version for the academic year 2023/2024
 */

public class Game {
    private Scanner scanner; // Scanner for user input
    private Inventory playerInventory; // Player's inventory
    public Player player; // The player object representing the user

    private boolean gameOver; // Flag indicating if the game is over
    private boolean roomChanged; // Flag indicating if the current room has changed
    private boolean hasWon; // Flag indicating if the player has won the game
    public boolean hasBeatGoblinsArmy; // Flag indicating if the player has defeated the goblin army

    public Room currentRoom;
    private Room finish;
    private Room fallingBridge;
    private Room goblinCave;// Reference to the Falling Bridge room

    // Commands available in the game
    private ICommand goCommand;
    private ICommand helpCommand;
    private ICommand fightCommand;
    private ICommand pickCommand;
    private ICommand removeCommand;
    private ICommand inventoryCommand;
    private ICommand livesCommand;
    private ICommand quitCommand;
    private ICommand restoreCommand;
    private ICommand exploreCommand;
    private ICommand guidelineCommand;

    /**
     * Initializes the game by creating necessary objects and setting up the initial game state.
     */
    public Game() {
        scanner = new Scanner(System.in);
        roomChanged = true;
        playerInventory = new Inventory(3); // Initialize player's inventory with maximum capacity of 3 items
        player = new Player(3); // Initialize player with 3 lives
        hasBeatGoblinsArmy = false; // Initialize goblin army status to undefeated
        createRooms(); // Initialize rooms

        // Initialize commands
        exploreCommand = new CommandExplore(this);
        goCommand = new CommandGo(this);
        helpCommand = new CommandHelp(this);
        fightCommand = new CommandFight(this);
        pickCommand = new CommandPick(this);
        removeCommand = new CommandRemove(this);
        inventoryCommand = new CommandInventory(this);
        livesCommand = new CommandLives(this);
        quitCommand = new CommandQuit(this);
        restoreCommand = new CommandRestore(this);
        guidelineCommand = new CommandGuideline(this);
    }

    /**
     * Initializes the game world by creating rooms, setting exits between rooms,
     * and adding items to specific rooms.
     * Sets the starting room and the finish room.
     * This method sets up the initial state of the game world.
     */
    public void createRooms() {
        // Creating rooms
        Room centerOfLabyrinth = new Room("Center of Labyrinth", "Starting point of the adventure.");
        Room burntAltar = new Room("Burnt Altar", "Where useful combat items may be hidden.");
        fallingBridge = new Room("Falling Bridge", "Stepping onto it automatically costs a life.");
        Room greenGrove = new Room("Green Grove", "Dense forest with the possibility of hiding keys.");
        goblinCave = new Room("Goblin Cave", "Dark cave full of goblins and danger. To obtain the reward, you must defeat the goblin army.");
        Room forgottenSpring = new Room("Forgotten Spring", "With magical water to restore lives.");
        Room mysteriousArbour = new Room("Mysterious Arbour", "Shrouded in mystery and magic.");
        Room ancientChamber = new Room("Ancient Chamber", "Filled with artifacts and puzzles.");
        Room labyrinthGate = new Room("Labyrinth Gate", "Massive gate with three locks.");

        // Setting exits for each room
        centerOfLabyrinth.setExit("left", burntAltar);
        centerOfLabyrinth.setExit("straight", fallingBridge);
        centerOfLabyrinth.setExit("right", greenGrove);

        burntAltar.setExit("back", centerOfLabyrinth);
        fallingBridge.setExit("back", centerOfLabyrinth);
        greenGrove.setExit("back", centerOfLabyrinth);
        greenGrove.setExit("straight", goblinCave);

        goblinCave.setExit("back", greenGrove);
        goblinCave.setExit("right", forgottenSpring);

        forgottenSpring.setExit("straight", mysteriousArbour);
        forgottenSpring.setExit("back", goblinCave);

        mysteriousArbour.setExit("left", ancientChamber);
        mysteriousArbour.setExit("right", labyrinthGate);
        mysteriousArbour.setExit("back", forgottenSpring);

        ancientChamber.setExit("back", mysteriousArbour);

        labyrinthGate.setExit("back", mysteriousArbour);

        // Setting the current room
        currentRoom = centerOfLabyrinth;
        finish = labyrinthGate; // Setting the finish room

        // Adding items to rooms
        burntAltar.addItem("sword", new Item("sword"));
        burntAltar.addItem("toaster", new Item("toaster"));
        goblinCave.addItem("greenkey", new Item("green key"));
        ancientChamber.addItem("redkey", new Item("red key"));
        greenGrove.addItem("bluekey", new Item("blue key"));
    }


    /**
     * Checks if the player has collected all three keys (green, red, and blue) and
     * is in the finish room (Labyrinth Gate). If the player meets these conditions, sets
     * the hasWon flag to true and calls the openLabyrinthGate() method.
     * If the player is in the finish room but does not have all keys,
     * prints a message indicating the requirement.
     */
    public void checkKeys() {
        boolean hasGreenKey = false;
        boolean hasRedKey = false;
        boolean hasBlueKey = false;

        // Iterate through the player's inventory to check for keys
        for (Item item : playerInventory.getItems()) {
            if (item.getName().equals("green key")) {
                hasGreenKey = true;
            } else if (item.getName().equals("red key")) {
                hasRedKey = true;
            } else if (item.getName().equals("blue key")) {
                hasBlueKey = true;
            }
        }

        // Check if the player has all keys and is in the finish room
        if (hasGreenKey && hasRedKey && hasBlueKey && currentRoom.equals(finish)) {
            hasWon = true; // Set hasWon to true if the player has all keys and is in the finish room (Labyrinth Gate)
            openLabyrinthGate();
        } else if (currentRoom.equals(finish)) {
            // If the player is in the finish room but doesn't have all keys, inform the player
            System.out.println("To open the Labyrinth Gate, you need to find all three keys: green, red, and blue.");
            roomChanged = false;
        }
    }


    /**
     * Checks if the player has all keys required to open the Labyrinth Gate.
     * If the player has all keys, prints a congratulatory message and sets the hasWon flag to true.
     * If the player doesn't have all keys, prints a message indicating the requirement.
     */
    public void openLabyrinthGate() {
        checkKeys(); // Check if the player has all keys
        if (hasWon) {
            // If the player has all keys, print a congratulatory message
            System.out.println("Congratulations! You have opened the Labyrinth Gate and escaped safely.");
        } else {
            // If the player doesn't have all keys, print a message indicating the requirement
            System.out.println("To open the Labyrinth Gate, you need to find all three keys: Green, Red, and Blue.");
            // The game continues if the player doesn't have all keys
        }
    }

    /**
     * Returns a boolean indicating whether the player has defeated the goblin army.
     */
    public boolean hasBeatGoblinsArmy() {
        return hasBeatGoblinsArmy;
    }


    /**
     * Sets the flag indicating whether the player has defeated the goblin army.
     */
    public void setHasBeatGoblinsArmy(boolean value) {
        this.hasBeatGoblinsArmy = value;
    }

    /**
     * Sets the flag indicating whether the player has won the game.
     */
    public void setHasWon(boolean hasWon) {
        this.hasWon = hasWon;
    }

    /**
     * Returns the current room where the player is located.
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }

    /**
     * Sets the current room where the player is located.
     */
    public void setCurrentRoom(Room currentRoom) {
        this.currentRoom = currentRoom;
    }

    /**
     * Returns the finish room, which is the destination to win the game.
     */
    public Room getFinish() {
        return finish;
    }

    /**
     * Returns the falling bridge room, which is a specific location in the game.
     */
    public Room getFallingBridge() {
        return fallingBridge;
    }

    /**
     * Returns the player object representing the user.
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Returns the player's inventory.
     */
    public Inventory getPlayerInventory() {
        return playerInventory;
    }

    /**
     * Returns the scanner object used for user input.
     */
    public Scanner getScanner() {
        return scanner;
    }

    /**
     * Sets a flag indicating whether the current room has changed.
     */
    public void setRoomChanged(boolean roomChanged) {
        this.roomChanged = roomChanged;
    }

    /**
     * Sets a flag indicating whether the game is over.
     */
    public void setGameOver(boolean gameOver) {
        this.gameOver = gameOver;
    }

    /**
     * Returns the goblin cave room.
     */
    public Room getGoblinCave() {
        return goblinCave;
    }


    /**
     * Starts the game loop.
     * Displays a welcome message and initializes the game rooms.
     * Sets the current room to the starting room.
     * Enters a loop where it displays the description of the current room,
     * prompts the player for a command, and processes the command until the game is finished.
     */
    public void play() {
        System.out.println("Welcome to the Labyrinth!");
        createRooms(); // Initialize rooms

        // Set the current room to the starting room
        currentRoom = getCurrentRoom();

        // Enter a loop until the game is finished
        while (!isGameFinished()) {
            // Display the description of the current room
            currentRoom.displayCurrentRoomDescription();

            // Prompt the player for a command
            System.out.println("Your command: ");
            String command = scanner.nextLine();

            // Process the player's command
            processCommand(command);
        }
    }


    /**
     * Processes the command entered by the player.
     * Splits the command into parts and determines the action to be taken based on the first part.
     * Executes the corresponding command by invoking its execute method.
     * If the command is not recognized, it displays a message indicating that the command is unknown.
     */
    public void processCommand(String command) {
        // Split the command into parts
        String[] parts = command.split(" ");
        if (parts.length > 0) {
            // Extract the command from the first part and convert it to uppercase
            Command cmd;
            try {
                cmd = Command.valueOf(parts[0].toUpperCase());
            } catch (IllegalArgumentException e) {
                // If the command is not recognized, display a message and return
                System.out.println("Unknown command. Type 'help' for available commands.");
                return;
            }
            // Execute the corresponding command based on the extracted command
            switch (cmd) {
                case GO:
                    goCommand.execute(parts);
                    break;
                case HELP:
                    helpCommand.execute(parts);
                    break;
                case EXPLORE:
                    exploreCommand.execute(parts);
                    break;
                case FIGHT:
                    fightCommand.execute(parts);
                    break;
                case PICK:
                    pickCommand.execute(parts);
                    break;
                case REMOVE:
                    removeCommand.execute(parts);
                    break;
                case INVENTORY:
                    inventoryCommand.execute(parts);
                    break;
                case LIVES:
                    livesCommand.execute(parts);
                    break;
                case QUIT:
                    quitCommand.execute(parts);
                    break;
                case RESTORE:
                    restoreCommand.execute(parts);
                    break;
                case GUIDELINE:
                    guidelineCommand.execute(parts);
                    break;
                default:
                    // If the command is not recognized, display a message indicating that the command is unknown
                    System.out.println("Unknown command. Type 'help' for available commands.");
            }
        }
    }


    /**
     * Checks if the game is over.
     * The game is considered over if both the gameOver flag is true and the player has not won.
     * @return True if the game is over, otherwise false.
     */
    public boolean isGameOver() {
        return gameOver && !hasWon;
    }

    /**
     * Checks if the game is finished.
     * The game is considered finished if either the player has won or the gameOver flag is true.
     * @return True if the game is finished, otherwise false.
     */
    public boolean isGameFinished() {
        return hasWon || gameOver;
    }


}
