import java.util.ArrayList;
import java.util.List;

public class Word {

    private Dictionary dictionary = new Dictionary();

    private List<String> allWordsFromDictionary = dictionary.loadWordsFromFile();

    public List<String> getWordsWithDefinedLetterNumber(int wordLength) {
        List<String> wordsWithDefinedLetterNumber = new ArrayList<String>();
        for (String word : allWordsFromDictionary) {
            if (word.length() == wordLength) {
                wordsWithDefinedLetterNumber.add(word);
            }
        }
        return wordsWithDefinedLetterNumber;
    }
}
