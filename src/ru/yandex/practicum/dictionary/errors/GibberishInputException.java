package ru.yandex.practicum.dictionary.errors;

public class GibberishInputException extends RuntimeException {
    public GibberishInputException(String message) {
        super(message);
    }
}
