import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Dictionary {
    protected List<WordItem> dictionary;

    public Dictionary() {
        dictionary = new ArrayList<>();
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
