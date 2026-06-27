package ru.yandex.practicum;

import ru.yandex.practicum.dictionary.WordleDictionary;
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

    }

    private void selectGameWord() {
        userInterface.postMessage("Выбираем слово для игры...");
        selectedWord = dictionary.selectWordForGame();
        userInterface.postMessage("Слово выбрано! Попробуйте угадать.");
    }

    private void runGameCycle() {
        currentStep = 0;
        while (currentStep < maxStepsCount) {
            String guess = userInterface.askForInput("Попытка " + (currentStep + 1) + "из " + maxStepsCount);

        }
    }
}
