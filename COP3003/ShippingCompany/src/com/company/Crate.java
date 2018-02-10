package com.company;

import java.util.Scanner;

abstract class Crate implements Package {    // Abstract class
    public double weight;
// Crate defines methods
    @Override
    //If a class inherits a method from its superclass, then there is a
    // chance to override the method provided that it is not marked final.
    public double cost() {
        // It tells your program to execute a certain section of code only if a
        // particular test evaluates to true
        if (this.getClass().getSimpleName().equalsIgnoreCase("MetalCrate")) {
            return this.weight * 1.4;
        } else {
            return this.weight * 1.3;
        }
    }

    @Override
    public void input(Scanner scanner) {

        System.out.println("Please input the weight for the " + getClass()
                .getSimpleName());
        weight = scanner.nextDouble();


    }

}
