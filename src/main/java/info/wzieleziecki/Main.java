package info.wzieleziecki;

import org.apache.log4j.Logger;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(Main.class);

        String startWord = "ruby";
        String endWord = "code";

        if (startWord.length() != endWord.length()) {
            logger.info("Words shoud contain the same number of letters");
            System.exit(1);
        }

        Word word = new Word();

        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);
        try {
            List<String> path = graph.findShortestPath(startWord, endWord);
            logger.info("Solution for: " + startWord + " to " + endWord + " - " +  path);
        } catch (NullPointerException n) {
            logger.info("No solution found. " + n);
        }

    }
}
