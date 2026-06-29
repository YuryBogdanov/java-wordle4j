package ru.yandex.practicum.logger;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LoggerImpl implements Logger{

    private FileWriter writer;

    @Override
    public void setupLogger() throws Exception {
        try {
            writer = new FileWriter("game.log", true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void logMessage(String message) {
        // TODO: Реализовать запись в файл
        try {
            LocalDateTime currentTime = LocalDateTime.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            String formattedDateTime = currentTime.format(formatter);
            writer.write("[" + formattedDateTime + "] " + message);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Ошибка записи в лог!");
        }
    }

    @Override
    public void closeLogger() throws Exception {
        writer.close();
    }
}
