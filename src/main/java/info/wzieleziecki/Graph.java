package info.wzieleziecki;

import java.util.*;

class Graph {

    private final List<String> wordsWithDefinedLetterCount;

    Graph(List<String> wordsWithDefinedLetterCount) {
        this.wordsWithDefinedLetterCount = wordsWithDefinedLetterCount;
    }

    List<String> findShortestPath(final String startWord, final String endWord) {

        Map<String, String> previous = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.add(startWord);

        String word;
        while (!queue.isEmpty() && !((word = queue.remove()).equals(endWord))) {
            List<String> possibleWordsList = getPossibleWordsList(word);
            for (String nextWord : possibleWordsList) {
                if (!previous.containsKey(nextWord)) {
                    previous.put(nextWord, word);
                    queue.add(nextWord);
                }
            }
        }
        return getPath(previous, startWord, endWord);
    }

    private List<String> getPossibleWordsList(String word) {
        List<String> listOfPossibleNextWords = new ArrayList<>();
        for (String considerWord : wordsWithDefinedLetterCount) {
            if (isOneDifferenceBetweenWords(word, considerWord)) {
                listOfPossibleNextWords.add(considerWord);
            }
        }
        return listOfPossibleNextWords;

    }

    private boolean isOneDifferenceBetweenWords(final String firstWord, String compareWord) {
        int numberOfDifference = 0;
        for (int i = 0; i < firstWord.length(); i++) {
            if (firstWord.charAt(i) != compareWord.charAt(i)) {
                numberOfDifference++;
            }
            if (numberOfDifference > 1) {
                return false;
            }
        }
        return true;
    }

    private List<String> getPath(Map<String, String> previous, String startWord, String endWord) {
        if (!previous.containsKey(endWord)) {
            return Collections.emptyList();
        }

        List<String> path = new ArrayList<>();
        String word = endWord;
        while (!word.equals(startWord)) {
            path.add(0, word);
            word = previous.get(word);
        }
        path.add(0, startWord);

        return path;
    }
}
