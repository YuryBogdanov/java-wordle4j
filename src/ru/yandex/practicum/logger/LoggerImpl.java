package ru.yandex.practicum.logger;

public class LoggerImpl implements Logger{
    @Override
    public void logMessage(String message) {
        // TODO: Реализовать запись в файл
        System.out.println("=== [Wordle Log] " + message);
    }
}
