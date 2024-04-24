public class Main {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        Dictionary dictionary = new Dictionary();

        System.out.println("Welcome to the Vocabulary Quiz App!");

        while (true) {
            System.out.println("Choose a command: [insert | test | exit]");
            String command = scanner.nextLine();

            switch (command.toLowerCase()) {
                case "insert":
                    System.out.println("Enter a word and its translation separated by space:");
                    String[] words = scanner.nextLine().split(" ");
                    if (words.length == 2) {
                        dictionary.insert(words[0], words[1]);
                    } else {
                        System.out.println("Invalid format, enter a word and its translation separated by space.");
                    }
                    break;
                case "test":
                    dictionary.test();
                    break;
                case "exit":
                    System.out.println("Thank you for using the app.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid command.");
            }
        }
    }
}
