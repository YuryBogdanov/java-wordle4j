package ru.yandex.practicum.dictionary;

import ru.yandex.practicum.dictionary.errors.*;
import ru.yandex.practicum.logger.Logger;

import java.util.List;
import java.util.Random;

public class WordleDictionary {

    private List<String> words;
    private Logger logger;

    public WordleDictionary(List<String> words, Logger logger) {
        this.words = words;
        this.logger = logger;
    }

    public String selectWordForGame() throws EmptyDicitonaryException {
        if (words.isEmpty()) {
            throw new EmptyDicitonaryException("Dictionary is empty.");
        }
        Random random = new Random();

        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }

    public WordComparisonResult compareWords(String guessWord, String secretWord) throws IncorrectInputWordLengthException, EmptyInputWordException {
        if (guessWord.isBlank()) {
            throw new EmptyInputWordException("Введены пробелы. Попытка не списана, введите слово.");
        }
        if (guessWord.length() != secretWord.length()) {
            throw new IncorrectInputWordLengthException("Введено слово неподходящей длины");
        }
        if (!guessWord.matches("\\p{IsCyrillic}+")) {
            throw new NotCyrillicInputException("Допускаются только кириллические символы");
        }
        if (!words.contains(guessWord)) {
            throw new GibberishInputException("Введите существующее слово");
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
