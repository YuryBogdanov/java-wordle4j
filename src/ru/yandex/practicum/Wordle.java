package ru.yandex.practicum;

import ru.yandex.practicum.dictionary.WordleDictionary;
import ru.yandex.practicum.dictionary.WordleDictionaryLoader;
import ru.yandex.practicum.io.GameInteface;
import ru.yandex.practicum.io.GameInterfaceImpl;
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
        int gameWordLength = 5; // заготовка на случай, если вдруг захотим усложнить жизнь игроку и взять слова длиннее

        WordleDictionaryLoader loader = new WordleDictionaryLoader(logger, gameWordLength);
        WordleDictionary dictionary = loader.loadWordleDictionaryFromFile("words_ru.txt");

        GameInteface gameInteface = new GameInterfaceImpl();

        WordleGame game = new WordleGame(gameWordLength, dictionary, gameInteface);
        game.beginGame();
    }

}
