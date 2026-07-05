package ru.yandex.practicum.logger;

public interface Logger {

    void setupLogger() throws Exception;

    void logMessage(String message);

    void closeLogger() throws Exception;
}
