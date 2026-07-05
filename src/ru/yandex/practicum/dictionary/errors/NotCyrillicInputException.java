package ru.yandex.practicum.dictionary.errors;

public class NotCyrillicInputException extends RuntimeException {
    public NotCyrillicInputException(String message) {
        super(message);
    }
}
