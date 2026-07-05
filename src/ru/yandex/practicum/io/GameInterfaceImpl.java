package ru.yandex.practicum.io;

import java.util.Scanner;

public class GameInterfaceImpl implements GameInteface {

    private Scanner scanner = new Scanner(System.in);

    @Override
    public String askForInput(String hint) {
        System.out.println(hint);
        return scanner.nextLine();
    }

    @Override
    public void postMessage(String message) {
        System.out.println(message);
    }
}
