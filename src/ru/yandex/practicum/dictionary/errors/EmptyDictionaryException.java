package ru.yandex.practicum.dictionary.errors;

public class EmptyDictionaryException extends RuntimeException {
    public EmptyDictionaryException(String message) {
        super(message);
    }
}
