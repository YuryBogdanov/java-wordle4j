package ru.yandex.practicum.dictionary.errors;

public class IncorrectInputWordLengthException extends RuntimeException {
    public IncorrectInputWordLengthException(String message) {
        super(message);
    }
}
