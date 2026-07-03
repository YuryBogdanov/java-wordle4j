package ru.yandex.practicum.dictionary;

import ru.yandex.practicum.dictionary.errors.*;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class WordleDictionary {

    private List<String> words;
    private HashMap<Integer, Character> currentCorrectMask = new HashMap<>();

    public WordleDictionary(List<String> words) {
        this.words = words;
    }

    public String selectWordForGame() throws EmptyDictionaryException {
        if (words.isEmpty()) {
            throw new EmptyDictionaryException("Dictionary is empty.");
        }
        Random random = new Random();

        int randomIndex = random.nextInt(words.size());

        return words.get(randomIndex);
    }

    public WordComparisonResult compareWords(String guessWord, String secretWord) throws IncorrectInputWordLengthException {
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
                currentCorrectMask.put(i, currentGuessWordChar);
            } else {
                String symbolToAppend = secretWord.contains(String.valueOf(currentGuessWordChar)) ? "^" : "-";
                maskBuilder.append(symbolToAppend);
                isGuessCorrect = false;
            }
        }

        return new WordComparisonResult(isGuessCorrect, maskBuilder.toString());
    }

    public String getHint(List<String> tries) {
        List<String> probableWords = words
                .stream()
                .filter(word -> !tries.contains(word))
                .filter(this::wordMatchesCurrentCorrectMask)
                .toList();

        Random random = new Random();
        int randomIndex = random.nextInt(probableWords.size());
        return probableWords.get(randomIndex);
    }

    private boolean wordMatchesCurrentCorrectMask(String word) {
        if (currentCorrectMask.isEmpty()) {
            return true;
        }

        boolean wordIsMatching = true;
        for (int i = 0; i < word.length(); i++) {
            if (currentCorrectMask.containsKey(i)) {
                wordIsMatching = currentCorrectMask.get(i) == word.charAt(i);
            }
        }
        return wordIsMatching;
    }
}
