/*
Title: Cannon Simulator
Author: Draedn Groves
Date: Feb.2nd/2024
Purpose: Shoot a Cannon and calculate some stuff.
Display the units.
 */

// Necessary to scan for user input
import java.util.Scanner;

// Container class for everything
public class Main {

    public static double angle, velocity, time;

    // Calling the method main
    // The basics of how the program will operate
    public static void main(String[] args) {
        startProgram();
        closeProgram();
    }

    // Start Program method
    private static void startProgram() {
        welcomeUser();
        startMenu();
    }

    // Welcome the user with a startup message
    private static void welcomeUser() {
        System.out.println("*********************************************");
        System.out.println("    Welcome to my Cannon Shooter!");
        System.out.println("*********************************************");
    }

    // Close method
    private static void closeProgram() {
        System.out.println("*********************************************");
        System.out.println("       Hope you had fun shooting!");
        System.out.println("*********************************************");
    }

    // <editor-fold default state="collapsed" desc="startMenu">
    // Allow the user a menu selection
    private static void startMenu() {
        Scanner scanner = new Scanner(System.in);

        // Set choice NOT EQUAL to a menu option
        int choice = 0;

        do { // Display menu options
            System.out.println("*********************************************");
            System.out.println("        ~Cannon Shooter Menu~       ");
            System.out.println("*********************************************");
            System.out.println("Please select from the following:");
            System.out.println("1) Play Game");
            System.out.println("2) Exit");
            System.out.print("Enter your choice: ");

            // Error handling
            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input. Enter either [1 or 2] please: ");
                scanner.next();
            }

            // Set choice = the next int it finds.
            choice = scanner.nextInt();

            // Do something based on selection
            switch (choice) {
                case 1: // Option to play
                    System.out.println("You chose option 1. Ready the cannon!");
                    runProgram();
                    break;
                case 2: // Exit option
                    System.out.println("Exiting the program.");
                    break;
                default: // Otherwise, tell them this.
                    System.out.println("Invalid choice. Please enter 1 or 2.");
            }

        } while (choice != 2);

        scanner.close();

    }

    // </editor-fold>

    // Run Program method
    private static void runProgram() {
        angle = getAngle();
        velocity = getVelocity();
        time = getTime();
        displayOutput();
    }

    // <editor-fold default state="collapsed" desc="getAngle">
    private static double getAngle() {
        Scanner scan = new Scanner(System.in);


        // Get user input for angle value
        double angle = 0;
        boolean isValid = false;

        // Keep prompting the user until a valid angle is entered
        while (!isValid) {
            System.out.print("Let's adjust the cannon! ");
            System.out.print("Enter an angle value between the range of 0 and 90 degrees: ");

            try {
                // Attempt to read the input as a double
                angle = Double.parseDouble(scan.nextLine());
                isValid = Tools.isValidAngle(angle);

            } catch (Exception e) {
                // Handle the exception if the input cannot be parsed as a double
                System.out.println("There was an error! " + e);
            }
        }
        if (angle == 90) {
            System.out.println("Watch your head!");
        }
        System.out.println("You set the angle to: " + angle + " degrees");
        return angle;
    }
    // </editor-fold>

    // <editor-fold default state="collapsed" desc="getVelocity">
    private static double getVelocity() {
        Scanner scan = new Scanner(System.in);


        // Get user input for angle value
        double velocity = -1;

        // Keep prompting the user until a valid time is entered
        while (!Tools.isValidNumber(velocity)) {
            System.out.print("Enter a positive number. This will represent the ball's speed.");

            try {
                // Attempt to read the input as a double
                velocity = Double.parseDouble(scan.nextLine());

            } catch (Exception e) {
                // Handle the exception if the input cannot be parsed as a double
                System.out.println("Invalid value for velocity! Please enter a positive number!");
            }
        }
        System.out.println("You set the velocity to: " + velocity + " m/s");
        return velocity;

    }
    // </editor-fold>

    // <editor-fold default state="collapsed" desc="getTime">
    private static double getTime() {
        Scanner scan = new Scanner(System.in);


        // Get user input for angle value
        double time = -1;

        // Keep prompting the user until a valid time is entered
        while (!Tools.isValidNumber(time)) {
            System.out.print("Let's see where the ball is at a specified time of your choosing.");
            System.out.print("Enter a positive number. This will represent time.");

            try {
                // Attempt to read the input as a double
                time = Double.parseDouble(scan.nextLine());

            } catch (Exception e) {
                // Handle the exception if the input cannot be parsed as a double
                System.out.println("Invalid value for time! Please enter a value within reason.");
            }
        }
        System.out.println("You set the time to: " + time + " second(s)");
        return time;

    }
    private static void displayOutput() {
        System.out.println("\nProjectile Position Calculation:");
        System.out.println("Horizontal Distance: " + Tools.roundToTwoDecimalPlaces(Tools.calculateHorizontalDistance(angle,velocity,time)) + " meters");
        System.out.println("Vertical Distance: " + Tools.roundToTwoDecimalPlaces(Tools.calculateVerticalDistance(angle,velocity,time)) + " meters");
    }
    // CHAT GPT 3.5 (2024) --- Prompt: " How would I display the following code you just gave me in JAVA IntelliJ IDE?"

    // </editor-fold>

} // Main closing curly boy