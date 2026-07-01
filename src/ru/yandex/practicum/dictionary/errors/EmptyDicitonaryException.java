package ru.yandex.practicum.dictionary.errors;

public class EmptyDicitonaryException extends RuntimeException {
    public EmptyDicitonaryException(String message) {
        super(message);
    }
}
