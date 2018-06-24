import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DictionaryReader {

    public List<String> getWordsFromFile(final int startWordLength) {
        List<String> words = new ArrayList<String>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/wordlist.txt"));
            String word;
            while ((word = reader.readLine()) != null) {
                if (word.length() == startWordLength) {
                    words.add(word);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();

        }
        return words;
    }
}
