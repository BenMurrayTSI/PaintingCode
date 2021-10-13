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

        Scanner roomstuff = new Scanner(System.in);  // Create a Scanner object

        System.out.print("\nEnter room length (metres): ");
        double rooml = roomstuff.nextDouble();  // Read user input
        System.out.print("Enter room width (metres): ");
        double roomw = roomstuff.nextDouble();
        System.out.print("Enter room height (metres): ");
        double roomh = roomstuff.nextDouble();

        double totalwallarea = 2*rooml*roomh + 2*roomw*roomh;
        double ceilingarea = rooml*roomw;

        System.out.print("\nDo you want to paint the ceiling? (1 for yes, 0 for no): ");
        byte ceiling = roomstuff.nextByte();
        if (!((ceiling == 0) || (ceiling == 1))) {
            System.out.println("Error: Valid number not entered. Assuming ceiling not being painted.");
            ceiling = 0;
        }

        System.out.print("\nEnter number of doors: ");
        double doors = roomstuff.nextDouble();
        System.out.print("Enter door width (metres): ");
        double doorw = roomstuff.nextDouble();
        System.out.print("Enter door height (metres): ");
        double doorh = roomstuff.nextDouble();

        double doorarea = doors*doorw*doorh;

        System.out.print("\nEnter numbers of windows: ");
        double windows = roomstuff.nextDouble();
        System.out.print("Enter window width (metres): ");
        double windoww = roomstuff.nextDouble();
        System.out.print("Enter window height (metres): ");
        double windowh = roomstuff.nextDouble();

        double windowarea = windows*windoww*windowh;
        if (doorarea + windowarea > totalwallarea) {
            System.out.println("\nError: Door and window area greater than wall area. Try again.");
            Main.main(args);
        }

        int sure;
        int ceilchoice = 0;
        int wallchoice;
        String[] colours = {"white", "red", "blue", "green"};
        do {
            for (int i = 0; i < colours.length; i++) {
                System.out.print("\nEnter " + i + " for " + colours[i] + ".");
            }
            System.out.print("\n\nWhat colour paint do you want for the walls from the options above?: ");
            wallchoice = roomstuff.nextInt();

            if (!((wallchoice == 0) || (wallchoice == 1) || (wallchoice == 2) || (wallchoice == 3))) {
                System.out.println("Error: Valid number not entered. Assuming you want white paint for the walls.");
                wallchoice = 0;
            }

            if (ceiling == 1) {
                for (int i = 0; i < colours.length; i++) {
                    System.out.print("\nEnter " + i + " for " + colours[i] + ".");
                }
                System.out.print("\n\nWhat colour paint do you want for the ceiling from the options above?: ");
                ceilchoice = roomstuff.nextInt();

                if (!((ceilchoice == 0) || (ceilchoice == 1) || (ceilchoice == 2) || (ceilchoice == 3))) {
                    System.out.println("Error: Valid number not entered. Assuming you want white paint for the walls.");
                    ceilchoice = 0;
                }
            }

            System.out.print("\nAre you sure you want " + colours[wallchoice] + " paint for the walls");
            if (ceiling == 1) {
                System.out.print(", and " + colours[ceilchoice] + " paint for the ceiling");
            }
            System.out.print("? (1 for yes, 0 for no): ");
            sure = roomstuff.nextInt();

        } while (!(sure == 1));

        System.out.print("\nEnter amount of paint in a can (litres): ");
        double canvolume = roomstuff.nextDouble();
        System.out.print("Enter square metre coverage per litre of paint (10 is average): ");
        double coverage = roomstuff.nextDouble();
        System.out.print("Enter price of a can: £");
        double canprice = roomstuff.nextDouble();
        System.out.print("Enter number of coats of paint: ");
        double coats = roomstuff.nextDouble();

        double wallpaintarea = totalwallarea - (windowarea + doorarea);
        double paintingarea = wallpaintarea + ceiling*ceilingarea;
        double litres = (paintingarea/coverage)*coats;
        double walllitres = (wallpaintarea/coverage)*coats;
        double ceillitres = (ceilingarea/coverage)*coats;
        double litres10 = (paintingarea/coverage*1.1)*coats;
        double walllitres10 = (wallpaintarea/coverage*1.1)*coats;
        double ceillitres10 = (ceilingarea/coverage*1.1)*coats;
        int cans = (int) Math.ceil(litres/canvolume);
        int wallcans = (int) Math.ceil(walllitres/canvolume);
        int ceilcans = (int) Math.ceil(ceillitres/canvolume);
        int cans10 = (int) Math.ceil(litres10/canvolume);
        int wallcans10 = (int) Math.ceil(walllitres10/canvolume);
        int ceilcans10 = (int) Math.ceil(ceillitres10/canvolume);
        double price = (ceiling*ceilcans + wallcans)*canprice;
        double price10 = (ceiling*ceilcans10 + wallcans10)*canprice;

        //I think gareth said an easy way to get 2 decimal places using floats or something but dont remember

        System.out.println();

        for (int i = 0; i < 10; i++){
            System.out.println(10-i);
        }
        System.out.println("\nTA-DAH!");

        System.out.println("\nTotal area to paint is " + String.format("%.2f", paintingarea) + " metres squared.");
        if (ceiling == 1) {
            System.out.println("Wall area to paint is " + String.format("%.2f", wallpaintarea) + " metres squared.");
            System.out.println("Ceiling area to paint is " + String.format("%.2f", ceilingarea) + " metres squared.");
        }
        System.out.println("\nPaint needed is " + String.format("%.2f", litres) + " litres.");
        if (ceiling == 1) {
            System.out.println("Paint needed for the walls is " + String.format("%.2f", walllitres) + " litres of " + colours[wallchoice] + " paint.");
            System.out.println("Paint needed for the ceiling is " + String.format("%.2f", ceillitres) + " litres of " + colours[ceilchoice] + " paint.");
        }
        if (ceiling == 0) {
            System.out.println("Number of cans needed is " + cans + ".");
        } else {
            System.out.println("Number of cans needed for the walls is " + wallcans + ".");
            System.out.println("Number of cans needed for the ceiling is " + ceilcans + ".");
        }
        System.out.println("\nPaint needed with 10% extra is " + String.format("%.2f", litres10) + " litres.");
        if (ceiling == 1) {
            System.out.println("Paint needed for the walls with 10% extra is " + String.format("%.2f", walllitres10) + " litres of " + colours[wallchoice] + " paint.");
            System.out.println("Paint needed for the ceiling with 10% extra is " + String.format("%.2f", ceillitres10) + " litres of " + colours[ceilchoice] + " paint.");
        }
        if (ceiling == 0) {
            System.out.println("Number of cans needed with 10% extra paint is " + cans10 + ".");
        }else {
            System.out.println("Number of cans needed for the walls with 10% extra paint is " + wallcans10 + ".");
            System.out.println("Number of cans needed for the ceiling with 10% extra paint is " + ceilcans10 + ".");
        }
        System.out.println("\nPrice is £" + String.format("%.2f", price) + ".");
        System.out.println("Price for 10% extra paint is £" + String.format("%.2f", price10) + ".");

        System.out.print("\nWould you use this service again? (1 for yes, 0 for no): ");
        int reuse = roomstuff.nextInt();
        String reply1 = (reuse == 1) ? "Good to hear!\n" : "That's a shame...\n";
        System.out.println(reply1);

        while (reuse == 0) {
            System.out.print("Are you sure? (1 for yes, 0 for no): ");
            int annoying = roomstuff.nextInt();

            if (annoying == 0){
                System.out.print("\nWould you use this service again? (1 for yes, 0 for no): ");
                reuse = roomstuff.nextInt();
                reply1 = (reuse == 1) ? "Good to hear!\n" : "That's a shame...\n";
                System.out.println(reply1);
            }
        }

        System.out.print("What do you rate this service (1 (Awful) to 5 (Awesome)): ");
        int rating = roomstuff.nextInt();
        String reply2 = switch (rating) {
            case 1 -> "You gave a rating of 1 (Awful).";
            case 2 -> "You gave a rating of 2 (Bad).";
            case 3 -> "You gave a rating of 3 (Whatever).";
            case 4 -> "You gave a rating of 4 (Good).";
            case 5 -> "You gave a rating of 5 (Awesome).";
            default -> "Error: You didn't enter a number from 1 to 5. Assuming you meant 5 (Awesome).";
        };
        System.out.println(reply2);

        List<String> techClass3 = new ArrayList<>(); //can change ArrayList to LinkedList and it just works
        System.out.print("\nWould you like to suggest other colours of paint? (1 for yes, 0 for no): ");
        int suggest = roomstuff.nextInt();
        if (suggest == 1) {

            System.out.print("\nPlease suggest 3 colours.\n");
            for (int i = 0; i < 3; i++) {
                System.out.print("Colour number " + (i+1) + ": ");
                String newpaint = roomstuff.next();
                techClass3.add(i, newpaint);
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

        woohoo
         */
    }
}
