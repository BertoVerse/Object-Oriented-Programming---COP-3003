package com.company;

class Student{

    private String name; // For the students name
    private int ssn; // for the social security number of the student
    private int numOfCourses; // for the number of classes the student is
    // enrolled for
    private Date birthDate; // for the birth date of the student
    protected char gender; // only one that is protected

// If statement in order to handle manage the variation between male and female
    private void readData(){
            System.out.print("Please input the name: ");
            name = Utilities.scanner.next();
            System.out.print("Please input the ssn: ");
            ssn = Utilities.scanner.nextInt();
            System.out.print("Male/Female (m/f): ");
            gender = Utilities.scanner.next().charAt(0);
            if(gender == 'm' || gender == 'M'){
                System.out.print("How many courses he is taking? ");
                numOfCourses = Utilities.scanner.nextInt();
                System.out.println("Please input his birth date:");
                birthDate = new Date();
            }else if(gender == 'f' || gender=='F'){
                System.out.print("How many courses she is taking? ");
                numOfCourses = Utilities.scanner.nextInt();
                System.out.println("Please input her birth date:");
                birthDate = new Date();{
            }

        }
    }
    Student(){
        this.readData();
    }

// This if statements work together with the println's in order to output a
// rundown of the data inputed by the user after being processed by the program
// considering the gender option

    public void print(){
        System.out.println();
        System.out.println("The information you input was");
        System.out.println(name + "'s ssn is " + ssn + ".");
        if(gender == 'm' || gender=='M'){
            System.out.println("He is taking " + numOfCourses + " courses.");
            System.out.print("His birth date is ");
            birthDate.print();
            System.out.println();

        }else if(gender == 'f' || gender=='F'){
            System.out.println("She is taking " + numOfCourses + " courses.");
            System.out.print("Her birth date is ");
            birthDate.print();
            System.out.println();

        }
    }

}
