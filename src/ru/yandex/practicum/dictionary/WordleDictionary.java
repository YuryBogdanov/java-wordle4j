package ru.yandex.practicum.dictionary;

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
}
