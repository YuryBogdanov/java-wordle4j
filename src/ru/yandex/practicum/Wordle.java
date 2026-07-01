package ru.yandex.practicum;

import ru.yandex.practicum.dictionary.WordleDictionary;
import ru.yandex.practicum.dictionary.WordleDictionaryLoader;
import ru.yandex.practicum.io.GameInteface;
import ru.yandex.practicum.io.GameInterfaceImpl;
import ru.yandex.practicum.logger.Logger;
import ru.yandex.practicum.logger.LoggerImpl;

public class Wordle {

    public static void main(String[] args) {
        Logger logger = new LoggerImpl();
        try {
            logger.setupLogger();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int gameWordLength = 5; // заготовка на случай, если вдруг захотим усложнить жизнь игроку и взять слова длиннее

        WordleDictionaryLoader loader = new WordleDictionaryLoader(logger, gameWordLength);
        WordleDictionary dictionary = loader.loadWordleDictionaryFromFile("words_ru.txt");

        GameInteface gameInteface = new GameInterfaceImpl();

        WordleGame game = new WordleGame(gameWordLength, dictionary, gameInteface);
        try {
            game.beginGame();
        } catch (Exception e) {
            logger.logMessage("Aborting game.");
        }

        try {
            logger.closeLogger();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
