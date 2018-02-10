package com.company;

class GradStudent extends Student { //Student is a superclass

    private String researchTopic; //created a string for researchTopic
    private String advisor; //created a string for advisor
    private void readData() { // if statement for gender
        if (gender == 'm' || gender == 'M') {
            System.out.print("Please input his research topic: ");
            researchTopic = Utilities.scanner.next();
            System.out.print("Please input his research advisor: ");
            advisor = Utilities.scanner.next();
        } else if (gender == 'f' || gender == 'F') {
            System.out.print("Please input her research topic: ");
            researchTopic = Utilities.scanner.next();
            System.out.print("Please input her research advisor: ");
            advisor = Utilities.scanner.next();

        }
    }

    GradStudent(){
        this.readData();
    }

    public void print(){ // if statement for gender
        super.print();
        if(gender == 'm' || gender=='M'){
            System.out.println("His research topic is " + researchTopic + ".");
            System.out.println("His advisor is " + advisor + ".");

        }else if(gender == 'f' || gender=='F'){
            System.out.println("Her research topic is " + researchTopic + ".");
            System.out.println("Her advisor is " + advisor + ".");

        }
    }
}
