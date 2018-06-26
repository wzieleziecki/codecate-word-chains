import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Dictionary {

    public List<String> loadWordsFromFile() {
        List<String> allLoadedWords = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/wordlist.txt"));
            String word;
            while ((word = reader.readLine()) != null) {
                allLoadedWords.add(word);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return allLoadedWords;
    }

}
