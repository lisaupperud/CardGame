package com.annalisa.cardgame.util;

import java.util.Scanner;

public class ScannerUtility {

    private static final Scanner sc = new Scanner(System.in);

    public static String scanString() {
        //return sc.nextLine().toLowerCase().trim();
        return sc.nextLine().trim();
    }

    public static int scanInt() {
        while (true) {
            String input = sc.nextLine();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Not a valid number – try again.");
            }
        }

    }

    public static void closeScanner() {
        sc.close();
    }
}
