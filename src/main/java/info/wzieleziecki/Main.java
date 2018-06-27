package info.wzieleziecki;

import org.apache.log4j.Logger;

import java.util.List;

class Main {

    public static void main(String[] args) {

        final Logger logger = Logger.getLogger(Main.class);

        String startWord = "cat";
        String endWord = "dog";

        if (startWord.length() != endWord.length()) {
            logger.info("Words should contain the same number of letters");
            System.exit(1);
        }

        Word word = new Word();

        List<String> words = word.getWordsWithDefinedLetterNumber(startWord.length());
        Graph graph = new Graph(words);
        List<String> shortestPath = graph.findShortestPath(startWord, endWord);
        if (shortestPath != null) {
            logger.info(String.format("Solution for: %s to %s - %s", startWord, endWord, shortestPath));
        } else {
            logger.info(String.format("No solution found for: %s to %s ", startWord, endWord));
        }

    }
}
