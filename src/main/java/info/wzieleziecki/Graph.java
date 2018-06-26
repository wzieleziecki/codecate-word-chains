package info.wzieleziecki;

import java.util.*;

class Graph {

    private List<String> wordsWithDefinedLetterCount;

    Graph(List<String> wordsWithDefinedLetterCount) {
        this.wordsWithDefinedLetterCount = wordsWithDefinedLetterCount;
    }

    List<String> findShortestPath(String startWord, String endWord) {

        Map<String, String> previous = new HashMap<String, String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(startWord);

        String word;
        while (!queue.isEmpty() && !((word = queue.remove()).equals(endWord))) {
            List<String> listOfPossibleNextWords = getListOfPossibleNextWordsOf(word);
            for (String nextWord : listOfPossibleNextWords) {
                if (!previous.containsKey(nextWord)) {
                    previous.put(nextWord, word);
                    queue.add(nextWord);
                }
            }
        }
        return getPath(previous, startWord, endWord);
    }

    private List<String> getListOfPossibleNextWordsOf(String word) {
        List<String> listOfPossibleNextWords = new ArrayList<String>();
        for (String considerWord : wordsWithDefinedLetterCount) {
            if (countNumberOfDifferenceBetweenWords(word, considerWord) == 1) {
                listOfPossibleNextWords.add(considerWord);
            }
        }
        return listOfPossibleNextWords;

    }

    private int countNumberOfDifferenceBetweenWords(final String firstWord, String compareWord) {
        int numberOfDiffrence = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != compareWord.charAt(i)) {
                numberOfDiffrence++;
            }
        }
        return numberOfDiffrence;
    }

    private List<String> getPath(Map<String, String> previous, String startWord, String endWord) {
        List<String> path = new ArrayList<String>();
        String word = endWord;
        while (!word.equals(startWord)) {
            path.add(0, word);
            word = previous.get(word);
        }
        path.add(0, startWord);

        return path;
    }
}
