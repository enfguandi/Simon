package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Game {

    private int gameNumber = 0;
    private int wins = 0;
    private int losses = 0;
    private int[] userInput;
    private int[] randomLamp = new int[4];
    private Output output = new Output();
    private Input input = new Input();
    private int roundNumber = 1;
    private int userInputNumber = 1;
    private int maxGames = 0;

    public Game() {
        output.welcome();
        gameMenue();
    }

    public void newGame() {
        if (gameNumber == 1) {
            output.newFirstGame();
        } else {
            output.newGameX();
            output.stats(gameNumber, wins, losses);
        }
        mainGame();
    }

    public void randomLamp() {
        for (int i = 0; i < 4; i++) {
            randomLamp[i] = ThreadLocalRandom.current().nextInt(1, 4 + 1);
        }
    }

    public void gameMenue() {
        try {
            output.menue();
            int menue = input.readLine();
            if (menue == 1) {
                if (maxGames > 0) {
                    newGame();
                } else {
                    output.errorMaxGames();
                    gameMenue();
                }
            } else if (menue == 2) {
                output.stats(gameNumber, wins, losses);
                gameMenue();
            } else if (menue == 3) {
                maxGames();
            } else if (menue == 4) {
                output.bye();
                System.exit(0);
            } else {
                output.error();
                gameMenue();
            }
        } catch (NumberFormatException e) {
            output.numberFormatError();
            gameMenue();
        }

    }

    public void maxGames() throws NumberFormatException {
        int usrInput = 0;
        output.setMaxGames();
        usrInput = input.readLine();
        if (usrInput > 0) {
            maxGames = usrInput;
            gameMenue();
        } else {
            output.error();
            gameMenue();
        }
    }

    public void mainGame() {
        int eingabe;
        boolean check = false;
        roundNumber = 1;
        userInput = new int[4];

        if (maxGames >= gameNumber) {
            gameNumber++;
            randomLamp();
            for (int i = 0; i < 4; i++) {

                output.lampOutput(randomLamp[i]);
                output.sleep(2);
                clearScreen();

                for (int k = 1; k <= roundNumber; k++) {
                    try {
                        output.requestForInput(k);
                        eingabe = input.readLine();
                        userInput[k - 1] = eingabe;
                        check = checkUserInput();
                    } catch (NumberFormatException e) {
                        output.numberFormatError();
                        losses++;
                        gameMenue();
                    }

                    if (check) {
                        output.roundWin();
                        userInputNumber++;
                    } else {
                        losses++;
                        output.loss();
                        gameMenue();
                    }
                }
                userInputNumber = 1;
                roundNumber++;
            }
            wins++;
            output.win();
        } else {
            output.reachedMaxGames();
        }
        gameMenue();
    }

    public void clearScreen() {
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public boolean checkUserInput() {
        int correct = 0;

        for (int i = 0; i < userInputNumber; i++) {
            if (userInput[i] == randomLamp[i]) {
                correct++;
            }
        }

        if (correct == userInputNumber) {
            return true;
        } else {
            return false;
        }
    }
}
