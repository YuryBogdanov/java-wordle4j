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

    private int steps;

    private WordleDictionary dictionary;
    private GameInteface userInterface;


    public WordleGame(WordleDictionary dictionary, GameInteface userInterface) {
        this.dictionary = dictionary;
        this.userInterface = userInterface;
    }

    public void beginGame() {

    }
}
