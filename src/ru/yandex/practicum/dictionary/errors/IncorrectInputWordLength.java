package ru.yandex.practicum.dictionary.errors;

public class IncorrectInputWordLength extends RuntimeException {
    public IncorrectInputWordLength(String message) {
        super(message);
    }
}
