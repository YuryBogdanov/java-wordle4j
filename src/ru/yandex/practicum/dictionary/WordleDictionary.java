package ru.yandex.practicum.dictionary;

import ru.yandex.practicum.dictionary.errors.EmptyInputWord;
import ru.yandex.practicum.dictionary.errors.GibberishInput;
import ru.yandex.practicum.dictionary.errors.IncorrectInputWordLength;
import ru.yandex.practicum.logger.Logger;

import java.util.List;
import java.util.Random;

/*
этот класс содержит в себе список слов List<String>
    его методы похожи на методы списка, но учитывают особенности игры
    также этот класс может содержать рутинные функции по сравнению слов, букв и т.д.
 */
public class WordleDictionary {

    private List<String> words;
    private Logger logger;

    public WordleDictionary(List<String> words, Logger logger) {
        this.words = words;
        this.logger = logger;
    }

    public String selectWordForGame() {
        Random random = new Random();

        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }

    public WordComparisonResult compareWords(String guessWord, String secretWord) throws IncorrectInputWordLength, EmptyInputWord {
        if (guessWord.isBlank()) {
            throw new EmptyInputWord("Введены пробелы. Попытка не списана, введите слово.");
        }
        if (guessWord.length() != secretWord.length()) {
            throw new IncorrectInputWordLength("Введено слово неподходящей длины");
        }
        if (!words.contains(guessWord)) {
            throw new GibberishInput("Введите существующее слово");
        }

        boolean isGuessCorrect = true;
        StringBuilder maskBuilder = new StringBuilder();

        for (int i = 0; i < guessWord.length(); i++) {
            char currentGuessWordChar = guessWord.charAt(i);

            if (currentGuessWordChar == secretWord.charAt(i)) {
                maskBuilder.append("+");
            } else {
                String symbolToAppend = secretWord.contains(String.valueOf(currentGuessWordChar)) ? "^" : "-";
                maskBuilder.append(symbolToAppend);
                isGuessCorrect = false;
            }
        }

        return new WordComparisonResult(isGuessCorrect, maskBuilder.toString());
    }
}
