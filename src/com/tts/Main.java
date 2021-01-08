package com.tts;

import java.util.Scanner;

public class Main {


    private static final int MAX_MAGIC = 75;
    private static final int MAX_BALL = 60;

    public static void main(String[] args) {


        Scanner kb = new Scanner(System.in);
        String userName = "";
        String response = "";
        boolean keepGoing = false;

        // Establish our program's legitimacy by printing to console
        System.out.println("Hello world!");

        // Display the valid input characters
        AsciiChars.printNumbers();
        AsciiChars.printLowerCase();
        AsciiChars.printUpperCase();

        // Ask for the user's name and display it
        System.out.println("What is your name?");
        System.out.print("Name: ");
        userName = kb.nextLine();
        System.out.println("Hello, " + userName);

        // Ask if user wants to begin the interactive portion
        System.out.println("Would you like to continue to the interactive zone?");
        System.out.print("(Y/N): ");
        response = kb.nextLine();

        keepGoing = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));
        System.out.println("Will we keep going: " + keepGoing);

        while (keepGoing) {

            System.out.println("Let's generate some numbers!");

            // Question: Red Car
            System.out.print("Do you have a red car? (yes, no): ");
            String redCar = kb.nextLine();
            boolean redCarBool = false;
            if (redCar.equalsIgnoreCase("y") || redCar.equalsIgnoreCase("yes")) {
                System.out.println("Cool red car!");
                redCarBool = true;
            } else System.out.println("So no red car then, got it!");

            // Question: Favorite Pet
            String favPet = "";
            System.out.println("What's the name of your favorite pet? : ");
            favPet = kb.nextLine();
            System.out.println("Oh cool, a pet named " + favPet + ", how original!");


            // Question: Lucky number
            System.out.println("What's your lucky number? (int only): ");
            int luckyNumber = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Wow, your lucky number is " + luckyNumber + "? Lucky!!");


            // Question: Jersey Number
            boolean favQB = false;
            System.out.println("Do you have a favorite qb? (Y/N): ");
            response = kb.nextLine();
            favQB = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));
            if (favQB) {
                System.out.println("Cool! What's their jersey number? (##): ");

            } else System.out.println("Ok, well just give me a two-digit number then! (##): ");
            int jerseyNum = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Cool! Your jersey number is " + jerseyNum + ", good choice!");

            // Question: Model Year
            System.out.println("What are the last two digits of your car's model year? (##): ");
            int modelYear = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Ah yes, good ol '" + modelYear + ", the best year for those models!");

            // Question: Favorite Actor
            System.out.println("Who is your favorite actor or actress? (name): ");
            String favActor = kb.nextLine();
            System.out.println("Oh you know " + favActor + "? I thought they were pretty underground.");

            // Question: Random Number 1-50
            System.out.println("Enter any random number between 0 and 50! (0-50): ");
            int randoNumber = kb.nextInt();
            System.out.println("Wow, " + randoNumber + ", so random!");


            // Generate the lotto numbers!
            int ball_magic = 0;




            System.out.println("Do you want to play again? (Y/N): ");
            response = kb.nextLine();
            keepGoing = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));

        }

        System.out.println("All done!");
    }
}
