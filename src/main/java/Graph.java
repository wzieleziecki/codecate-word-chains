import java.util.*;

public class Graph {

    private List<String> wordList;

    public Graph(List<String> wordList) {
        this.wordList = wordList;
    }

    public List<String> findPath(String startWord, String endWord){
        Map<String, String> previous = new HashMap<String, String>();
        Queue<String> queue = new LinkedList<String>();
        queue.add(startWord);

        String word = null;
        while ( !queue.isEmpty() && !((word = queue.remove()).equals(endWord))) {
            List<String> nextWords = getNextWords(word);
            for (String nextWord : nextWords){
                if (!previous.containsKey(nextWord)){
                    previous.put(nextWord,word);
                    queue.add(nextWord);
                }
            }
        }
        return getPath(previous, startWord, endWord);
    }

    public List<String> getNextWords(String word){
        List<String> nextWords = new ArrayList<String>();
        for(String currentWord : wordList){
            if(getWordDiffrenceNumber(word, currentWord)==1){
                nextWords.add(currentWord);
            }
        }
        return nextWords;
    }

    public int getWordDiffrenceNumber (final String firstWord, String compareWord){
        int numberOfDiffrence = 0;
        for(int i = 0; i< firstWord.length(); i++){
            if (firstWord.charAt(i) != compareWord.charAt(i)){
                numberOfDiffrence++;
            }
        }
        return numberOfDiffrence;
    }

    public List<String> getPath(Map<String, String> previous, String startWord, String endWord){
            List<String> path = new ArrayList<String>();
            String word = endWord;
            while (!word.equals(startWord)){
                path.add(0,word);
                word = previous.get(word);
            }
            path.add(0, startWord);

        return path;
    }
}
