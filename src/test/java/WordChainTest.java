import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

//tests defined based on the challenge description - http://codekata.com/kata/kata19-word-chains/
public class WordChainTest {

    private DictionaryReader dictionaryReader = new DictionaryReader();

    @Test
    public void test1PositiveSolution() {
        String startWord = "ruby";
        List<String> words = dictionaryReader.getWordsFromFile(startWord.length());
        Graph graph = new Graph(words);

        List<String> firstTestCase = Arrays.asList("ruby", "rubs", "robs", "robe", "rode", "code");
        List<String> path = graph.findPath("ruby", "code");
        Assert.assertEquals(path, firstTestCase);
    }

    @Test
    public void test2PositiveSolution() {
        String startWord = "lead";
        List<String> words = dictionaryReader.getWordsFromFile(startWord.length());
        Graph graph = new Graph(words);

        List<String> secondTestCase = Arrays.asList("lead", "load", "goad", "gold");
        List<String> path = graph.findPath("lead", "gold");
        Assert.assertEquals(path, secondTestCase);
    }

    @Test
    public void test3PositiveSolution() {
        String startWord = "cat";
        List<String> words = dictionaryReader.getWordsFromFile(startWord.length());
        Graph graph = new Graph(words);

        List<String> thirdTestCase = Arrays.asList("cat", "cot", "cog", "dog");
        List<String> path = graph.findPath("cat", "dog");
        Assert.assertEquals(path, thirdTestCase);
    }

}
