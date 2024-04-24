import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Dictionary {
    protected List<WordItem> dictionary;
    private final String filename = "dictionary.csv";

    public Dictionary() {
        dictionary = new ArrayList<>();
        loadFromCSV();
    }

    public void insert(String word, String translation) {
        // Kontrola, zda slovo již existuje
        for (WordItem item : dictionary) {
            if (item.getWord().equals(word)) {
                System.out.println("Word '" + word + "' already exists in the dictionary.");
                return;
            }
        }

        // Pokud slovo neexistuje, vložíme ho do slovníku
        dictionary.add(new WordItem(word, translation));
        System.out.println("Word was successfully inserted.");
        saveToCSV();
    }

    public void loadFromCSV() {
        File file = new File(filename);
        if (!file.exists()) return;

        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    dictionary.add(new WordItem(parts[0].trim(), parts[1].trim()));
                } else {
                    System.out.println("Invalid format in CSV file: " + line);
                }
            }
            System.out.println("Dictionary loaded successfully from CSV file.");
        } catch (IOException e) {
            System.out.println("Error loading dictionary from CSV file: " + e.getMessage());
        }
    }

    private void saveToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            for (WordItem item : dictionary) {
                writer.println(item.getWord() + ";" + item.getTranslation());
            }
            System.out.println("Dictionary saved successfully to CSV file.");
        } catch (IOException e) {
            System.out.println("Error saving dictionary to CSV file: " + e.getMessage());
        }
    }

    public void test() {
        if (dictionary.isEmpty()) {
            System.out.println("Dictionary is empty. Please insert words first.");
            return;
        }

        int correct = 0;
        List<WordItem> testDictionary = new ArrayList<>(dictionary);
        Collections.shuffle(testDictionary); // Zamíchá slova

        // Testuj 3 náhodná slova
        for (int i = 0; i < Math.min(3, testDictionary.size()); i++) {
            WordItem item = testDictionary.get(i);
            System.out.print(item.getWord() + ": ");
            String answer = new java.util.Scanner(System.in).nextLine();
            if (answer.equalsIgnoreCase(item.getTranslation())) {
                System.out.println(" Correct!");
                correct++;
            } else {
                System.out.println(" Incorrect, the correct answer is: " + item.getTranslation());
            }
        }

        System.out.println("Your score is: " + correct + " out of 3");
    }
}
