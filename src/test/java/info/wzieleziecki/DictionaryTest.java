package info.wzieleziecki;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class DictionaryTest {

    private final Dictionary dictionary = new Dictionary();

    @Test
    public void emptyFile_ShouldNotContainsAnyWords() {
        List<String> dictionaryWords = dictionary.loadWordsFromFile("src/test/resources/wordlist_empty.txt");
        int size = dictionaryWords.size();
        Assert.assertEquals(0, size);

    }

    @Test
    public void fileWithWhiteCharacters_ShouldNotContainsAnyWords() {
        List<String> dictionaryWords = dictionary.loadWordsFromFile("src/test/resources/wordlist_white_characters.txt");
        int size = dictionaryWords.size();
        Assert.assertEquals(0, size);

    }

}
