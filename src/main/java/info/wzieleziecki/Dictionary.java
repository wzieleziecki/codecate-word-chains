package info.wzieleziecki;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Dictionary {

    private final Logger logger = Logger.getLogger(Main.class);

    List<String> loadWordsFromFile() {
        List<String> allLoadedWords = new ArrayList<String>();
        BufferedReader reader = null;

        try {
            String fileName = "src/main/resources/wordlist.txt";
            reader = new BufferedReader(new FileReader(fileName));

            String word;

            while ((word = reader.readLine()) != null) {
                allLoadedWords.add(word);
            }

        } catch (IOException e) {
            logger.trace(e);
        } finally {
            try {
                if (reader != null)
                    reader.close();
            } catch (IOException e) {
                logger.trace(e);
            }
        }

        return allLoadedWords;
    }


}