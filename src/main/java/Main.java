import java.util.List;

public class Main {

    public static void main(String[] args) {
        String startWord = "ruby";
        String endWord = "code";

        if (startWord.length() != endWord.length()) {
            System.err.println("Words must be of the same length");
            System.exit(1);
        }

        DictionaryReader dictionaryReader = new DictionaryReader();
        List<String> words = dictionaryReader.getWordsFromFile(startWord.length());

        Graph graph = new Graph(words);
        try {
            List<String> path = graph.findPath(startWord, endWord);
            System.out.println(path);
        } catch (NullPointerException n) {
            System.out.println("No solution found. " + n);
        }

    }
}
