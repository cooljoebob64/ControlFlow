package com.tts;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {


    private static final int MAX_MAGIC = 75;
    private static final int MAX_BALL = 60;
    private static final int BALL_PULL = 5;

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
            System.out.println("Do you have a red car? (yes, no): ");
            String redCar = kb.nextLine();
            boolean redCarBool = false;
            if (redCar.equalsIgnoreCase("y") || redCar.equalsIgnoreCase("yes")) {
                System.out.println("Cool red car!");
                redCarBool = true;
            } else System.out.println("So no red car then, got it!");
            //TODO: Check Input - Red Car

            // Question: Favorite Pet
            String favPet = "";
            System.out.println("What's the name of your favorite pet? : ");
            favPet = kb.nextLine();
            System.out.println("Oh cool, a pet named " + favPet + ", how original!");
            // TODO: Check Input - Favorite Pet

            // Question: Pet Age
            System.out.println("What is the age of " + favPet + " in years? (##): ");
            int petAge = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Wow, " + favPet + " is already " + petAge + "? They sure don't look it!");
            // TODO: Check Input - Pet Age

            // Question: Lucky number
            System.out.println("What's your lucky number? (int only): ");
            int luckyNumber = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Wow, your lucky number is " + luckyNumber + "? Lucky!!");
            // TODO: Check Input - Lucky Number

            // Question: Jersey Number
            boolean favQB = false;
            System.out.println("Do you have a favorite qb? (Y/N): ");
            response = kb.nextLine();
            favQB = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));
            if (favQB) { // TODO: Check Input - favQB
                System.out.println("Cool! What's their jersey number? (##): ");

            } else System.out.println("Ok, well just give me a two-digit number then! (##): ");
            int jerseyNum = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Cool! Your jersey number is " + jerseyNum + ", good choice!");
            // TODO: Check Input - Jersey Number

            // Question: Model Year
            System.out.println("What are the last two digits of your car's model year? (##): ");
            int modelYear = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Ah yes, good ol '" + modelYear + ", the best year for those models!");
            // TODO: Check Input - Model Year

            // Question: Favorite Actor
            System.out.println("Who is your favorite actor or actress? (name): ");
            String favActor = kb.nextLine();
            System.out.println("Oh you know " + favActor + "? I thought they were pretty underground.");
            // TODO: Check Input - Fav Actor

            // Question: Random Number 1-50
            System.out.println("Enter any random number between 0 and 50! (0-50): ");
            int randoNumber = kb.nextInt();
            response = kb.nextLine();
            System.out.println("Wow, " + randoNumber + ", so random!");
            // TODO: Check Input - Random Number


            // Generate the lotto numbers!
            int ball_magic = 0;
            int rando_magic = (int) Math.floor(Math.random() * MAX_MAGIC) + 1;
            int rando_ball1 = (int) Math.floor(Math.random() * MAX_BALL) + 1;
            int rando_ball2 = (int) Math.floor(Math.random() * MAX_BALL) + 1;

            // Final Magic Ball Result
            int userProvidedNumber = Math.random() > 0.5 ? jerseyNum : randoNumber;
            int finalMagicBall = (int) (Math.floor(Math.random() * userProvidedNumber + 1));
            finalMagicBall = reduceMagic(finalMagicBall);

            ArrayList<Integer> resultHopper = new ArrayList<>();

            // Final Pet Ball Result
            int finalFavePet = favPet.charAt(2);
            finalFavePet = reduceNormal(finalFavePet);
            resultHopper.add(finalFavePet);

            // Final Model Year + Lucky Number Result
            int finalModelYearAndLucky = modelYear + luckyNumber;
            finalModelYearAndLucky = reduceNormal(finalModelYearAndLucky);
            resultHopper.add(finalModelYearAndLucky);

            // Final Random Number Result
            int finalRandomNumber = randoNumber - (Math.random() < 0.5 ? rando_ball1 : rando_ball2);
            finalRandomNumber = reduceNormal(finalRandomNumber);
            resultHopper.add(finalRandomNumber);

            // Final Fav Actor Result
            int finalFavActor = favActor.charAt(0);
            finalFavActor = reduceNormal(finalFavActor);
            resultHopper.add(finalFavActor);

            // Final End Fav Actor Result
            int finalEndFavActor = favActor.charAt(favActor.length() - 1);
            finalEndFavActor = reduceNormal(finalEndFavActor);
            resultHopper.add(finalEndFavActor);

            // Final 42 Result
            int final42 = 42;
            final42 = reduceNormal(final42);
            resultHopper.add(final42);

            // Final Pet Age + Model Year Result
            int finalPetAgeAndModelYear = petAge + modelYear;
            finalPetAgeAndModelYear = reduceNormal(finalPetAgeAndModelYear);
            resultHopper.add(finalPetAgeAndModelYear);


            // Final Fav QB + Pet Age + Lucky Num Result
            int finalQBAndPetAgeAndLuckyNum = jerseyNum + petAge + luckyNumber;
            finalQBAndPetAgeAndLuckyNum = reduceNormal(finalQBAndPetAgeAndLuckyNum);
            resultHopper.add(finalQBAndPetAgeAndLuckyNum);



            // Select BALL_PULL results
            int[] yourResults = new int[BALL_PULL];
            for (int i = 0; i < BALL_PULL; i++) {
                int randomPull = (int)Math.floor(Math.random()*resultHopper.size());
                yourResults[i]=resultHopper.get(randomPull);
                resultHopper.remove(randomPull);
            }

            // Print the final results!
            System.out.print("\n\nYour lottery numbers: ");
            for (int i=0;i<BALL_PULL;i++
                 ) {
                System.out.print(yourResults[i]);
                if (i<BALL_PULL-1) System.out.print(",");
                System.out.print(" ");
            }
            System.out.print("Magic Ball: " + finalMagicBall + "\n\n");

            // Play Again?
            System.out.println("Do you want to play again? (Y/N): ");
            response = kb.nextLine();
            keepGoing = (response.equalsIgnoreCase("y") || response.equalsIgnoreCase("yes"));

        }

        System.out.println("All done!");
    }

    private static int reduceBall(int ballSeed, int max) {
        while (ballSeed > max) ballSeed -= max;
        return ballSeed;
    }

    private static int reduceMagic(int magicBallSeed) {
        return reduceBall(magicBallSeed, MAX_MAGIC);
    }

    private static int reduceNormal(int normalBallSeed) {
        return reduceBall(normalBallSeed, MAX_BALL);
    }
}
