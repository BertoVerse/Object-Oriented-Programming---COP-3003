package com.company;

class GradTA extends GradStudent { // Grad student is a superclass

    private String taCourse; // string for taCourse
    private String taInstructor; // string for taInstructor
    private Date hireDate; // string for hireDate

    private void readData() { // he/she his/her (gender)

        if (gender == 'm' || gender == 'M') {
            System.out.print("Please input his Ta course: ");
            taCourse = Utilities.scanner.nextLine();
            Utilities.scanner.next();
            System.out.print("Please input his Ta instructor: ");
            taInstructor = Utilities.scanner.next();
            System.out.println("Please input his hire Date");
            hireDate = new Date();
        } else if (gender == 'f' || gender == 'F') {
            System.out.print("Please input her Ta course: ");
            taCourse = Utilities.scanner.next();
            System.out.print("Please input her Ta instructor: ");
            taInstructor = Utilities.scanner.next();
            System.out.println("Please input her hire Date");
            hireDate = new Date();
        }

    }

    GradTA() {
        this.readData();
    }


    public void print() {
        super.print();
        if (gender == 'm' || gender == 'M') { //consideration of gender
            System.out.println("His Ta Course is " + taCourse + ".");
            System.out.println("His Ta Instructor is " + taInstructor + ".");
            System.out.print("His hire date is ");
            hireDate.print();
            System.out.println();

        } else if (gender == 'f' || gender == 'F') {
            System.out.println("Her Ta Course is " + taCourse + ".");
            System.out.println("Her Ta Instructor is " + taInstructor + ".");
            System.out.print("Her hire date is ");
            hireDate.print();
            System.out.println();

        }
    }
}