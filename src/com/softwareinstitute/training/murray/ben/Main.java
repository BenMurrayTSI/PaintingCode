package com.softwareinstitute.training.murray.ben;

import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {
        /*
        Assuming standard rectangular room with all doors and windows the same dimensions,
        and that the painter is painting all the walls (and ceiling) surface area,
        but not window frames or doors.
        */
        System.out.println("\n----------------------------------------------------------------------------------------------------------------------------");
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
            System.out.println("Error: 0 or 1 not entered. Assuming ceiling not being painted.");
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

        System.out.print("\nEnter amount of paint in a can (litres): ");
        double canvolume = roomstuff.nextDouble();
        System.out.print("Enter square metre coverage per litre of paint (10 is average): ");
        double coverage = roomstuff.nextDouble();
        System.out.print("Enter price of a can: £");
        double canprice = roomstuff.nextDouble();
        System.out.print("Enter number of coats of paint: ");
        double coats = roomstuff.nextDouble();

        double paintingarea = totalwallarea + ceiling*ceilingarea - (windowarea + doorarea);
        double litres = (paintingarea/coverage)*coats;
        double litres10 = (paintingarea/coverage*1.1)*coats;
        int cans = (int) Math.ceil(litres/canvolume);
        int cans10 = (int) Math.ceil(litres10/canvolume);
        double price = cans*canprice;
        double price10 = cans10*canprice;

        //I think gareth said an easy way to get 2 decimal places using floats or something but dont remember

        System.out.println();

        for (int i = 0; i < 10; i++){
            System.out.println(10-i);
        }
        System.out.println("\nTA-DAH!");

        System.out.println("\nTotal area to paint is " + String.format("%.2f", paintingarea) + " metres squared.");
        System.out.println("\nPaint needed is " + String.format("%.2f", litres) + " litres.");
        System.out.println("Number of cans needed is " + cans + ".");
        System.out.println("Price is £" + String.format("%.2f", price) + ".");
        System.out.println("\nPaint needed with 10% extra paint is " + String.format("%.2f", litres10) + " litres.");
        System.out.println("Number of cans needed with 10% extra paint " + cans10 + ".");
        System.out.println("Price is £" + String.format("%.2f", price10) + ".");

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
            case 1 -> "You gave a rating of 1 (Awful).\n";
            case 2 -> "You gave a rating of 2 (Bad).\n";
            case 3 -> "You gave a rating of 3 (Whatever).\n";
            case 4 -> "You gave a rating of 4 (Good).\n";
            case 5 -> "You gave a rating of 5 (Awesome).\n";
            default -> "Error: You didn't enter a number from 1 to 5. Assuming you meant 5 (Awesome).";
        };
        System.out.println(reply2);

        System.out.println("\nEND");

        /*
        My room

        room length        2.5
        room width         3.8
        room height        2.5
        ceiling            0
        number of doors    1
        door width         0.7
        door height        2.1
        number of windows  1
        window width       1.2
        window height      1.2
        can volume         2.5
        litre coverage     10
        can price          10.99
        coats              2

        painting area      28.59

        litres             5.72
        cans               3
        price              32.97

        litres 10          6.29
        cans 10            3
        price 10           32.97

        woo
         */
    }
}
