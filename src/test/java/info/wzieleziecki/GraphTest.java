package info.wzieleziecki;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//tests defined based on the challenge description - http://codekata.com/kata/kata19-word-chains/
public class GraphTest {

    private final Word word = new Word();


    @Test
    public void findPathForRubyToCode() {
        String startWord = "ruby";
        String endWord = "code";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> firstTestCase = Arrays.asList("ruby", "rubs", "robs", "robe", "rode", "code");
        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, firstTestCase);
    }

    @Test
    public void findPathFromLeadToGold() {
        String startWord = "lead";
        String endWord = "gold";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> secondTestCase = Arrays.asList("lead", "load", "goad", "gold");
        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, secondTestCase);
    }

    @Test
    public void findPathFromCatToDog() {
        String startWord = "cat";
        String endWord = "dog";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> thirdTestCase = Arrays.asList("cat", "cot", "cog", "dog");
        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, thirdTestCase);
    }

    @Test
    public void pathDoesNotExist_ShouldReturnEmptyList_WhenTheStartWordAndEndWordDoesNotExist() {
        String startWord = "cact";
        String endWord = "docg";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, Collections.emptyList());
    }

    @Test
    public void pathDoesNotExist_ShouldReturnEmptyList_WhenTheStartWordAndEndWordAreEmpty() {
        String startWord = "";
        String endWord = "";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, Collections.emptyList());
    }
    @Test
    public void startWordIsGreaterThenEndWord_ShouldReturnEmptyList() {
        String startWord = "aaa";
        String endWord = "a";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, Collections.emptyList());
    }

    @Test
    public void endWordIsGreaterThenStartWord_ShouldReturnEmptyList() {
        String startWord = "b";
        String endWord = "bbbb";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertEquals(path, Collections.emptyList());
    }

    @Test
    public void pathForRubyToCodeReturnEmptyList_ShouldNotBeTrue() {
        String startWord = "ruby";
        String endWord = "code";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> path = graph.findShortestPath(startWord, endWord);
        Assert.assertNotEquals(path, Collections.emptyList());
    }
}
