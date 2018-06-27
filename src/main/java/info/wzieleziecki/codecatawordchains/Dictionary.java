package info.wzieleziecki.codecatawordchains;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

class Dictionary {

    private final Logger logger = Logger.getLogger(Main.class);

    List<String> loadWordsFromFile(String fileName) {
        List<String> loadedWords = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String word;
            while ((word = reader.readLine()) != null && !word.isEmpty()) {
                loadedWords.add(word);
            }

        } catch (IOException e) {
            logger.trace(e);
        }

        return loadedWords;
    }


}