package ru.yandex.practicum;

import ru.yandex.practicum.dictionary.WordleDictionaryLoader;
import ru.yandex.practicum.logger.Logger;
import ru.yandex.practicum.logger.LoggerImpl;

/*
в главном классе нам нужно:
    создать лог-файл (он должен передаваться во все классы)
    создать загрузчик словарей WordleDictionaryLoader
    загрузить словарь WordleDictionary с помощью класса WordleDictionaryLoader
    затем создать игру WordleGame и передать ей словарь
    вызвать игровой метод в котором в цикле опрашивать пользователя и передавать информацию в игру
    вывести состояние игры и конечный результат
 */
public class Wordle {

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();

        WordleDictionaryLoader loader = new WordleDictionaryLoader(logger);
        loader.loadWordleDictionaryFromFile("words_ru.txt");
    }

}
