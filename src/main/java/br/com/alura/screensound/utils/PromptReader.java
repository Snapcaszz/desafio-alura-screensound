package br.com.alura.screensound.utils;

import java.util.Scanner;

public class PromptReader {
    private Scanner scanner = new Scanner(System.in);

    public Integer readInt() {
        Integer integer = scanner.nextInt();
        scanner.nextLine();
        return integer;
    }

    public String readString() {
        return scanner.nextLine();
    }
}
