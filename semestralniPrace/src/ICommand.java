/**
 * The ICommand interface represents commands in a simple text-based game.
 *
 * This interface is part of a simple text-based game.
 *
 * @author Lucie Suchomelová
 * @version for the academic year 2023/2024
 */

public interface ICommand {
    /**
     * Executes the command with the specified arguments.
     */
    void execute(String[] parts);
}
