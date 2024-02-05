/*
Title: Cannon Simulator
Author: Draedn Groves
Date: Feb.2nd/2024
Purpose: Tools used for calculating cannon stuff.
 */


// Container for tools to be used.
// Tools should be GENERIC enough to be used in other programs.
public class Tools {

    private static final double GRAVITY = 9.81; // GRAVITY (metres per second squared)

    // Method to calculate horizontal distance
    public static double calculateHorizontalDistance(double angle, double velocity, double time) {
        double angleInRadians = Math.toRadians(angle);
        return velocity * Math.cos(angleInRadians) * time;
    }

    // CHAT GPT 3.5 (2024) --- Prompt: " How would I implement the following math formulas in JAVA IntelliJ IDE?"

    // Method to calculate vertical distance
    public static double calculateVerticalDistance(double angle, double velocity, double time) {
        double angleInRadians = Math.toRadians(angle);
        double verticalDistance = (velocity * Math.sin(angleInRadians) * time) - (0.5 * GRAVITY * Math.pow(time, 2));

        return Math.max(0, verticalDistance); // Ensure vertical distance doesn't drop below zero
    }

    // CHAT GPT 3.5 (2024) --- Prompt: " How would I implement the following math formulas in JAVA IntelliJ IDE?"
    // I then copy pasted the formulas from the assignment sheet.

    // Validate angle
    public static boolean isValidAngle(double angle) {
        if (angle >= 0 && angle <= 90) {
            return true;
        }
        else {
            System.out.println("Invalid angle value! Please enter a value within the range specified.");
            return false;
        }
    }

    // Validate positive number
    public static boolean isValidNumber(double number) {
        if (number >= 0) {
            return true;
        }
        else {
            return false;
        }
    }

    // Method to round a double to two decimal places
    public static double roundToTwoDecimalPlaces(double value) {
        return Math.round(value * 100.0) / 100.0;
    }
    // CHAT GPT 3.5 (2024) --- Prompt: " How would I round two decimal places in JAVA IntelliJ IDE?"
}
