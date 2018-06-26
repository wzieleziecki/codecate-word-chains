import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//tests defined based on the challenge description - http://codekata.com/kata/kata19-word-chains/
public class WordChainTest {

    private Word word = new Word();

    @Test
    public void solutionForRubyToCode() {
        String startWord = "ruby";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> firstTestCase = Arrays.asList("ruby", "rubs", "robs", "robe", "rode", "code");
        List<String> path = graph.findShortestPath("ruby", "code");
        Assert.assertEquals(path, firstTestCase);
    }

    @Test
    public void solutionFromLeadToGold() {
        String startWord = "lead";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> secondTestCase = Arrays.asList("lead", "load", "goad", "gold");
        List<String> path = graph.findShortestPath("lead", "gold");
        Assert.assertEquals(path, secondTestCase);
    }

    @Test
    public void solutionFromCatToDog() {
        String startWord = "cat";
        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);

        List<String> thirdTestCase = Arrays.asList("cat", "cot", "cog", "dog");
        List<String> path = graph.findShortestPath("cat", "dog");
        Assert.assertEquals(path, thirdTestCase);
    }

}
