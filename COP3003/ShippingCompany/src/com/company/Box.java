package com.company;

import java.util.Scanner;

public class Box implements Package {
// Box is a subclass of Package (above)
    private double weight;

    //Returns the cost of box
    public double cost() {
        return 1.2 * weight;
    }

    //Read input from user
    public void input(Scanner scanner) {

        System.out.println("Please input the weight for the box (lbs) :");
        weight = scanner.nextDouble();

    }

}