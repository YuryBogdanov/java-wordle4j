package ru.yandex.practicum.dictionary.errors;

public class EmptyInputWord extends RuntimeException {
    public EmptyInputWord(String message) {
        super(message);
    }
}
