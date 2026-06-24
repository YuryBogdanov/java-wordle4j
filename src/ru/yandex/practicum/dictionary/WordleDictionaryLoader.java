package ru.yandex.practicum.dictionary;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/*
этот класс содержит в себе всю рутину по работе с файлами словарей и с кодировками
    ему нужны методы по загрузке списка слов из файла по имени файла
    на выходе должен быть класс WordleDictionary
 */
public class WordleDictionaryLoader {
    private final int GAME_WORD_LENGTH = 5;

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
                    .filter(word -> word.length() == GAME_WORD_LENGTH)
                    .toList();
        } catch (FileNotFoundException e) {
            System.out.println("kurwa");
            return List.of();
        } catch (IOException e) {
            System.out.println("kurwo");
            return List.of();
        }
    }
}
