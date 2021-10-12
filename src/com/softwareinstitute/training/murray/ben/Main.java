package com.softwareinstitute.training.murray.ben;

import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {

        /*
        assuming standard rectangular room (with all doors and windows the same dimensions),
        and that the painter is painting all the walls, but not window frames, doors or the ceiling.
        */

        System.out.println("\nPlease only enter positive numbers, and only to at most 2 decimal places.\n");

        Scanner roomstuff = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Enter room length (metres): ");
        double rooml = roomstuff.nextDouble();  // Read user input
        System.out.print("Enter room width (metres): ");
        double roomw = roomstuff.nextDouble();
        System.out.print("Enter room height (metres): ");
        double roomh = roomstuff.nextDouble();

        double totalwallarea = 2*rooml*roomh + 2*roomw*roomh;

        System.out.print("Enter number of doors: ");
        double doors = roomstuff.nextDouble();
        System.out.print("Enter door width (metres): ");
        double doorw = roomstuff.nextDouble();
        System.out.print("Enter door height (metres): ");
        double doorh = roomstuff.nextDouble();

        double doorarea = doors*doorw*doorh;

        System.out.print("Enter numbers of windows: ");
        double windows = roomstuff.nextDouble();
        System.out.print("Enter window width (metres): ");
        double windoww = roomstuff.nextDouble();
        System.out.print("Enter window height (metres): ");
        double windowh = roomstuff.nextDouble();

        double windowarea = windows*windoww*windowh;
        if (doorarea + windowarea > totalwallarea) {
            System.out.println("\nError, door and window area greater than wall area. Try again.\n");
            Main.main(args);
        }

        System.out.print("Enter amount of paint in a can (litres): ");
        double canvolume = roomstuff.nextDouble();
        System.out.print("Enter square meter coverage per litre of paint (10 is average): ");
        double coverage = roomstuff.nextDouble();
        System.out.print("Enter price of a can: £");
        double canprice = roomstuff.nextDouble();

        double paintingarea = totalwallarea - (windowarea + doorarea);
        double litres = paintingarea/coverage;
        double litres10 = paintingarea/coverage*1.1;
        int cans = (int) Math.ceil(litres/canvolume);
        int cans10 = (int) Math.ceil(litres10/canvolume);
        double price = cans*canprice;
        double price10 = cans10*canprice;

        System.out.println("\nTotal wall area is " + paintingarea + " meters squared.");
        System.out.println("\nPaint needed is " + litres + " litres.");
        System.out.println("Number of cans needed is " + cans + ".");
        System.out.println("Price is £" + String.format("%.2f", price) + ".");
        System.out.println("\nPaint needed with 10% extra paint is " + litres10 + " litres.");
        System.out.println("Number of cans needed with 10% extra paint " + cans10 + ".");
        System.out.println("Price is £" + String.format("%.2f", price10) + ".");

        /*
        My room

        room length        2.5
        room width         3.8
        room height        2.5
        number of doors    1
        door width         0.7
        door height        2.1
        number of windows  1
        window width       1.2
        window height      1.2
        can volume         2.5
        litre coverage     10
        can price          10.99

        wall area          28.59
        cans               2
        price              21.98

        wall area 10       28.59
        cans 10            2
        price 10           21.98
         */
    }
}
