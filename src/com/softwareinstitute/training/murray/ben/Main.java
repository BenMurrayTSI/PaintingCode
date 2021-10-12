package com.softwareinstitute.training.murray.ben;

import java.util.Scanner;  // Import the Scanner class

public class Main {

    public static void main(String[] args) {

        /*
        assuming standard rectangular room (with all doors and windows the same dimensions),
        and that the painter is painting all the walls, but not window frames, doors or the ceiling.
        */
        System.out.println("\nThis program assumes you want to paint all the walls of a rectangular room, and that you arent painting windows or doors.");

        System.out.println("\nPlease only enter positive numbers, and only to at most 2 decimal places.\n");

        Scanner roomstuff = new Scanner(System.in);  // Create a Scanner object

        System.out.print("Enter room length (metres): ");
        double rooml = roomstuff.nextDouble();  // Read user input
        System.out.print("Enter room width (metres): ");
        double roomw = roomstuff.nextDouble();
        System.out.print("Enter room height (metres): ");
        double roomh = roomstuff.nextDouble();

        double totalwallarea = 2*rooml*roomh + 2*roomw*roomh;
        double ceilingarea = rooml*roomw;

        System.out.print("Do you want to paint the ceiling? (1 for yes, 0 for no): ");
        byte ceiling = roomstuff.nextByte();
        if (!((ceiling == 0) || (ceiling == 1))) {
            System.out.println("Error: 0 or 1 not entered. Assuming ceiling not being painted.");
            ceiling = 0;
        }

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
            System.out.println("\nError: Door and window area greater than wall area. Try again.\n");
            Main.main(args);
        }

        System.out.print("Enter amount of paint in a can (litres): ");
        double canvolume = roomstuff.nextDouble();
        System.out.print("Enter square meter coverage per litre of paint (10 is average): ");
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

        //i think gareth said an easy way to get 2 decimal places using floats or something but dont remember

        System.out.println("\nTotal wall area is " + String.format("%.2f", paintingarea) + " meters squared.");
        System.out.println("\nPaint needed is " + String.format("%.2f", litres) + " litres.");
        System.out.println("Number of cans needed is " + cans + ".");
        System.out.println("Price is £" + String.format("%.2f", price) + ".");
        System.out.println("\nPaint needed with 10% extra paint is " + String.format("%.2f", litres10) + " litres.");
        System.out.println("Number of cans needed with 10% extra paint " + cans10 + ".");
        System.out.println("Price is £" + String.format("%.2f", price10) + ".");

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

        wall area          28.59

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
