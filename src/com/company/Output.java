package com.company;

import java.util.concurrent.TimeUnit;

public class Output {

    public void welcome() {
        System.out.println();
        System.out.println("Welcome to Simon the Memory Game.");
        sleep(1);
    }

    public void newFirstGame() {
        System.out.println("Good luck!");
    }

    public void newGameX() {
        System.out.println("New round, new luck!");
    }

    public void stats(int roundNumber, int wins, int losses) {
        System.out.println("You played " + roundNumber + " rounds. You have " + wins + " wins and " + losses + " losses.");
    }

    public void menue() {
        System.out.println();
        System.out.println("---- Menü ----");
        System.out.println("Press 1 for New Game");
        System.out.println("Press 2 for Your stats");
        System.out.println("Press 3 to set the maximum of games");
        System.out.println("Press 4 for Exit");
    }

    public void bye() {
        System.out.println("See you soon!");
    }

    public void error() {
        System.out.println("You put in a wrong number.");
        System.out.print("Restart.");
        sleep(1);
        System.out.print(".");
        sleep(1);
        System.out.print(".");
        sleep(1);
        System.out.println(".");
    }

    public void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            System.out.println("Sleep Exception!!!!");
        }
    }

    public void lampOutput(int lamp) {
        System.out.print(lamp + " ");
    }

    public void requestForInput(int roundNumber) {
        System.out.println("Pleas enter " + roundNumber + " lamp number.");
    }

    public void win() {
        System.out.println("Lucky guy! You won!");
    }

    public void roundWin() {
        System.out.println("Nice. Go on!");
    }

    public void loss() {
        System.out.println("Poor guy! You lost!");
    }

    public void errorMaxGames() {
        System.out.println("You have to set your maximum number of games first!");
    }

    public void setMaxGames() {
        System.out.println("Please put in the Number of max Games:");
    }

    public void reachedMaxGames() {
        System.out.println("You reached your max games limit. Please specify a new one or quit the game.");
    }

    public void numberFormatError() {
        System.out.println("The input must not be null!!");
    }

}
