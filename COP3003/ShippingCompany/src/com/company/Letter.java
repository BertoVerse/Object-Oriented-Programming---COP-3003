package com.company;

import java.util.Scanner;
// below, letter is a subclass of package
public class Letter implements Package {
    private int numPages;

    //Returns number of pages
    public double cost() {
        return .05 * numPages;
    }

    //Reads input from user
    public void input(Scanner scanner) {

        System.out.println("Please input the number of pages for the letter " +
                "(pgs)");
        numPages = scanner.nextInt(); // gets user input
    }
}

