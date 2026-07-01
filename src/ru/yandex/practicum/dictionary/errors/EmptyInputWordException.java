package ru.yandex.practicum.dictionary.errors;

public class EmptyInputWordException extends RuntimeException {
    public EmptyInputWordException(String message) {
        super(message);
    }
}
