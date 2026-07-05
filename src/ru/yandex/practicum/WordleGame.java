package ru.yandex.practicum;

import ru.yandex.practicum.dictionary.WordComparisonResult;
import ru.yandex.practicum.dictionary.WordleDictionary;
import ru.yandex.practicum.dictionary.errors.*;
import ru.yandex.practicum.io.GameInteface;

import java.util.ArrayList;
import java.util.List;

public class WordleGame {

    private int maxStepsCount;
    private int currentStep;

    private WordleDictionary dictionary;
    private GameInteface userInterface;

    private String selectedWord;

    private List<String> tries = new ArrayList<>();

    public WordleGame(int gameLength, WordleDictionary dictionary, GameInteface userInterface) {
        this.maxStepsCount = gameLength;
        this.dictionary = dictionary;
        this.userInterface = userInterface;
    }

    public void beginGame() throws EmptyDictionaryException {
        selectGameWord();
        runGameCycle();
    }

    private void selectGameWord() throws EmptyDictionaryException {
        userInterface.postMessage("Выбираем слово из " + maxStepsCount + " букв для игры...");

        selectedWord = dictionary.selectWordForGame();
        userInterface.postMessage("Слово выбрано! Попробуйте угадать. ");
    }

    private void runGameCycle() {
        currentStep = 0;
        while (currentStep < maxStepsCount) {
            String guess = userInterface.askForInput("Попытка " + (currentStep + 1) + " из " + maxStepsCount);

            if (guess.isBlank()) {
                guess = dictionary.getHint(tries);
                userInterface.postMessage("Пробуем подсказку: " + guess);
            }

            if (processGuessWord(guess)) {
                return;
            }

            currentStep += 1;
        }
        userInterface.postMessage("Вы не угадали слово. Повезёт в другой раз!");
    }

    private boolean processGuessWord(String word) {
        tries.add(word);
        try {
            WordComparisonResult comparisonResult = dictionary.compareWords(word, selectedWord);
            userInterface.postMessage(comparisonResult.getResultMask());

            if (comparisonResult.isCorrect()) {
                userInterface.postMessage("Вы угадали! Поздравляем!");
                return true;
            }
        } catch (IncorrectInputWordLengthException | GibberishInputException | NotCyrillicInputException e) {
            userInterface.postMessage(e.getMessage());
        }

        return false;
    }
}
