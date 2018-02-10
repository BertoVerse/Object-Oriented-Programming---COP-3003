package com.company;

class Date {

    private int day; //Create variables for the following three
    private int month;
    private int year;

    private void readData() {
        System.out.print("\tPlease input the month: ");
        month = Utilities.scanner.nextInt();
        System.out.print("\tPlease input the day: ");
        day = Utilities.scanner.nextInt();
        System.out.print("\tPlease input the year: ");
        year = Utilities.scanner.nextInt();

    }    // constructor

    Date() {
        this.readData();
    }

    public void print() { // final output
        System.out.print(month + "/" + day + "/" + year);

    }
}

