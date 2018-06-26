import java.util.List;

public class Main {

    public static void main(String[] args) {
        String startWord = "ruby";
        String endWord = "code";

        if (startWord.length() != endWord.length()) {
            System.err.println("Words shoud contain the same number of letters");
            System.exit(1);
        }

        Word word = new Word();

        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);
        try {
            List<String> path = graph.findShortestPath(startWord, endWord);
            System.out.println(path);
        } catch (NullPointerException n) {
            System.out.println("No solution found. " + n);
        }

    }
}
