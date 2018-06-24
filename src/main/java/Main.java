import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static List<String> getWordsFromFile(int startWordLength){
        List<String> words = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/wordlist.txt"));
            String word = "";
            while((word = reader.readLine()) != null ){
                if (word.length() == startWordLength) {
                    words.add(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return words;
    }


    public static void main(String[] args) {
        String startWord = "cat";
        String endWord = "dog";
        List<String> words = getWordsFromFile(startWord.length());

     //   System.out.println(words.get(1));

       Graph graph  = new Graph(words) ;
       List<String> path = graph.findPath(startWord, endWord);

        System.out.println(path);

    }
}
