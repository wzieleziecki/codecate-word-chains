package info.wzieleziecki;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class WordTest {

    private final Word word= new Word();

    @Test
    public void findAllWordsWitFiveCharacters_AllWordShouldHaveFiveCharacters(){
        List<String> wordsWithDefinedLetterNumber = word.getWordsWithDefinedLetterNumber(5);
        for (String word : wordsWithDefinedLetterNumber) {
            int wordLength = word.length();
            Assert.assertEquals(5,wordLength);
        }
    }

    @Test
    public void findAllWordsWitNineCharacters_AllWordShouldHaveNineCharacters(){
        List<String> wordsWithDefinedLetterNumber = word.getWordsWithDefinedLetterNumber(9);
        for (String word : wordsWithDefinedLetterNumber) {
            int wordLength = word.length();
            Assert.assertEquals(9,wordLength);
        }
    }
}

