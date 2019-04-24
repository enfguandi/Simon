package com.company;


import java.util.Scanner;

public class Input {

    Scanner scanner = new Scanner(System.in);

    public int readLine() {
        String inputString = scanner.nextLine();

        return Integer.parseInt(inputString);
    }
}
