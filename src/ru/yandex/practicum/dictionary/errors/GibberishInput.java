package ru.yandex.practicum.dictionary.errors;

public class GibberishInput extends RuntimeException {
    public GibberishInput(String message) {
        super(message);
    }
}
