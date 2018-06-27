package info.wzieleziecki.codecatawordchains;

import java.util.ArrayList;
import java.util.List;

class Word {

    private final Dictionary dictionary = new Dictionary();

    private final List<String> allWordsFromDictionary = dictionary.loadWordsFromFile("src/main/resources/wordlist.txt");

    List<String> getWordsWithDefinedLetterNumber(int wordLength) {
        List<String> wordsWithDefinedLetterNumber = new ArrayList<>();
        for (String word : allWordsFromDictionary) {
            if (word.length() == wordLength) {
                wordsWithDefinedLetterNumber.add(word);
            }
        }
        return wordsWithDefinedLetterNumber;
    }
}
