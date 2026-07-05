package ru.yandex.practicum.dictionary;

import ru.yandex.practicum.logger.Logger;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class WordleDictionaryLoader {
    private Logger logger;
    private int gameWordLength;

    public WordleDictionaryLoader(Logger logger, int gameWordLength) {
        this.logger = logger;
        this.gameWordLength = gameWordLength;
    }

    public WordleDictionary loadWordleDictionaryFromFile(String fileName) {
        List<String> gameWords = loadWordsFromFile(fileName);
        return new WordleDictionary(gameWords);
    }

    private List<String> loadWordsFromFile(String fileName) {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(fileName))) {
            return fileReader
                    .lines()
                    .toList()
                    .stream()
                    .filter(word -> word.length() == gameWordLength)
                    .toList();
        } catch (FileNotFoundException e) {
            logger.logMessage("Specified dictionary file not found: " + e.getMessage());
            return List.of();
        } catch (IOException e) {
            logger.logMessage("File reading error: " + e.getMessage());
            return List.of();
        }
    }
}
