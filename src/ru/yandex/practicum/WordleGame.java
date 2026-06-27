package ru.yandex.practicum;

import ru.yandex.practicum.dictionary.WordComparisonResult;
import ru.yandex.practicum.dictionary.WordleDictionary;
import ru.yandex.practicum.dictionary.errors.IncorrectInputWordLength;
import ru.yandex.practicum.io.GameInteface;

/*
в этом классе хранится словарь и состояние игры
    текущий шаг
    всё что пользователь вводил
    правильный ответ

в этом классе нужны методы, которые
    проанализируют совпадение слова с ответом
    предложат слово-подсказку с учётом всего, что вводил пользователь ранее

не забудьте про специальные типы исключений для игровых и неигровых ошибок
 */
public class WordleGame {

    private String answer;

    private int maxStepsCount;
    private int currentStep;

    private WordleDictionary dictionary;
    private GameInteface userInterface;

    private String selectedWord;

    public WordleGame(int gameLength, WordleDictionary dictionary, GameInteface userInterface) {
        this.maxStepsCount = gameLength;
        this.dictionary = dictionary;
        this.userInterface = userInterface;
    }

    public void beginGame() {
        selectGameWord();
        runGameCycle();
    }

    private void selectGameWord() {
        userInterface.postMessage("Выбираем слово из " + maxStepsCount + " букв для игры...");
        selectedWord = dictionary.selectWordForGame();
        userInterface.postMessage("Слово выбрано! Попробуйте угадать. " + selectedWord);
    }

    private void runGameCycle() {
        currentStep = 0;
        while (currentStep < maxStepsCount) {
            String guess = userInterface.askForInput("Попытка " + (currentStep + 1) + " из " + maxStepsCount);

            try {
                WordComparisonResult comparisonResult = dictionary.compareWords(guess, selectedWord);
                userInterface.postMessage(comparisonResult.getResultMask());

                if (comparisonResult.isCorrect()) {
                    userInterface.postMessage("Вы угадали! Поздравляем!");
                    return;
                }
            } catch (IncorrectInputWordLength e) {
                userInterface.postMessage("Неправильная длина слова. Это стоило вам одной попытки.");
            }

            currentStep += 1;
        }
        userInterface.postMessage("Вы не угадали слово. Повезёт в другой раз!");
    }
}
