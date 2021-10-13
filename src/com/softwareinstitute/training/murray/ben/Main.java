package com.softwareinstitute.training.murray.ben;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {
        /*
        Assuming standard rectangular room with all doors and windows the same dimensions,
        and that the painter is painting all the walls (and ceiling) surface area,
        but not window frames or doors.
        */
        System.out.println("\n-------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("This program assumes you want to paint all the walls of a rectangular room, and that you arent painting window frames or doors.");
        System.out.println("\nPlease only enter positive numbers, and only to at most 2 decimal places.");

        Scanner roomStuff = new Scanner(System.in);  // Create a Scanner object

        System.out.print("\nEnter room length (metres): ");
        double roomL = roomStuff.nextDouble();  // Read user input
        System.out.print("Enter room width (metres): ");
        double roomW = roomStuff.nextDouble();
        System.out.print("Enter room height (metres): ");
        double roomH = roomStuff.nextDouble();

        double totalWallArea = 2*roomL*roomH + 2*roomW*roomH;
        double ceilingArea = roomL*roomW;

        System.out.print("\nDo you want to paint the ceiling? (1 for yes, 0 for no): ");
        byte ceiling = roomStuff.nextByte();
        if (!((ceiling == 0) || (ceiling == 1))) {
            System.out.println("Error: Valid number not entered. Assuming ceiling not being painted.");
            ceiling = 0;
        }

        System.out.print("\nEnter number of doors: ");
        double doors = roomStuff.nextDouble();
        System.out.print("Enter door width (metres): ");
        double doorW = roomStuff.nextDouble();
        System.out.print("Enter door height (metres): ");
        double doorH = roomStuff.nextDouble();

        double doorArea = doors * doorW * doorH;

        System.out.print("\nEnter numbers of windows: ");
        double windows = roomStuff.nextDouble();
        System.out.print("Enter window width (metres): ");
        double windowW = roomStuff.nextDouble();
        System.out.print("Enter window height (metres): ");
        double windowH = roomStuff.nextDouble();

        double windowArea = windows* windowW * windowH;
        if (doorArea + windowArea > totalWallArea) {
            System.out.println("\nError: Door and window area greater than wall area. Try again.");
            Main.main(args);
        }

        int sure;
        int ceilChoice = 0;
        int wallChoice;
        String[] colours = {"white", "red", "blue", "green"};
        do {
            for (int i = 0; i < colours.length; i++) {
                System.out.print("\nEnter " + i + " for " + colours[i] + ".");
            }
            System.out.print("\n\nWhat colour paint do you want for the walls from the options above?: ");
            wallChoice = roomStuff.nextInt();

            if (!((wallChoice == 0) || (wallChoice == 1) || (wallChoice == 2) || (wallChoice == 3))) {
                System.out.println("Error: Valid number not entered. Assuming you want white paint for the walls.");
                wallChoice = 0;
            }

            if (ceiling == 1) {
                for (int i = 0; i < colours.length; i++) {
                    System.out.print("\nEnter " + i + " for " + colours[i] + ".");
                }
                System.out.print("\n\nWhat colour paint do you want for the ceiling from the options above?: ");
                ceilChoice = roomStuff.nextInt();

                if (!((ceilChoice == 0) || (ceilChoice == 1) || (ceilChoice == 2) || (ceilChoice == 3))) {
                    System.out.println("Error: Valid number not entered. Assuming you want white paint for the walls.");
                    ceilChoice = 0;
                }
            }

            System.out.print("\nAre you sure you want " + colours[wallChoice] + " paint for the walls");
            if (ceiling == 1) {
                System.out.print(", and " + colours[ceilChoice] + " paint for the ceiling");
            }
            System.out.print("? (1 for yes, 0 for no): ");
            sure = roomStuff.nextInt();

        } while (!(sure == 1));

        System.out.print("\nEnter amount of paint in a can (litres): ");
        double canVolume = roomStuff.nextDouble();
        System.out.print("Enter square metre coverage per litre of paint (10 is average): ");
        double coverage = roomStuff.nextDouble();
        System.out.print("Enter price of a can: £");
        double canPrice = roomStuff.nextDouble();
        System.out.print("Enter number of coats of paint: ");
        double coats = roomStuff.nextDouble();

        double wallPaintArea = totalWallArea - (windowArea + doorArea);
        double paintingArea = wallPaintArea + ceiling*ceilingArea;
        double litres = (paintingArea /coverage)*coats;
        double wallLitres = (wallPaintArea /coverage)*coats;
        double ceilLitres = (ceilingArea/coverage)*coats;
        double litres10 = (paintingArea /coverage*1.1)*coats;
        double wallLitres10 = (wallPaintArea /coverage*1.1)*coats;
        double ceilLitres10 = (ceilingArea/coverage*1.1)*coats;
        int cans = (int) Math.ceil(litres/ canVolume);
        int wallCans = (int) Math.ceil(wallLitres / canVolume);
        int ceilCans = (int) Math.ceil(ceilLitres / canVolume);
        int cans10 = (int) Math.ceil(litres10/ canVolume);
        int wallCans10 = (int) Math.ceil(wallLitres10 / canVolume);
        int ceilCans10 = (int) Math.ceil(ceilLitres10 / canVolume);
        double price = (ceiling* ceilCans + wallCans)* canPrice;
        double price10 = (ceiling* ceilCans10 + wallCans10)* canPrice;

        //I think gareth said an easy way to get 2 decimal places using floats or something but don't remember

        System.out.println();

        for (int i = 0; i < 10; i++){
            System.out.println(10-i);
        }
        System.out.println("\nTA-DAH!");

        System.out.println("\nTotal area to paint is " + String.format("%.2f", paintingArea) + " metres squared.");
        if (ceiling == 1) {
            System.out.println("Wall area to paint is " + String.format("%.2f", wallPaintArea) + " metres squared.");
            System.out.println("Ceiling area to paint is " + String.format("%.2f", ceilingArea) + " metres squared.");
        }
        System.out.println("\nPaint needed is " + String.format("%.2f", litres) + " litres.");
        if (ceiling == 1) {
            System.out.println("Paint needed for the walls is " + String.format("%.2f", wallLitres) + " litres of " + colours[wallChoice] + " paint.");
            System.out.println("Paint needed for the ceiling is " + String.format("%.2f", ceilLitres) + " litres of " + colours[ceilChoice] + " paint.");
        }
        if (ceiling == 0) {
            System.out.println("Number of cans needed is " + cans + ".");
        } else {
            System.out.println("Number of cans needed for the walls is " + wallCans + ".");
            System.out.println("Number of cans needed for the ceiling is " + ceilCans + ".");
        }
        System.out.println("\nPaint needed with 10% extra is " + String.format("%.2f", litres10) + " litres.");
        if (ceiling == 1) {
            System.out.println("Paint needed for the walls with 10% extra is " + String.format("%.2f", wallLitres10) + " litres of " + colours[wallChoice] + " paint.");
            System.out.println("Paint needed for the ceiling with 10% extra is " + String.format("%.2f", ceilLitres10) + " litres of " + colours[ceilChoice] + " paint.");
        }
        if (ceiling == 0) {
            System.out.println("Number of cans needed with 10% extra paint is " + cans10 + ".");
        }else {
            System.out.println("Number of cans needed for the walls with 10% extra paint is " + wallCans10 + ".");
            System.out.println("Number of cans needed for the ceiling with 10% extra paint is " + ceilCans10 + ".");
        }
        System.out.println("\nPrice is £" + String.format("%.2f", price) + ".");
        System.out.println("Price for 10% extra paint is £" + String.format("%.2f", price10) + ".");

        System.out.print("\nWould you use this service again? (1 for yes, 0 for no): ");
        int reuse = roomStuff.nextInt();
        String reply1 = (reuse == 1) ? "Good to hear!\n" : "That's a shame...\n";
        System.out.println(reply1);

        while (reuse == 0) {
            System.out.print("Are you sure? (1 for yes, 0 for no): ");
            int annoying = roomStuff.nextInt();

            if (annoying == 0){
                System.out.print("\nWould you use this service again? (1 for yes, 0 for no): ");
                reuse = roomStuff.nextInt();
                reply1 = (reuse == 1) ? "Good to hear!\n" : "That's a shame...\n";
                System.out.println(reply1);
            }
        }

        System.out.print("What do you rate this service (0 (Awful) to 5 (Awesome)): ");
        double rating = roomStuff.nextDouble();


        System.out.println(ratingReply(rating));

        List<String> techClass3 = new ArrayList<>(); //can change ArrayList to LinkedList and it just works
        System.out.print("\nWould you like to suggest other colours of paint? (1 for yes, 0 for no): ");
        int suggest = roomStuff.nextInt();
        if (suggest == 1) {

            System.out.print("\nPlease suggest 3 colours.\n");
            for (int i = 0; i < 3; i++) {
                System.out.print("Colour number " + (i+1) + ": ");
                String newPaint = roomStuff.next();
                techClass3.add(i, newPaint);
            }
            System.out.print("\nYou suggested the colours:\n");
            for (String letter:techClass3) {
                System.out.println(letter);
            }
            System.out.println("\nThank you for the feedback!");
        }
        
        System.out.println("\nEND");
        System.out.println("-------------------------------------------------------------------------------------------------------------------------------");

        /*
        My room

        room length        2.5
        room width         3.8
        room height        2.5
        ceiling            1
        number of doors    1
        door width         0.7
        door height        2.1
        number of windows  1
        window width       1.2
        window height      1.2
        colour wall        2
        colour ceiling     0
        sure               1
        can volume         2.5
        litre coverage     10
        can price          10.99
        coats              2
        colour 1           purple
        colour 2           brown
        colour 3           lilac

        WooHoo
         */
    }
    public static String ratingReply(double rating) {
        double rating2 = rating;

        if (rating == 0) {
            rating = 1;
        }

        int ratingRounded = (int) Math.ceil(rating);

        return switch (ratingRounded) {
            case 1 -> "You gave a rating of " + rating2 + " (Awful).";
            case 2 -> "You gave a rating of " + rating2 + " (Bad).";
            case 3 -> "You gave a rating of " + rating2 + " (Whatever).";
            case 4 -> "You gave a rating of " + rating2 + " (Good).";
            case 5 -> "You gave a rating of " + rating2 + " (Awesome).";
            default -> "Error: Valid number not entered. Assuming you meant 5 (Awesome).";
        };
    }
}
