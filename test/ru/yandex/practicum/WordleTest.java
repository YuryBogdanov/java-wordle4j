package ru.yandex.practicum;

import org.junit.jupiter.api.Test;
import ru.yandex.practicum.dictionary.WordComparisonResult;
import ru.yandex.practicum.dictionary.WordleDictionary;
import ru.yandex.practicum.dictionary.errors.EmptyDictionaryException;
import ru.yandex.practicum.dictionary.errors.GibberishInputException;
import ru.yandex.practicum.dictionary.errors.NotCyrillicInputException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordleTest {

    @Test
    void testCorrectWordComparison() {
        // given
        String secretWord = "рубль";
        String guessWord = "рубль";
        WordleDictionary dict = new WordleDictionary(List.of("рубль"));
        String resultMask = "+++++";

        // when
        WordComparisonResult result = dict.compareWords(guessWord, secretWord);

        // then
        assertTrue(result.isCorrect());
        assertEquals(resultMask, result.getResultMask());
    }

    @Test
    void testMatchingWordComparison() {
        // given
        String secretWord = "рубль";
        String guessWord = "курва";
        WordleDictionary dict = new WordleDictionary(List.of("рубль", "знать", "курва"));
        String resultMask = "-+^--";

        // when
        WordComparisonResult result = dict.compareWords(guessWord, secretWord);

        // then
        assertFalse(result.isCorrect());
        assertEquals(resultMask, result.getResultMask());
    }

    @Test
    void testExceptionInWordComparison() {
        // given
        String secretWord = "рубль";
        String guessWord = "курва";
        WordleDictionary dict = new WordleDictionary(List.of("рубль", "знать"));

        // when + then
        assertThrows(GibberishInputException.class, () -> {
            WordComparisonResult result = dict.compareWords(guessWord, secretWord);
        });
    }

    @Test
    void testLatinWordComparison() {
        // given
        String secretWord = "рубль";
        String guessWord = "clock";
        WordleDictionary dict = new WordleDictionary(List.of("рубль", "знать"));


        // when + then
        assertThrows(NotCyrillicInputException.class, () -> {
            WordComparisonResult result = dict.compareWords(guessWord, secretWord);
        });
    }

    @Test
    void testEMptyDictionaryThrowsError() {
        // given
        WordleDictionary dict = new WordleDictionary(List.of());

        // when + then
        assertThrows(EmptyDictionaryException.class, () -> {
            String secretWord = dict.selectWordForGame();
        });
    }
}
